/*
Puedes partir de los archivos localidadGETXHR.html y arraylocalidades.php.
Qué debe hacer la página:
•	Cuando el usuario introduzca el nombre de una localidad y pulse intro obtendrá, en el  <p id="resultado">, un mensaje que indicará si la ciudad está incluida dentro de una lista de ciudades o no. El mensaje será rojo si no está incluida y verde en caso afirmativo.
•	El archivo arraylocalidades.php comprueba que la localidad recibida por parámetro está o no incluida dentro de una lista de 10 localidades (ignora la diferencia entre mayúsculas y minúsculas). Devuelve “S” si está incluida y “N” si no está incluida.
*/

document.addEventListener("DOMContentLoaded", () => {
  let localidadUsuario = document.getElementById("localidad");

  localidadUsuario.addEventListener("keydown", comprobarLocalidad);

  function comprobarLocalidad(e) {
    if (e.key === "Enter") {
      let url =
        "./arraylocalidades.php?localidadUsuario=" + localidadUsuario.value;
      let xhr = new XMLHttpRequest();

      xhr.responseType = "txt";
      xhr.open("GET", url);

      xhr.addEventListener("load", () => {
        if (xhr.status != 200) {
          alert(`Error ${xhr.status}: ${xhr.statusText}`);
        } else {
          document.getElementById("resultado").innerText = xhr.response;
        }
      });

      xhr.send();

      console.log(localidadUsuario.value);
    }
  }
});
