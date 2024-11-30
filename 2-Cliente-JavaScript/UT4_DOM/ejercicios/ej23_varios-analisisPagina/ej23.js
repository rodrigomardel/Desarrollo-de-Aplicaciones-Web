/*
23.	Análisis página
Completa la página web analisisPagina.html, para mostrar en el div con id="info", la siguiente información de la web: 
•	El número de enlaces que apuntan a http://prueba.
•	El número de enlaces del primer párrafo.
*/
let info = document.getElementById("info");

/*El número de párrafos de la página.*/
let numParrafos = document.getElementsByTagName("p").length;

/*El texto del segundo párrafo.*/
let segundoParrafo = document.getElementsByTagName("p")[1];
segundoParrafo = segundoParrafo.textContent;

/*El número de enlaces de la página.*/
let numEnlaces = document.getElementsByTagName("a").length;

/*La dirección del primer enlace.*/
let primeraUrl = document.getElementsByTagName("a")[0];

/*La dirección del penúltimo enlace.*/
let numPenultimaUrl = document.getElementsByTagName("a").length - 1;
let penultimoEnlace = document.getElementsByTagName("a")[numPenultimaUrl];

info.innerHTML = `<p>Número de párrafos: ${numParrafos}</p>
    <p>Texto segundo párrafo: ${segundoParrafo}</p>
    <p>Número de enlaces: ${numEnlaces}</p>
    <p>Primer enlace: ${primeraUrl}</p>
    <p>Penúltimo enlace: ${penultimoEnlace}</p>`;
