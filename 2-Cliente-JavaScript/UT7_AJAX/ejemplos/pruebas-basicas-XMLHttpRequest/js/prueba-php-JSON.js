let xhr = new XMLHttpRequest();
//sustituye al JSON
xhr.responseType = "json";
xhr.open("GET", "./php/objeto-JSON.php");

xhr.addEventListener("load", () => {
  let p = document.getElementById("texto");

  if (xhr.status != 200) {
    alert(`Error ${xhr.status}: ${xhr.statusText}`);
  } else {
    let datos = xhr.response;
    console.log(datos);
    p.innerHTML = "Nombre: " + datos.nombre + "<br> Edad: " + datos.edad;
  }
});
xhr.send();
