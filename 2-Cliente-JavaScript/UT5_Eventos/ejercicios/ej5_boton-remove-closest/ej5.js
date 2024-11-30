/*
Agrega el código JavaScript al ejercicio 5 que inserte un botón de cierre en la esquina superior 
derecha de cada mensaje (div con class="pane").

Al hacer click sobre ese botón, se debe eliminar el div en que está el botón.
*/
let botonCierre = document.querySelector(".remove-button");

let divs = document.querySelectorAll(".pane");

divs.forEach((div) => {
  let nuevoBotonCierre = botonCierre.cloneNode(true);
  nuevoBotonCierre.style.float = "right";
  div.prepend(nuevoBotonCierre);

  nuevoBotonCierre.addEventListener("click", () => {
    let div = nuevoBotonCierre.closest("div");
    div.remove();
  });
});
