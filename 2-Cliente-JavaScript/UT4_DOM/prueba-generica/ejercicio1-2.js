/*
Haz una función insertarHoja(textoRama, textoHoja) que:
•	Recibe como parámetro:
        o	textoRama: texto de la rama en la que se quiere insertar la hoja
        o	textoHoja: texto de la hoja que se quiere insertar
•	Si la rama no existe, se mostrará un mensaje de error (consola)
•	Si la rama existe,
        o	se insertará una nueva hoja (un rama li con clase hoja) como última hoja del ul de la rama.
        o	Se mostrará un mensaje en consola.

Ejemplos:
insertarHoja("Rama E", "hoja nueva");	//La rama Rama E no existe
insertarHoja("Rama C", "hoja nuevaC"); 	//Hoja hoja nuevaC insertada
insertarHoja("Rama B_A", "hoja nuevaBA"); 	//Hoja hoja nuevaBA insertada
insertarHoja("Rama D", "hoja nuevaD"); 	//Hoja hoja nuevaD insertada
*/

function insertarHoja(textoRama, textoHoja) {
  let ramas = document.querySelectorAll(".rama");
  let ramaEncontrada = false;

  ramas.forEach((rama) => {
    if (rama.textContent.trim().startsWith(textoRama)) {
      let nuevoLi = document.createElement("li");
      nuevoLi.className = "hoja";
      nuevoLi.textContent = textoHoja;
      rama.firstElementChild.append(nuevoLi);
      console.log(`Hoja ${textoHoja} insertada`);
      ramaEncontrada = true;
    }
  });

  if (!ramaEncontrada) {
    console.error(`La ${textoRama} no existe`);
  }
}

insertarHoja("Rama E", "hoja nueva");
insertarHoja("Rama C", "hoja nuevaC");
insertarHoja("Rama B_A", "hoja nuevaBA");
insertarHoja("Rama D", "hoja nuevaD");
