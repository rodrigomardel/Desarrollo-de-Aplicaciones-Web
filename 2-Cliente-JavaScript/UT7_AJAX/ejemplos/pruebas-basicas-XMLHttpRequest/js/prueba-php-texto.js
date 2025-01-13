let xhr = new XMLHttpRequest();
xhr.responseType = "txt";
xhr.open("GET", "./php/texto-prueba.php");

xhr.addEventListener("load", () => {
  let p = document.getElementById("texto");

  if (xhr.status != 200) {
    alert(`Error ${xhr.status}: ${xhr.statusText}`);
  } else {
    p.textContent = xhr.response;
  }
});
xhr.send();
