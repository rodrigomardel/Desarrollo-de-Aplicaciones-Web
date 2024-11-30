/*
Crea un script con una función que muestra un mensaje (un alert) cuando han pasado 10 segundos 
desde que has abierto la página.
Esa función se incluye en el documento 47-crono.html.
*/

let campo = document.getElementById("hora");

setInterval(function () {
  let hora = new Date();
  let texto = hora.getHours();
  texto += ": " + hora.getMinutes();
  texto += ": " + hora.getSeconds();
  campo.value = texto;
}, 1000);

setTimeout(() => {
  alert("Han pasado 10 segundos");
}, 10000);
