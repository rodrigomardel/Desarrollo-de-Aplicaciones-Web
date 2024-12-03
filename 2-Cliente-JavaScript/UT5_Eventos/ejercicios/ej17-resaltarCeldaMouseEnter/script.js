/*
A partir del archivo HTML proporcionado, crear un script que resalte la celda sobre la que está el ratón.
Para resaltar la celda, se le asigna/desasigna la clase highlight.
El ejercicio se debe hacer utilizando mouseenter y mouseleave.
*/
let tds = document.querySelectorAll("td");

tds.forEach((td) => {
  td.addEventListener("mouseenter", resaltar);
  td.addEventListener("mouseleave", normalizar);
});

function resaltar(event) {
  event.target.classList.add("highlight");
}

function normalizar(event) {
  event.target.classList.remove("highlight");
}
