/*
Crea el código necesario para esta página, de modo que:
•	Al hacer click en el botón Borrar, se borre el contenido del textarea.
•	Cuando el usuario escribe en el campo textarea, se guarda automáticamente su contenido en el navegador. Cuando el usuario abre la página de nuevo, encontrará el texto que estaba escribiendo en el textarea.
*/

let textarea = document.getElementById("area");

guardadoAutomatico();

function guardadoAutomatico() {
  textarea.addEventListener("input", (e) => {
    localStorage.setItem("nota", textarea.value);
  });
  textarea.value = localStorage.getItem("nota");
  borrarContenido();
}

function borrarContenido() {
  let botonBorrar = document.body.querySelector("button");
  botonBorrar.addEventListener("click", (e) => {
    textarea.value = "";
  });
}
