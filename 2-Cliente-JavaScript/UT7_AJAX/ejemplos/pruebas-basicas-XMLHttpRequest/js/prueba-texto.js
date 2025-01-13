let xhr = new XMLHttpRequest();
xhr.open("GET", "./txt/texto-prueba.txt");

xhr.addEventListener("load", () => {
  if (xhr.status != 200) {
    alert(`Error ${xhr.status}: ${xhr.statusText}`);
  } else {
    document.getElementById("texto").textContent = xhr.response;
  }
});
xhr.send();
