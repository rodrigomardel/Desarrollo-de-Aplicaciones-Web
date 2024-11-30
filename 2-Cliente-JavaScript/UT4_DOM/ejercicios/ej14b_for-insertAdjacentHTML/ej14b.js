/*
***Usando el método insertAdjacentHTML.*** 
• Crea una función que recibe como parámetros dos números (número de filas y número de columnas).
En la función se crea una tabla de esas filas y esas columnas. Cada celda tendrá algo de contenido de texto.
La tabla se "engancha" al árbol del DOM, al colocarla como hija del body.
La función devolverá un puntero al elemento del DOM asociado a la tabla.
*/
function crearTabla(filas, celdas) {
  let tablaCad = "<table>";

  for (let i = 0; i < filas; i++) {
    tablaCad += "<tr>";
    for (let j = 0; j < celdas; j++) {
      tablaCad += "<td>" + "Celda" + (i + 1) + "-" + (j + 1) + "</td>";
    }
    tablaCad += "</tr>";
  }
  tablaCad += "</table>";
  document.body.insertAdjacentHTML("afterbegin", tablaCad);

  let tabla = document.getElementsByTagName("table")[0];
  return tabla;
}

let tablaIni = crearTabla(3, 4);

/*
• Crea una función a la que pasas como parámetro un puntero a la tabla y el número de columnas que tiene la tabla.
La función insertará, al principio de la tabla, una fila con ese número de columnas.
*/

function insertarFila(tabla, celdas) {
  let filaCad = "<tr>";

  for (let i = 0; i < celdas; i++) {
    filaCad += "<td>Celda+</td>";
  }

  filaCad += "</tr>";

  let primeraFila = tabla.getElementsByTagName("tr")[0];
  primeraFila.insertAdjacentHTML("beforebegin", filaCad);

  let tablaAmp = document.getElementsByTagName("table")[0];
  return tablaAmp;
}

let tablaAmpliada = insertarFila(tablaIni, 4);

/*
• Crea una función a la que pasas como parámetro un puntero a la tabla.
La función insertará, antes de la tabla, un elemento de tipo cabecera (h1, h2, ...) con un texto.
*/

function insertarCabecera(tabla, cabecera) {
  let cabeceraCad = "<tr><th>" + cabecera + "</th></tr>";
  let primeraFila = tabla.getElementsByTagName("tr")[0];
  primeraFila.insertAdjacentHTML("beforebegin", cabeceraCad);

  let tablaCab = document.getElementsByTagName("table")[0];
  tablaCab.style.border = "1px solid black";
  return tablaCab;
}

let tablaCabecera = insertarCabecera(tablaAmpliada, "Cabecera");
