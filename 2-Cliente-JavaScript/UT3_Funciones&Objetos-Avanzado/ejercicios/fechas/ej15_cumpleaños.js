/*
Crea un script que te pida el día y mes de tu cumpleaños (pero que no te pida el año) 
y calcule el número de milisegundos y días que faltan hasta esa fecha.
Además, que saque todos los años en que tu cumpleaños va a caer en domingo, desde el próximo cumpleaños hasta el 2100.
*/

function cumpleaños() {
  let diffMilisegundos;
  let resultado;
  let añosCumpleDomingo = [];

  let añoActual = new Date().getFullYear() + 1;
  let diaCumpleaños = prompt("Introduzca su día de nacimiento");
  let mesCumpleaños = prompt("Introduzca su mes de nacimiento");

  let fechaDeHoy = new Date();
  let fechaCumpleaños = new Date(añoActual, mesCumpleaños - 1, diaCumpleaños);

  diffMilisegundos = fechaCumpleaños - fechaDeHoy;

  for (let i = añoActual; i < 2100; i++) {
    fechaCumpleaños.setFullYear(i); // cambia año
    if (fechaCumpleaños.getDay() == 0) {
      añosCumpleDomingo.push(i);
    }
  }

  return (resultado =
    `${diffMilisegundos} milisegundos   ` +
    Math.floor(diffMilisegundos / 1000 / 60 / 60 / 24) +
    " días. \nLos años que el cumpleaños cae en domingo son: " +
    añosCumpleDomingo.join("-"));
}

let diasHastaMiCumple = cumpleaños();
console.log(diasHastaMiCumple);
