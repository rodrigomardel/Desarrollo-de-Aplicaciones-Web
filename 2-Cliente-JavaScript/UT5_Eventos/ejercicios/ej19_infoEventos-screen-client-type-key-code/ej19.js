/*
Partiendo del archivo HTML proporcionado, crear un script que haga lo siguiente:
•	Al mover el ratón en cualquier punto de la ventana del navegador, 
se muestre la posición del puntero respecto del navegador y respecto de la pantalla:
 
•	Al pulsar cualquier tecla, se debe mostrar el valor de la tecla pulsada y su código asociado:
 
•	Añadir la siguiente característica al script: cuando se pulsa un botón del ratón, 
el color de fondo del cuadro de mensaje debe ser amarillo (#FFFFCC) y cuando se pulsa una tecla del teclado, 
el color de fondo del cuadro del mensaje del raton debe ser azul (#CCE6FF). Al volver a mover el ratón, el color de fondo vuelve a ser blanco.
*/
let divTeclado = document.getElementById("teclado");
let divRaton = document.getElementById("raton");

document.addEventListener("mousemove", posicionPuntero);
document.addEventListener("click", posicionPuntero);
document.addEventListener("keydown", teclaPulsada);

/*Muestra la posición del puntero respecto al navegador y pantalla.
Cambia el color en caso de dar click; reestablece los dos contenedores a blanco 
si se mueve posteriormente el ratón.*/
function posicionPuntero(event) {
  let divDatosRaton = document.getElementById("datosRaton");

  divDatosRaton.innerHTML = `Navegador: [X:${event.clientX} | Y:${event.clientY}] <br> 
  Pantalla: [X:${event.screenX} | Y:${event.screenY}]`;
  console.log(event);

  if (event.type === "click") {
    divRaton.style.backgroundColor = "#FFFFCC";
  } else {
    divRaton.style.backgroundColor = "#FFF";
  }
  divTeclado.style.backgroundColor = "#FFF";
}

/*Muestra la clave del evento y su código*/
function teclaPulsada(event) {
  let divDatosTeclado = document.getElementById("datosTeclado");

  divDatosTeclado.innerHTML = `Carácter:[${event.key}] <br> Código:[${event.code}]`;
  divTeclado.style.backgroundColor = "#CCE6FF";
}
