/*
En los países europeos se cuentan los días de la semana a partir del lunes (número 1), 
seguido del martes (número 2), hasta el domingo (número 7). Escribe una función getLocalDay(date) 
que devuelva el día de la semana “europeo” para la variable date.
*/

let date = new Date(2012, 0, 3); // 3 Jan 2012
const diasSemana = [
  "Monday", // 1 -> Lunes
  "Tuesday", // 2 -> Martes
  "Wednesday", // 3 -> Miércoles
  "Thursday", // 4 -> Jueves
  "Friday", // 5 -> Viernes
  "Saturday", // 6 -> Sábado
  "Sunday", // 0 -> Domingo
];

function getLocalDay(date) {
  let resultado;

  resultado =
    "It's " +
    diasSemana[date.getDay() - 1] +
    " day " +
    date.getDay() +
    " of the week";

  return resultado;
}

alert(getLocalDay(date)); // tuesday, debería mostrar 2
