/*
Escribe una función getWeekDay(date) que devuelva el día de la semana en formato corto: 
‘MO’, ‘TU’, ‘WE’, ‘TH’, ‘FR’, ‘SA’, ‘SU’.
Por ejemplo:
*/

let date = new Date(2012, 0, 3); // 3 Jan 2012
const diaSemana = ["MO", "TU", "WE", "TH", "FR", "SA", "SU"];

function getWeekDay(date) {
  let resultado;
  resultado = diaSemana[date.getDay() - 1];
  return resultado;
}

alert(getWeekDay(date)); // debería mostrar "TU"
