/*
Añade el JavaScript necesario para que, al hacer clic sobre los elementos <th>, la tabla se ordene por la columna correspondiente.

Cada <th> tiene un atributo que indica el tipo de datos de esa columna (sólo pueden ser "string" o "number"). 
La función de ordenamiento debe manejar el orden de acuerdo al tipo de datos. 

Ojo! La tabla puede tener cualquier número de filas y de columnas.
*/

let tabla = document.querySelector("#grid");

tabla.addEventListener("click", seleccionEncabezado);

/*Ordena según el tipo de atributo del encabezado*/
function seleccionEncabezado(event) {
  let target = event.target.dataset.type;
  switch (target) {
    case "number":
      ordenarCeldas(tabla, 0, true);
      console.info("¡Edades ordenadas!");
      break;

    case "string":
      ordenarCeldas(tabla, 1, false);
      console.info("¡Nombres ordenados!");
      break;
  }
}

/*Ordendar celdas*/
function ordenarCeldas(tabla, indiceColumna, esNumero) {
  let tbody = tabla.querySelector("tbody");
  let filas = Array.from(tbody.rows);

  filas.sort((filaA, filaB) => {
    let celdaA = filaA.cells[indiceColumna].textContent.trim();
    let celdaB = filaB.cells[indiceColumna].textContent.trim();

    if (esNumero) {
      return celdaA - celdaB;
    } else {
      return celdaA.localeCompare(celdaB);
    }
  });

  filas.forEach((fila) => tbody.append(fila)); //reorganizamos las filas en el DOM
}
