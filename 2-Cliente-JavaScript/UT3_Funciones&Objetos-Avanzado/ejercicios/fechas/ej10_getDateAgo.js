/*
Crea una función getDateAgo(fecha, días) que devuelva el día del mes que era descontando 
el número de días indicados de la fecha que se pasa como parámetro.
Por ejemplo, si hoy es 20, entonces getDateAgo(new Date(), 1) debería ser 19 y getDateAgo(new Date(), 2) 
debería ser 18.
Debe funcionar para días=365 o más.
No se debe modificar la fecha que se pasa como parámetro.
*/

let date = new Date(2015, 0, 2);

function getDateAgo(fecha, dias) {
  let diasFecha;
  let fechaResultante;

  diasFecha = date.getDate();

  fechaResultante = new Date(
    date.getFullYear(),
    date.getMonth(),
    diasFecha - dias
  );

  return fechaResultante;
}

alert(getDateAgo(date, 1)); // 1, (1 Jan 2015)
alert(getDateAgo(date, 2)); // 31, (31 Dec 2014)
alert(getDateAgo(date, 365)); // 2, (2 Jan 2014)
