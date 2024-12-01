/*
Haz que, al hacer clic en los enlaces (<a>) que están dentro del elemento con id="contents", 
pregunten al usuario si realmente quiere ir a esa dirección, y si no quiere ir, no se irá.

Importante:
    •	Se debe utilizar delegación de eventos
    •	Dentro del <a> puede haber otra etiqueta (ej. <i>)
*/

let fieldset = document.getElementById("contents");
fieldset.addEventListener("click", confirmacion);

function confirmacion(event) {
  let linkTarget = event.target.closest("a");

  if (linkTarget) {
    let resultado = confirm("¿Desea ir realmente a la dirección?");
    resultado == true ? target.src : event.preventDefault();
  }
}
