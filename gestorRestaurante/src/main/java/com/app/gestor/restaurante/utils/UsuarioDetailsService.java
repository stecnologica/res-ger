package com.app.gestor.restaurante.utils;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.app.gestor.restaurante.repository.UserApiRepository;
import com.app.gestor.restaurante.entity.UserApiEntity;

@Service
public class UsuarioDetailsService implements UserDetailsService {


    @Autowired
    private UserApiRepository userRepo;

    public UsuarioDetailsService(UserApiRepository userRepo) {

        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApiEntity user = userRepo.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Validación opcional del nombre de aplicación (si aplica)
    /*
    if (!user.getAppName().equals(applicationName)) {
        utilLogs.logApiError("Application name incorrect");
        throw new UsernameNotFoundException("Application name incorrect");
    }
    */

        // Crear el UserDetails con los datos del usuario
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserName())
                .password(user.getPassword())
                .build();

    }
}