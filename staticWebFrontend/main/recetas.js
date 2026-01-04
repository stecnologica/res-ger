let recetas = JSON.parse(localStorage.getItem("recetas")) || [];
let ingredientes = JSON.parse(localStorage.getItem("ingredientes")) || [];
let recetaIngredientes = JSON.parse(localStorage.getItem("recetaIngredientes")) || [];

const recetaSelect = document.getElementById("selectReceta");
const ingredienteSelect = document.getElementById("selectIngrediente");
const tabla = document.getElementById("tablaRecetaIngrediente");

// Cargar recetas
function cargarRecetas() {
  recetaSelect.innerHTML = "";
  recetas.forEach(r => {
    recetaSelect.innerHTML += `<option value="${r.id}">${r.nombre}</option>`;
  });
}

// Cargar ingredientes
function cargarIngredientes() {
  ingredienteSelect.innerHTML = "";
  ingredientes.forEach(i => {
    ingredienteSelect.innerHTML += `<option value="${i.id}">${i.nombre}</option>`;
  });
}

// Crear receta
document.getElementById("recetaForm").addEventListener("submit", e => {
  e.preventDefault();

  const receta = {
    id: Date.now(),
    nombre: document.getElementById("nombreReceta").value,
    descripcion: document.getElementById("descripcion").value
  };

  recetas.push(receta);
  localStorage.setItem("recetas", JSON.stringify(recetas));
  cargarRecetas();
  e.target.reset();
});

// Asociar ingrediente
function agregarIngrediente() {
  const data = {
    id_receta_fk: recetaSelect.value,
    id_ingrediente_fk: ingredienteSelect.value,
    cantidad: document.getElementById("cantidad").value
  };

  recetaIngredientes.push(data);
  localStorage.setItem("recetaIngredientes", JSON.stringify(recetaIngredientes));
  renderTabla();
}

// Render tabla
function renderTabla() {
  tabla.innerHTML = "";

  recetaIngredientes.forEach(ri => {
    const receta = recetas.find(r => r.id == ri.id_receta_fk);
    const ingrediente = ingredientes.find(i => i.id == ri.id_ingrediente_fk);

    tabla.innerHTML += `
      <tr>
        <td>${receta?.nombre}</td>
        <td>${ingrediente?.nombre}</td>
        <td>${ri.cantidad}</td>
      </tr>
    `;
  });
}

// Inicializar
cargarRecetas();
cargarIngredientes();
renderTabla();
