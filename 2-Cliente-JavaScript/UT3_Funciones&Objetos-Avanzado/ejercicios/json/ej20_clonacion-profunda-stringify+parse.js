/*
20.	Utilizar los métodos de JSON para copiar arrays u objetos
Dado el siguiente código, haz una copia “profunda” de alum1, alum2 y clase utilizando los métodos de JSON. ¿De qué otro modo se podrían copiar?
*/
let alum1 = { nombre: "Fede", edad: 30, estudios: ["SMR"] };
let alum2 = { nombre: "Sol", edad: 25, estudios: [] };
let clase = ["DWEC", 126, alum1, alum2];

//Clonación profunda JSON
let alum1Copia = JSON.stringify(alum1);
let alum2Copia = JSON.stringify(alum2);
let claseCopia = JSON.stringify(clase);
console.log(JSON.parse(alum1Copia));
console.log(JSON.parse(alum2Copia));
console.log(JSON.parse(claseCopia));

//Clonación profunda structuredClone
let alum1CopiaA = structuredClone(alum1);
let alum2CopiaA = structuredClone(alum2);
let claseCopiaA = structuredClone(clase);
console.log(alum1);
console.log(alum2);
console.log(clase);
