/*
Crea una galería de imágenes donde la imagen principal cambia al hacer clic en una miniatura.
Utiliza la delegación de eventos.
*/
document.addEventListener("DOMContentLoaded", () => {
  let galeriaUl = document.getElementById("thumbs");
  let imagenPrincipal = document.getElementById("largeImg");

  galeriaUl.addEventListener("click", cambioImagen);

  function cambioImagen(event) {
    let linkImgTarget = event.target.closest("a");

    if (linkImgTarget) {
      imagenPrincipal.src = linkImgTarget.childNodes[0].src;
      event.preventDefault();
    }
  }
});
