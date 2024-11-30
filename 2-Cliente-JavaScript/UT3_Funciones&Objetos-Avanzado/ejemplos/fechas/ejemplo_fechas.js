let ultimoDia = new Date(2024, 9, 21);

console.log(ultimoDia.getDate());

//cambio de mes
ultimoDia.setMonth(10);
console.log(ultimoDia);

let unoNov = new Date(2024, 11, 1);
let hoy = new Date();

//diferencia de segundo con el día de hoy
let diff = unoNov - hoy;
let diasFaltan = diff / 1_000 / 60 / 60 / 24;
console.log(diasFaltan);

//ejemplo diferencia de fechas
let now = new Date();
let cumple = new Date(2025, 6, 12, 0, 0, 0, 0);
let tiempoRestante = cumple - now;

let dias = Math.trunc(tiempoRestante / 86_400_000); //86_400_000 milisegundos tiene un dia
tiempoRestante -= dias * 86_400_000; //volvemos a calcular los segundos para restarlo del tiempo restante y seguir calculando

let horas = Math.trunc(tiempoRestante / 3_600_000); //3_600_000 milisegundos tiene una hora
tiempoRestante -= horas * 3_600_000;

let minutos = Math.trunc(tiempoRestante / 60_000); //60_000 milisegundos tiene un minuto
tiempoRestante -= minutos * 60_000;

let segundos = Math.trunc(tiempoRestante / 1_000); //1_000 milisegundos tiene un minutos
tiempoRestante -= segundos * 1_000;

let resultado =
  dias +
  " dias, " +
  horas +
  " horas, " +
  minutos +
  " minutos, " +
  segundos +
  " segundos";

console.log(resultado);
/*
Qué dia de la semana tiene cada mes como primer día.
*/
// const DIAS = [
//   "Lunes",
//   "Martes",
//   "Miercoles",
//   "Jueves",
//   "Viernes",
//   "Sábado",
//   "Domingo",
// ];

// for (let i; i < 21; i++) {
//   let fecha = new Date(2024, i, 1);
//   console.log("El mes" + i + "tiene como primer día un" + DIAS[fecha.getDay()]);
// }

//v2 - optimizando, no se crea un objeto en cada iteración
const DIAS = [
  "Lunes",
  "Martes",
  "Miércoles",
  "Jueves",
  "Viernes",
  "Sábado",
  "Domingo",
];
let fecha = new Date(2024, 0, 1);

for (let i; i < 21; i++) {
  fecha.setMonth(i);
  console.log("El mes" + i + "tiene como primer día un" + DIAS[fecha.getDay()]);
}

/*función que recibe un año y un mes y devuelva el último día del mes actual*/

//se debe sumar uno al mes de javascript y pasar el dia cero para que interprete el último día del mes anterior
