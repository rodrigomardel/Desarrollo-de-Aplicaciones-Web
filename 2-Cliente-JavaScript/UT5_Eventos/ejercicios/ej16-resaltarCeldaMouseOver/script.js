/*
A partir del archivo HTML proporcionado, crear un script que resalte la celda sobre la que está el ratón.
Para resaltar la celda, se le asigna/desasigna la clase highlight.
El ejercicio se debe hacer utilizando mouseover y mouseout.
*/
let ultimoElemento;
let tabla = document.getElementById("table");

tabla.addEventListener("mouseover", (event) => {
  let target = event.target;
  let celda = target.closest("td");

  if (celda) {
    if (ultimoElemento) {
      ultimoElemento.classList.remove("highlight");
    }
    celda.classList.add("highlight");
    ultimoElemento = celda;
  }
});
