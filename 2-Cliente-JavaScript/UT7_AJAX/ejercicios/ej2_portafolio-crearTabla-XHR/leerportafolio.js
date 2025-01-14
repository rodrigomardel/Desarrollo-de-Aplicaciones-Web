/*
Partiendo del fichero JSON portafolio.json, muestra en una tabla toda la información que contiene ese fichero, utilizando AJAX.
*/
document.addEventListener("DOMContentLoaded", () => {
  let contenedor = document.getElementById("contenido");
  let tabla = document.createElement("table");
  tabla.style.border = "2px solid black";

  contenedor.append(tabla);

  cargarInfo();

  //carga JSON formato tabla
  function cargarInfo() {
    let xhr = new XMLHttpRequest();
    xhr.responseType = "json";
    xhr.open("GET", "./portafolio.json");

    xhr.addEventListener("load", () => {
      if (xhr.status !== 200) {
        alert(`Error ${xhr.status}: ${xhr.statusText}`);
      } else {
        let datos = xhr.response;

        datos.fechas.forEach((element) => {
          let tr = document.createElement("tr");

          let tdTitulo = document.createElement("td");
          tdTitulo.style.border = "1px solid black";
          tdTitulo.textContent = element.titulo;

          let tdFecha = document.createElement("td");
          tdFecha.style.border = "1px solid black";
          tdFecha.textContent = element.fecha;

          let tdTexto = document.createElement("td");
          tdTexto.style.border = "1px solid black";
          tdTexto.textContent = element.texto;

          tr.append(tdTitulo);
          tr.append(tdFecha);
          tr.append(tdTexto);

          tabla.append(tr);
        });
      }
    });

    xhr.send();
  }
});
