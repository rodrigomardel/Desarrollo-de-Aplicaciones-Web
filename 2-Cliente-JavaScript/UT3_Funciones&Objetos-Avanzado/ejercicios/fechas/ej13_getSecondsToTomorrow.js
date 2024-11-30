/*
13.	Segundos que faltan para el día de mañana
Crea una función getSecondsToTomorrow() que devuelva la cantidad de segundos que faltan para el día de mañana.
Por ejemplo, si ahora son las 23:00, entonces:
getSecondsToTomorrow() == 3600
*/
fecha = new Date(2024, 9, 23, 23, 0, 0);

function getSecondsToTomorrow(fecha) {
  let segundosResultantes;
  let diaSiguiente;
  let diffMilisegundo;

  diaSiguiente = new Date(
    fecha.getFullYear(),
    fecha.getMonth(),
    fecha.getDate() + 1
  );

  diffMilisegundo = diaSiguiente - fecha;
  segundosResultantes = diffMilisegundo / 1000;

  return segundosResultantes;
}

console.log(getSecondsToTomorrow(fecha));
