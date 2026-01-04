package com.app.gestor.restaurante.jwtconfig;


import com.app.gestor.restaurante.dto.res.DtoResponseApi;
import com.app.gestor.restaurante.utils.JwtUtil;
import com.app.gestor.restaurante.utils.UsuarioDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UsuarioDetailsService userDetailsService;

    public JwtAuthFilter(JwtUtil jwtUtil, UsuarioDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }




    private void exception(HttpServletResponse response, DtoResponseApi responseError) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json; charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse = mapper.writeValueAsString(responseError);
        response.getWriter().write(jsonResponse);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        String jwtInvalid = "JWT invalid";
        try {
            final String authorizationHeader = request.getHeader("Authorization");

            String username = null;
            String jwt = null;

            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                username = jwtUtil.extractUsername(jwt);
            }
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);



                    if (jwtUtil.validateToken(jwt, userDetails)) {
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }

            }
            filterChain.doFilter(request, response);

        } catch (ExpiredJwtException e) {
            System.out.println("Token expired ---> " + e.getMessage());
            DtoResponseApi responseError = new DtoResponseApi(false, "TK-002", jwtInvalid);
            exception(response, responseError);
            logger.error(e);
        } catch (SignatureException e) {
            System.out.println("Token error signature ---> " + e.getMessage());
            DtoResponseApi responseError = new DtoResponseApi(false, "TK-003", jwtInvalid);
            exception(response, responseError);
            logger.error(e);
        } catch (IOException e) {
            System.out.println("Token error ---> " + e.getMessage());
            DtoResponseApi responseError = new DtoResponseApi(false, "TK-004", jwtInvalid);
            exception(response, responseError);
            logger.error(e);
        } catch (Exception e) {
            System.out.println("Excepcion no controlada en token---> " + e.getMessage() + " ------> Revise el usuario, contraseña o si expiró el token");
            DtoResponseApi responseError = new DtoResponseApi(false, "TK-000", "Error validando o generando el token");
            exception(response, responseError);
            logger.error(e);
        }
    }


}
