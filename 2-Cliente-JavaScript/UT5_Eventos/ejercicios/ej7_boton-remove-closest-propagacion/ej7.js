/*
Modifica el ejercicio 5 para gestionar los eventos con el patrón de delegación de eventos, es decir, 
debe haber solamente un event listener en el contenedor de todos los div.
*/
let botonCierre = document.querySelector(".remove-button");
let divs = document.querySelectorAll(".pane");

//clonar botón en cada contenedor.
divs.forEach((div) => {
  let nuevoBotonCierre = botonCierre.cloneNode(true);
  nuevoBotonCierre.style.float = "right";
  div.prepend(nuevoBotonCierre);
});

//propagación de evento
let body = document.body;
body.addEventListener("click", borrarContenedor);

function borrarContenedor(event) {
  let target = event.target;
  if (target.tagName == "BUTTON") {
    let div = target.closest("div");
    div.remove();
  }
}
