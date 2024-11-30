/*
14.	Fin de curso
Crea un programa que pida muestre el número de días que quedan desde hoy hasta 
el fin de curso (por ejemplo, el 23 de junio).
*/

let fecha = new Date();

function finCurso(fecha) {
  let añoActual = new Date().getFullYear();
  let fechaFinCurso = new Date(añoActual + 1, 5, 23);

  let diffMilisegundos = fechaFinCurso - fecha;
  let diasResultantes = Math.floor(diffMilisegundos / 1000 / 60 / 60 / 24);

  return diasResultantes;
}

console.log(finCurso(fecha));
