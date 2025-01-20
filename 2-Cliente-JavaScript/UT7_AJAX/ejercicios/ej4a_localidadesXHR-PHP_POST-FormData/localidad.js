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
      let url = new URL("./arraylocalidades.php", window.location.href);
      let xhr = new XMLHttpRequest();

      xhr.responseType = "text";
      xhr.open("POST", url);

      let formData = new FormData();
      formData.append("localidadUsuario", localidadUsuario.value.trim());

      xhr.addEventListener("load", () => {
        if (xhr.status != 200) {
          alert(`Error ${xhr.status}: ${xhr.statusText}`);
        } else {
          let resultado = document.getElementById("resultado");
          if (xhr.response == "S") {
            resultado.style.color = "green";
            resultado.innerText = `La localidad ${localidadUsuario.value} está incluida`;
          } else {
            resultado.style.color = "red";
            resultado.innerText = `La localidad ${localidadUsuario.value} NO está incluida`;
          }
        }
      });

      xhr.send(formData);
    }
  }
});
