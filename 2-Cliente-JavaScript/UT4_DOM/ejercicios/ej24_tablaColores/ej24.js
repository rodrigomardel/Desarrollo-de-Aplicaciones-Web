/*
Crea, con JavaScript, una tabla de 5 columnas y 4 filas, con 20 colores. 
Cada celda de la tabla tendrá un color de fondo aleatorio.
*/
function crearColor() {
  let numero = Math.random().toString(16); //numero entre 0 y 1 en hexacimal
  let cadena = "#";
  for (let i = 2; i <= 7; i++) {
    //agregramos a partir del segundo numero ya que los dos primeros son «0.»
    cadena += numero[i];
  }
  return cadena.toUpperCase();
}

function crearTabla() {
  let body = document.body;
  let tabla = document.createElement("table");

  for (let i = 0; i < 4; i++) {
    let tr = document.createElement("tr");
    for (let j = 0; j < 5; j++) {
      let td = document.createElement("td");
      td.style.backgroundColor = crearColor();
      td.innerHTML = "<strong>" + crearColor() + "</strong>";
      tr.append(td);
    }
    tabla.append(tr);
  }
  body.append(tabla);
}
crearTabla();
