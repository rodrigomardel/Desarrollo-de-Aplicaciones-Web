/*
4.	Dados
Escribir un script que simule el lanzamiento de dos dados. Hacer uso de la función Math.random() para obtener 
números aleatorios entre 1 y 6 para cada uno de los lanzamientos de los dados.
Repetir 36.000 veces el lanzamiento de los dos dados; sumar el resultado de cada dado y anotarlo en un map.
Al final del programa se deben mostrar el número de veces que ha aparecido cada suma 
(ej. 2: ha salido 1.000 veces; 3: ha salido 950 veces; ...)
*/

function numRandom(min, max) {
  let numero;
  numero = min + Math.random() * (max + 1 - min);
  return Math.trunc(numero);
}

function dados() {
  let clave;
  let resultadoLanzamiento;

  let dados = new Map();
  for (let i = 1; i < 36001; i++) {
    resultadoLanzamiento = numRandom(1, 6) + numRandom(1, 6);
    //comprobacion si el lanzamiento se ha repetido
    if (dados.has(resultadoLanzamiento)) {
      //si existe, almacenamos clave como undefined y le damos valor
      clave = dados.get(resultadoLanzamiento);
      dados.set(resultadoLanzamiento, clave + 1);
    } else {
      // en caso contrario almacenamos lanzamiento
      dados.set(resultadoLanzamiento, 1);
    }
  }

  return dados;
}

let numDados = dados();
console.log(numDados);
