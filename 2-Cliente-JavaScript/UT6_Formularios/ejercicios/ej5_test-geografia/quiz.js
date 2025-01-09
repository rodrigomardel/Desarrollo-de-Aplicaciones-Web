/*
Vas a crear un pequeño test sobre un tema (el que quieras).

La página tendrá, al menos:
•	5 preguntas con 3 respuestas cada una a elegir con botones de radio.
•	un botón para comprobar las respuestas
•	un campo donde se mostrará el resultado

El test deberá hacer lo siguiente:
•	Cuando el usuario conteste las 5 preguntas obtendrá el resultado final en un cuadro de texto.
•	Además, el usuario podrá ver qué preguntas ha fallado, porque al enviar el formulario le aparecerá un pequeño icono con un tic verde en las preguntas correctas y una cruz roja en las preguntas incorrectas.
•	En caso de que el usuario deje alguna pregunta sin contestar, no mostrará el resultado e indicará con un mensaje "No has respondido a todas las preguntas". Y se marcará en color rojo la pregunta que no haya sido respondida.
•	El usuario puede salir de la página y continuar en otro momento.
*/

let formulario = document.forms.form_geografia;
let respuestasCorrectas = [
  "París",
  "Oceanía",
  "Amazonas",
  "Desierto Antártico",
  "China",
];

document.querySelector("button").addEventListener("click", comprobarPreguntas);

//comprobación preguntas
function comprobarPreguntas(e) {
  e.preventDefault();

  let preguntas = document.querySelectorAll(".pregunta");
  let numSeleccionadas = document.querySelectorAll("input:checked").length;
  let numCorrectas = 0;

  // reseteo de clases
  preguntas.forEach((pregunta) => {
    pregunta.classList.remove("no-contestada", "correcta", "incorrecta");
  });

  // control del numero de respuestas seleccionadas
  if (numSeleccionadas < respuestasCorrectas.length) {
    document.querySelector(".resultado").textContent =
      "No has respondido a todas las preguntas.";
    document.querySelector(".resultado").style.color = "red";

    //añadir estilo a cada pregunta no contestada
    preguntas.forEach((pregunta) => {
      let seleccionada = pregunta.querySelector("input:checked");
      if (!seleccionada) {
        pregunta.classList.add("no-contestada");
      }
    });
    return;
  }

  // comprobacion de las contestadas
  preguntas.forEach((pregunta, index) => {
    let seleccionada = pregunta.querySelector("input:checked");
    if (seleccionada && seleccionada.value === respuestasCorrectas[index]) {
      numCorrectas++;
      pregunta.classList.add("correcta");
    } else {
      pregunta.classList.add("incorrecta");
    }
  });

  //muestra de resultados
  document.querySelector(
    ".resultado"
  ).textContent = `Has acertado ${numCorrectas} de ${respuestasCorrectas.length} preguntas.`;
  document.querySelector(".resultado").style.color = "green";
}

// guardado en el localStorage
formulario.addEventListener("change", guardarRespuestas);

function guardarRespuestas() {
  let respuestas = {};
  let inputs = document.querySelectorAll("input[type='radio']");

  inputs.forEach((input) => {
    if (input.checked) {
      respuestas[input.name] = input.value; // respuesta seleccionada {clave:name , valor:value}
    }
  });

  localStorage.setItem("respuestasUsuario", JSON.stringify(respuestas));
}

//cargar respuestas almacenadas
function cargarRespuestasAlmacenadas() {
  let respuestas = JSON.parse(localStorage.getItem("respuestasUsuario"));

  Object.keys(respuestas).forEach((pregunta) => {
    let respuestaSeleccionada = respuestas[pregunta];
    let input = document.querySelector(
      `input[name="${pregunta}"][value="${respuestaSeleccionada}"]`
    );
    if (input) {
      input.checked = true; // poner el checked del input a true
    }
  });
}
cargarRespuestasAlmacenadas();
