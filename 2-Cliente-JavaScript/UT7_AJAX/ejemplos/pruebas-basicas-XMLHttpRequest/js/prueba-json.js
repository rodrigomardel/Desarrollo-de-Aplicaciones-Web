let xhr = new XMLHttpRequest();
xhr.responseType = "json";
xhr.open("GET", "./json/texto-json.json");

xhr.addEventListener("load", () => {
  let p = document.getElementById("texto");

  if (xhr.status != 200) {
    alert(`Error ${xhr.status}: ${xhr.statusText}`);
  } else {
    //almacenamiento de la respuesta (array del json)
    let datos = xhr.response;
    //muestra del primer dato
    p.textContent = datos[0];
  }
});
xhr.send();
