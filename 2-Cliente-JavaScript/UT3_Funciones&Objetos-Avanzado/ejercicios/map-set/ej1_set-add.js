/*
1.	Filtrar elementos únicos del array
Escribe una funcion unicos(arr) que recibe un array y devuelve un array con los elementos únicos de arr.
*/

let values = [
  "Hare",
  "Krishna",
  "Hare",
  "Krishna",
  "Krishna",
  "Krishna",
  "Hare",
  "Hare",
  ":-O",
];

function unicos(array) {
  let valoresUnicos;

  //al set se le puede pasar un array
  valoresUnicos = new Set();

  for (const element of array) {
    valoresUnicos.add(element);
  }

  return valoresUnicos;
}
console.log(unicos(values)); // Hare, Krishna, :-O
