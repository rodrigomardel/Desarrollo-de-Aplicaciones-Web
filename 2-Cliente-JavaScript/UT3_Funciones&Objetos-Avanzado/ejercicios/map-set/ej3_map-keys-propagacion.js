/*
3.	Claves iterables
Nos gustaría obtener un array de map.keys() en una variable y luego aplicarle métodos específicos de arrays, ej. push().
*/

//Pero esto no funciona:
let map = new Map();
map.set("name", "John");
let keys = map.keys();
// Error: keys.push no es una función
//keys.push("more");

//¿Por qué? ¿Cómo podemos arreglar el código para que funcione key.push()?

// En la variable «keys» que está almacenado un iterador de claves, el cual no contiene el método push.
// Podemos convertir el iterador en un array con propagacion:

let keys1 = [...map.keys()]; // Convertimos el iterador a un array
keys1.push("more");

console.log(keys1); // ["name", "more"]
