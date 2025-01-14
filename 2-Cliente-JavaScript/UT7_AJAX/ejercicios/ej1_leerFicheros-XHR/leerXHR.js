/*
Utiliza la página lectorFicherosXHR.html, no se puede cambiar.
Qué debe hacer la página:
•	El campo de texto, nada más cargarse la página, se muestre la URL de la misma (window.location). Ese campo se puede editar por el usuario. 
•	Al hacer clic sobre el botón, se cargará en un textarea el contenido del archivo indicado en el campo de texto. 
•	El textarea, inicialmente estará vacío. 
•	Los mensajes de error también aparecerán en el textarea.
*/

document.addEventListener("DOMContentLoaded", () => {
  let textArea = document.getElementById("contenido");
  let inputUrl = document.getElementById("url");
  let boton = document.getElementById("mostrar");

  //carga url
  inputUrl.value = window.location;

  //carga contenido hola.txt
  boton.addEventListener("click", cargarContenido);

  function cargarContenido() {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "./hola.txt");

    xhr.addEventListener("load", () => {
      if (xhr.status != 200) {
        textArea.textContent = `Error ${xhr.status}: ${xhr.statusText}`;
      } else {
        textArea.textContent = xhr.response;
      }
    });

    xhr.send();
  }
});
