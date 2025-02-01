/**1.	Cuando se seleccione un CIFP, se mostrarán en la tabla, los ciclos que se imparten en ese CIFP.
La información está en el archivo “cifpCiclos.json”.
En cada fila de la tabla, habrá un botón: "Ver datos".
 */
let tbodyTabla;
let selectCifp;
let fileCiclos = new URL("./cifpCiclos.json", window.location.href);
let fileDatosPhp = new URL("./datos.php", window.location.href);
let divSalidaDatos;
let cifpCiclosGlobal = [];

document.addEventListener("DOMContentLoaded", inicio);

/** Carga principal */
function inicio() {
  divSalidaDatos = document.getElementById("datos");
  tbodyTabla = document.getElementById("tbody");

  selectCifp = document.getElementById("cifp");
  selectCifp.addEventListener("change", () => {
    mostrarCiclos();
  });

  cargarCiclos();
}

/**Muestra los datos de los ciclos del cifp seleccionado */
function mostrarCiclos(e) {
  tbodyTabla.innerHTML = "";
  divSalidaDatos.innerHTML = "";

  cifpCiclosGlobal.forEach((ciclo) => {
    if (ciclo.cifp == selectCifp.value) {
      let tr = document.createElement("tr");

      // Creación celdas
      let tdCodigo = document.createElement("td");
      tdCodigo.textContent = ciclo.ciclo.toUpperCase();

      let tdDescripcion = document.createElement("td");
      tdDescripcion.textContent = ciclo.desCiclo;

      let tdBoton = document.createElement("td");
      let boton = document.createElement("button");
      boton.textContent = "Ver datos";

      // Listener a cada boton
      boton.addEventListener("click", motrarDatosCiclos);
      tdBoton.append(boton);

      // Agregar celdas y filas
      tr.append(tdCodigo, tdDescripcion, tdBoton);
      tbodyTabla.append(tr);
    }
  });
}

/**2.	Al hacer click en el botón "Ver datos" se hará una llamada al servidor, al archivo "datos.php" pasando como parámetro el código del ciclo.
El servidor devolverá el texto "No encontrado", si no se encuentra el ciclo; o un objeto con los datos del ciclo. En este último caso, los datos se mostrarán en la parte inferior de la pantalla.
 */
function motrarDatosCiclos(e) {
  divSalidaDatos.innerHTML = "";
  let codCicloSeleccionado =
    e.target.parentElement.parentElement.cells[0].textContent;
  // Paso de parametro
  fileDatosPhp.searchParams.set("ciclo", codCicloSeleccionado);

  fetch(fileDatosPhp)
    .then((respuesta) => respuesta.text())
    .then((datos) => {
      let resultado = JSON.parse(datos);
      //Tratramiento
      if (resultado != "No encontrado") {
        divSalidaDatos.innerHTML = `<p>Código ciclo: ${resultado.codCiclo}</p><p>Ciclo: ${resultado.desCiclo}</p><p>Nivel: ${resultado.nivel}</p>`;
      } else {
        divSalidaDatos.innerHTML = "<p>Ciclo no encontrado</p>";
      }
    });
}

/**Cargar datos de los ciclos */
function cargarCiclos() {
  fetch(fileCiclos)
    .then((respuesta) => respuesta.json())
    .then((datos) => (cifpCiclosGlobal = datos));
}
