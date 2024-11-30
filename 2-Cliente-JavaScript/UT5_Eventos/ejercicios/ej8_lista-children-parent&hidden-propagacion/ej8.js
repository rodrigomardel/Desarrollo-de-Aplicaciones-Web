/*
En este ejercicio tenemos un árbol. Se pide que al hacer clic sobre un texto, si tiene nodos hijos, los muestre/oculte.

La solución tiene dos partes.

1.	Envuelve cada nodo de texto del árbol dentro de <span>.

2.	Establece el manejador al nodo raíz del árbol y maneja los clics en aquellos nodos que sean  <span>.
*/

document.addEventListener("DOMContentLoaded", () => {
  let lista = document.getElementById("tree");
  // console.log(lista);
  envolverElementos();
  lista.addEventListener("click", mostrarOcultarTexto);

  function envolverElementos() {
    let allLis = document.getElementsByTagName("li");

    for (let li of allLis) {
      // console.log(li);

      if (li.children.length > 0) {
        let span = document.createElement("span");
        let texto = li.firstChild.textContent.trim();
        span.textContent = texto;
        // console.log(span);

        li.firstChild.remove(); //borrado del original
        li.prepend(span); //agregra el nuevo elemento
      }
    }
  }

  function mostrarOcultarTexto(e) {
    if (e.target.tagName == "SPAN") {
      let lista = e.target.parentElement.querySelector("ul");
      if (lista) {
        lista.hidden = !lista.hidden;
      }
    }
  }
});
