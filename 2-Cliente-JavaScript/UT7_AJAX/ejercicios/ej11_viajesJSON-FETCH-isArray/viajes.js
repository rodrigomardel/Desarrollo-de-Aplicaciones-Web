/*
Crea una página web formada por:
•	Una lista desplegable donde se encuentre el listado de orígenes posibles y otro para los destinos.
•	Al cargar la página web, se obtendrá del servidor el archivo viajes.json y se cargará en el primer desplegable, la lista de orígenes posibles.
•	Una vez seleccionado uno de los orígenes, se mostrará la lista de destinos para ese origen.
*/
let selectOrigen;
let selectDestino;

document.addEventListener("DOMContentLoaded", inicio);

/** Después de cargar del DOM llama al servidor para obtener los datos del origen y destinos */
function inicio() {
  let url = new URL("./viajes.json", window.location.href);
  document.querySelector("[type='submit']");

  fetch(url)
    .then((respuesta) => {
      if (!respuesta.ok) {
        throw new Error(`HTTP error! Status: ${respuesta.status}`);
      }
      return respuesta.json();
    })
    .then((datos) => {
      mostrarOrigenes(datos);
    });
}

/** Muestra los datos de los origenes */
function mostrarOrigenes(datos) {
  selectOrigen = document.getElementById("origen");

  // Creación opciones de los origenes
  datos.forEach((viaje) => {
    opcionOrigen = new Option(viaje.ORIGEN, viaje.ORIGEN);
    selectOrigen.append(opcionOrigen);
  });

  // Agregar destinos del origen por defecto
  mostrarDestinos(datos);

  // Evento para mostrar los destinos del origen correspondiente
  selectOrigen.addEventListener("change", (e) => {
    mostrarDestinos(datos);
  });
}

/** Muestra los datos de los destinos */
function mostrarDestinos(datos) {
  selectDestino = document.getElementById("destino");
  let origenSeleccionado = selectOrigen.value;

  // Limpiar destino anteriores
  selectDestino.innerHTML = "";

  // Buscamos el origen seleccionado en los datos y mostramos sus destinos
  datos.forEach((viaje) => {
    if (viaje.ORIGEN === origenSeleccionado) {
      // Añade las opciones de destino al select
      viaje.DESTINOS.DESTINO.forEach((destino) => {
        let opcionDestino = new Option(destino, destino);
        selectDestino.append(opcionDestino);
      });
    }
  });
}

//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////
// **Notas** -> en el caso de que haya que comprobar si los destinos están almacenados en un array o no (viajes1.json)
// if (Array.isArray(viaje.DESTINOS.DESTINO)) {
//   viaje.DESTINOS.DESTINO.forEach((destino) => {
//     console.log(destino);
//     let opcionDestino = new Option(destino, Object.keys(destino)[0]);
//     selectDestino.append(opcionDestino);
//   });
// } else {
//   opcionDestino = new Option(
//     viaje.DESTINOS.DESTINO,
//     Object.keys(destino)[0]
//   );
//   selectDestino.append(opcionDestino);
// }
