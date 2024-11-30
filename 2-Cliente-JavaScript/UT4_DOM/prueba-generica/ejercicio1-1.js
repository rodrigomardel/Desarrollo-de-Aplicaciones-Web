/*
Haz una función borrarHoja(texto) que:
•	Recibe como parámetro el texto de la hoja que se quiere borrar.
•	Si la hoja no existe, se mostrará un mensaje de error (consola)
•	Si la hoja existe, se borrará y se mostrará un mensaje al usuario, indicando que se ha borrado (consola)

Ejemplos:
borrarHoja("Hoja D");	// La hoja Hoja D no existe
borrarHoja("Hoja A_1");	// Hoja Hoja A_1 borrada
borrarHoja("Hoja C_2");	// Hoja Hoja C_2 borrada
borrarHoja("Hoja D_1");	// Hoja Hoja D_1 borrada
borrarHoja("Rama B");	// La hoja Rama B no existe
*/

function borrarHoja(texto) {
  let hojas = document.querySelectorAll(".hoja");
  let hojaEncontrada = false;

  hojas.forEach((elemento) => {
    if (elemento.textContent === texto) {
      elemento.remove();
      console.log(`Hoja ${texto} borrada`);
      hojaEncontrada = true;
    }
  });
  if (!hojaEncontrada) {
    console.error(`La ${texto} no existe`);
  }
}

borrarHoja("Hoja D");
borrarHoja("Hoja A_1");
borrarHoja("Hoja C_2");
borrarHoja("Hoja D_1");
borrarHoja("Rama B");
