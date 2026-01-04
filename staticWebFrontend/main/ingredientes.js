const proveedores = JSON.parse(localStorage.getItem("proveedores")) || [];
const ingredientes = JSON.parse(localStorage.getItem("ingredientes")) || [];

const proveedorSelect = document.getElementById("proveedor");
const tabla = document.getElementById("tablaIngredientes");
const form = document.getElementById("ingredienteForm");

// Cargar proveedores en select
proveedores.forEach(p => {
  proveedorSelect.innerHTML += `<option value="${p.nombre}">${p.nombre}</option>`;
});

// Calcular valor por gramo
document.getElementById("precio").addEventListener("input", calcular);
document.getElementById("peso").addEventListener("input", calcular);
document.getElementById("unidad").addEventListener("change", calcular);

function calcular() {
  const precio = document.getElementById("precio").value;
  let peso = document.getElementById("peso").value;
  const unidad = document.getElementById("unidad").value;

  if (unidad === "kg") peso *= 1000;

  if (precio && peso) {
    document.getElementById("valorGramo").value = (precio / peso).toFixed(2);
  }
}

// Guardar ingrediente
form.addEventListener("submit", e => {
  e.preventDefault();

  const ingrediente = {
    nombre: document.getElementById("nombreIngrediente").value,
    marca: document.getElementById("marca").value,
    peso: document.getElementById("peso").value,
    unidad: document.getElementById("unidad").value,
    precio: document.getElementById("precio").value,
    valorGramo: document.getElementById("valorGramo").value,
    proveedor: proveedorSelect.value
  };

  ingredientes.push(ingrediente);
  localStorage.setItem("ingredientes", JSON.stringify(ingredientes));
  renderTabla();
  form.reset();
});

function renderTabla() {
  tabla.innerHTML = "";
  ingredientes.forEach(i => {
    tabla.innerHTML += `
      <tr>
        <td>${i.nombre}</td>
        <td>${i.marca}</td>
        <td>${i.peso} ${i.unidad}</td>
        <td>$${i.precio}</td>
        <td>$${i.valorGramo}</td>
        <td>${i.proveedor}</td>
      </tr>
    `;
  });
}

renderTabla();
