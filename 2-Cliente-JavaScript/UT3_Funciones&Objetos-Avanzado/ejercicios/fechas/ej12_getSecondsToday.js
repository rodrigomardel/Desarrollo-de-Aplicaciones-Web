/*
12.	Segundos que transcurrieron del día de hoy
Escribe una función getSecondsToday() que devuelva la cantidad de segundos transcurridos desde el comienzo del día.
Por ejemplo, si en este momento fueran las 10:00 am, sin horario de verano, entonces:
getSecondsToday() == 36000 /
*/
fecha = new Date(2024, 9, 23, 10, 0, 0);

function getSecondsToday(fecha) {
  let comienzoDia = new Date(
    fecha.getFullYear(),
    fecha.getMonth(),
    fecha.getDate()
  );

  return (fecha.getTime() - comienzoDia.getTime()) / 1000;
}

console.log(getSecondsToday(fecha));
