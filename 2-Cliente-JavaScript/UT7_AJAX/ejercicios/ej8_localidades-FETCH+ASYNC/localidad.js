/*
Puedes partir de los archivos localidadGETXHR.html y arraylocalidades.php.
Qué debe hacer la página:
•	Cuando el usuario introduzca el nombre de una localidad y pulse intro obtendrá, en el  <p id="resultado">, un mensaje que indicará si la ciudad está incluida dentro de una lista de ciudades o no. El mensaje será rojo si no está incluida y verde en caso afirmativo.
•	El archivo arraylocalidades.php comprueba que la localidad recibida por parámetro está o no incluida dentro de una lista de 10 localidades (ignora la diferencia entre mayúsculas y minúsculas). Devuelve “S” si está incluida y “N” si no está incluida.

** EXT: utiliza promesas en lugar de  XMLHttpRequest.
*/
let url, localidadUsuario;

document.addEventListener("DOMContentLoaded", inicio);

/** Carga inicial despúes del DOM*/
function inicio() {
  localidadUsuario = document.getElementById("localidad");
  url = new URL("./arraylocalidades.php", window.location.href);

  // Lanza evento para comprobar la localidad
  localidadUsuario.addEventListener("keydown", (e) => {
    if (e.key === "Enter") {
      url.searchParams.set("localidadUsuario", localidadUsuario.value);
      cargarContenido(url);
    }
  });
}

/** Carga de datos del servidor */
async function cargarContenido(url) {
  try {
    let respuesta = await fetch(url);
    if (respuesta.ok) {
      // Devuelve respuesta
      datosRespuesta = await respuesta.text();
      // Tratamiento
      if (datosRespuesta == "S") {
        resultado.style.color = "green";
        resultado.innerText = `La localidad ${localidadUsuario.value} está incluida`;
      } else {
        resultado.style.color = "red";
        resultado.innerText = `La localidad ${localidadUsuario.value} NO está incluida`;
      }
    } else {
      // Lanza error
      throw new Error(respuesta.statusText);
    }
  } catch (error) {
    // Error de red
    console.error(error.message);
  }
}
