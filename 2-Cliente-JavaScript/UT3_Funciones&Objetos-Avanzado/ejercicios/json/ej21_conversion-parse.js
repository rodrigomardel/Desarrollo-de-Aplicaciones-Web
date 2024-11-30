/*
21.	A partir del siguiente código, muestra en consola el doble de todos los valores de la cadena (es un JSON).
*/

let cadenaJSON = "[1, 2, 3, 2, 4, 6, 1]";

let conversionArray = JSON.parse(cadenaJSON);

conversionArray.forEach((elemento) => {
  console.log(elemento * 2);
});
