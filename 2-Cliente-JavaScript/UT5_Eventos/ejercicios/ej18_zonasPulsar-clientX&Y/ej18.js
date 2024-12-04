/*
A partir del archivo HTML proporcionado, crear un script que informe al usuario en qué zona de la pantalla ha hecho clic el ratón. 
Las zonas posibles son las siguientes: izquierda arriba, izquierda abajo, derecha arriba Y derecha abajo, 
todas relativas al tamaño de la ventana del navegador.
Para obtener el ancho Y alto de la ventana podemos utilizar document.documentElement.clientWidth Y  document.documentElement.clientHeight.
*/

document.addEventListener("click", informacionCoordenadas);

function informacionCoordenadas(event) {
  const ANCHO_DOCUMENTO = document.documentElement.clientWidth;
  const ALTO_DOCUMENTO = document.documentElement.clientHeight;

  const X = event.clientX;
  const Y = event.clientY;

  let zonaHorizontal;
  let zonaVertical;

  if (X < ANCHO_DOCUMENTO / 2) {
    zonaHorizontal = "Izquierda";
  } else {
    zonaHorizontal = "Derecha";
  }
  if (Y < ALTO_DOCUMENTO / 2) {
    zonaVertical = "Arriba";
  } else {
    zonaVertical = "Abajo";
  }

  let spanInfo = document.querySelector(".posicion");
  spanInfo.textContent = `${zonaHorizontal} ${zonaVertical}`;
}
