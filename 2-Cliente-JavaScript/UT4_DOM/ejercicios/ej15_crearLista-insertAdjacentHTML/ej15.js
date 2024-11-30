/*
Escribir una interfaz para crear una lista de lo que ingresa un usuario.

Para cada item de la lista:

1.	Preguntar al usuario acerca del contenido usando prompt.
2.	Crear el <li> con ello y agregarlo a <ul>.
3.	Continuar hasta que el usuario cancela el ingreso (presionando Esc o con un ingreso vacío).
Todos los elementos deben ser creados dinámicamente.

Si el usuario ingresa etiquetas HTML, deben ser tratadas como texto.
*/

function crearLista() {
  let continuar = true;
  do {
    let textoUsuario = prompt(
      "• Crear listado •\nIngrese los elementos de la lista separados por comas"
    );

    if (textoUsuario === null || textoUsuario === "") {
      continuar = false;
    } else {
      let arrayLista = textoUsuario.split(",");

      let cadenaLista = "<ul>";
      for (let i = 0; i < arrayLista.length; i++) {
        cadenaLista += `<li> ${arrayLista[i]} </li>`;
      }
      cadenaLista += "</ul>";

      document.body.insertAdjacentHTML("afterbegin", cadenaLista);
    }

    continuar = false;
  } while (continuar);

  alert("*** FIN ***");
}

crearLista();
