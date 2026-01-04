const form = document.getElementById("proveedorForm");
const tabla = document.getElementById("tablaProveedores");

let proveedores = JSON.parse(localStorage.getItem("proveedores")) || [];

renderTabla();

form.addEventListener("submit", (e) => {
  e.preventDefault();

  const proveedor = {
    nombre: document.getElementById("nombre").value,
    producto: document.getElementById("producto").value,
    marca: document.getElementById("marca").value,
    segmento: document.getElementById("segmento").value,
    telefono: document.getElementById("telefono").value,
    direccion: document.getElementById("direccion").value,
  };

  proveedores.push(proveedor);
  localStorage.setItem("proveedores", JSON.stringify(proveedores));
  renderTabla();
  form.reset();
});

function renderTabla() {
  tabla.innerHTML = "";
  proveedores.forEach(p => {
    tabla.innerHTML += `
      <tr>
        <td>${p.nombre}</td>
        <td>${p.producto}</td>
        <td>${p.marca}</td>
        <td>${p.segmento}</td>
        <td>${p.telefono}</td>
        <td>${p.direccion}</td>
      </tr>
    `;
  });
}
