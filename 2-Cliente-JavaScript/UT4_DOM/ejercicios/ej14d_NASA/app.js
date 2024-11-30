/*
La página https://api.nasa.gov/ proporciona APIs (Application Programming Interface, 
interfaz de programación de aplicaciones) para proporcionar información de distinto tipo. 

En el documento ejercicio-14d/index.html, hay una función que recupera datos accediendo a una API, 
y pasa esos datos a la función mostrarDatos. 

Escribe el código de mostrarDatos para que esa información se muestre en pantalla. 
En la misma carpeta tienes una imagen para ver el resultado que se obtendría el día 11/11/2024. 
(*) Ejercicio basado en https://www.youtube.com/watch?v=nvgeFhLaSuA. 
*/
document.addEventListener("DOMContentLoaded", obtenerDatos);

function obtenerDatos() {
  const NASA_API = "DEMO_KEY";
  const ruta = `https://api.nasa.gov/planetary/apod?api_key=${NASA_API}`;

  fetch(ruta)
    .then((respuesta) => respuesta.json())
    .then((resultado) => mostrarDatos(resultado));
}
function mostrarDatos(resultado) {
  for (const element of Object.keys(resultado)) {
    console.log(element);
  }

  const titulo = document.getElementById("titulo");
  titulo.innerHTML = resultado.title;

  const fecha = document.getElementById("fecha");
  fecha.innerHTML = resultado.date;

  const descripcion = document.getElementById("descripcion");
  descripcion.innerHTML = resultado.explanation;

  const multimedia = document.getElementById("c_multimedia");
  if (resultado.media_type == "video") {
    multimedia.innerHTML = `<iframe class="embed-responsive-item" src="${resultado.url}"></iframe>`;
  } else {
    multimedia.innerHTML = `<img src="${resultado.url}" alt="${resultado.url}"`;
  }
}
