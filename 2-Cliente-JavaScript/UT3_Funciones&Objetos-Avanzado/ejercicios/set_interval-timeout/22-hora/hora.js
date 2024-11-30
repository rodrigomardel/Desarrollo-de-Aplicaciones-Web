let campo = document.getElementById("hora");
// campo.value = cadena de texto

/*
Crea un script con una función que muestre la hora en formato 
hora: minutos : segundos cada segundo en el campo con id=hora.
Esa función se incluye en el documento 46-hora.html.
*/
setInterval(function () {
  let hora = new Date();

  let texto = hora.getHours();
  texto += ": " + hora.getMinutes();
  texto += ": " + hora.getSeconds();

  campo.value = texto;
}, 1000);
