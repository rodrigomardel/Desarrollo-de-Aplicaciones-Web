/*
A partir del formularioBasico.html, completa el archivo .js.
No se puede modificar el html.

Cuando se lanza el evento "submit", se deben mostrar por consola todos los valores asignados a variables del formulario, y el formulario no se debe enviar al servidor.
*/

document.addEventListener("DOMContentLoaded", () => {
  let submit = document.getElementById("enviar");

  submit.addEventListener("click", (event) => {
    event.preventDefault();

    let formulario = document.forms["miFormulario"];

    //nombre
    console.log("Nombre: " + formulario.nombre.value);

    //teléfono
    console.log("Telefono: " + formulario.telefono.value);

    //fecha nacimiento
    console.log(
      "Fecha nacimiento: " +
        formulario.dia.value +
        "/" +
        formulario.mes.value +
        "/" +
        formulario.ano.value
    );

    //socio con checked recorriendo el radio
    let socio = formulario.socio;

    for (const opcion of socio) {
      if (opcion.checked) {
        console.log("Socio: " + socio.value);
      }
    }

    //curso seleccionado con CSS seleccionado directamente la opción
    let cursoSeleccionado = document.querySelector(
      "select[name='curso'] option:checked"
    );
    console.log("Curso: " + cursoSeleccionado.value);

    //cursos realizados
    let cursosRealizados = [];
    //acceder al select por el nombre como propiedad
    for (const curso of formulario["cursosRealizados[]"].options) {
      if (curso.selected) {
        cursosRealizados.push(curso.value);
      }
    }
    console.log("Cursos realizados: " + cursosRealizados);

    //descuento
    console.log("Descuento: " + formulario.descuento.checked);

    //observaciones
    console.log("Observaciones: " + formulario.observaciones.value);
  });
});
