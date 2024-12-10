/*
Modifica el archivo ej12, añadiendo el código JavaScript necesario.

Se trata de crear una lista donde los elementos son seleccionables, simulando el comportamiento del Administrador de archivos.

Cuando se hace click sobre un elemento de la lista, el funcionamiento será distinto, 
dependiendo de si está presionada la tecla Ctr (Cmd para Mac):
•	Si esa tecla está seleccionada: simplemente añade o quita la clase "selected" al elemento seleccionado.
•	Si esa tecla NO está seleccionada: quita la clase "selected" a todos los elementos de la lista que la tuvieran, 
y añade la clase "selected" al elemento sobre el que se ha hecho click.

Notas:
•	Para esta tarea, podemos suponer que los elementos de la lista son solo de texto. No hay etiquetas anidadas.
•	Evita la selección nativa del navegador del texto en los clics.
*/
let lista = document.querySelector("#ul");

lista.addEventListener("click", seleccionElemento);
lista.addEventListener("mousedown", (event) => {
  event.preventDefault();
});

function seleccionElemento(event) {
  let target = event.target;

  if (target.tagName == "LI") {
    if (event.ctrlKey || event.metaKey) {
      target.classList.toggle("selected");
    } else {
      let todosLi = document.querySelectorAll("li");
      todosLi.forEach((li) => {
        li.classList.remove("selected");
      });
      target.classList.add("selected");
    }
  }
}
