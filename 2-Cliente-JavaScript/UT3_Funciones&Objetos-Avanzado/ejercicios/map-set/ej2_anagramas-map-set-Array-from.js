/*
2.	Filtrar anagramas
Un anagrama es una palabra que resulta de la trasposición de todas las letras de otra palabra. Por ejemplo:
nap - pan
ear - are - era
cheaters - hectares - teachers

Escribe una función limpiar(arr) que recibe un array de palabras y devuelve un array sin anagramas.
let arr = ["nap", "teachers", "cheaters", "PAN", "ear", "era", "hectares"];
alert( limpiar(arr) ); // "nap,teachers,ear" o "PAN,cheaters,era"

Cómo hacerlo:
•	Para cada palabra
o	Dividir la palabra en letras y ordenar esas letras
o	Almacenar en un map, como clave, la palabra con las letras ordenadas, y como valor, la palabra
•	Para convertir el map en un array:
o	Array.from(map.values())
•	También se podría utilizar un objeto plano, en lugar de un Map, porque las claves son objetos planos
*/
/*
 * Escribe una función limpiar(arr) que recibe un array de palabras y devuelve un array sin anagramas.
 */

let arr = ["nap", "teachers", "cheaters", "PAN", "ear", "era", "hectares"];

alert(limpiar(arr)); // "nap,teachers,ear"

function limpiar(arr) {
  let map = new Map();

  for (const palabra of arr) {
    map.set(palabra.split("").sort().toString().toLowerCase(), palabra);
  }

  return Array.from(map.values());
}
