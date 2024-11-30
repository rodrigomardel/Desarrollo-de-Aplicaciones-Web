//soluciones
//1º variable global == null
//2º if(seleccionado) seleccionado.classList.remove()

let ultimoElemento;
document.addEventListener("DOMContentLoaded", () => {
  let tabla = document.querySelector("#bagua-table");

  tabla.addEventListener("click", (event) => {
    let target = event.target;
    let celda = target.closest("td");

    if (celda) {
      if (ultimoElemento) {
        ultimoElemento.classList.remove("highlight");
      }
      celda.classList.add("highlight");
      ultimoElemento = celda;
    }
  });
});
