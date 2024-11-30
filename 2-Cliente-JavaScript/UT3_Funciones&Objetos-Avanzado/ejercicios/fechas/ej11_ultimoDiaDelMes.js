/*
Escribe una función getLastDayOfMonth(year, month) que devuelva 
el último día del mes dado. 
A veces es 30, 31 o incluso 28/29 para febrero.
Parámetros:
year – el año en formato de cuatro dígitos, por ejemplo 2012.
month – el mes, de 0 a 11.
*/

function getLastDayOfMonth(año, mes) {
  let fecha;
  let resultado;

  fecha = new Date(año, mes + 1, 0);
  resultado = `Último día del mes: ${fecha.getDate()}`;

  return resultado;
}

alert(getLastDayOfMonth(2012, 1)); // 29 (febrero, año bisiesto).
alert(getLastDayOfMonth(2025, 1)); // 28 (febrero).
alert(getLastDayOfMonth(2000, 11)); // 31 (diciembre).

//new Date(2024, 1, 35); // Se convierte en 6 de marzo de 2024 (35 - 29 días de febrero)
