let primerNumero, segundoNumero;
let suma;

primerNumero = prompt("Dime un número");
segundoNumero = prompt("Dime otro número");

/*
Si ponemos los números sin el uso de la función de conversión
lo interpreta como String y concatena los números.
*/

suma = parseInt(primerNumero) + parseInt(segundoNumero);
//alert("La suma de los números es" + suma);

alert(`La suma de los números es ${suma}`); //En estas cadenas se pueden insertar expresiones encerrándolas entre ${ … }.
