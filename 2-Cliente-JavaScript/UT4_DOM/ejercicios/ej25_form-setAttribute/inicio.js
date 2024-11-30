/*
Crear el código para crear un formulario a partir de los datos indicados en la cadena DATOS_FORMULARIO. 
Se crearán el label y el input dentro de un <p>.
El label tendrá el atributo for con el mismo contenido del atributo label del input.
El input tendrá los atributos id, name y required.
*/

const DATOS_FORMULARIO =
  '{"campos": [{"label": "Código ciclo","id": "codCiclo","name": "codCiclo","obligatorio": true}, {"label": "Descripción ciclo","id": "desCiclo","name": "desCiclo","obligatorio": true},{"label": "Observaciones","id": "observaciones","name": "observaciones","obligatorio": false}]}';

let objDatosFormulario = JSON.parse(DATOS_FORMULARIO);
console.log(objDatosFormulario.campos);

let formulario = document.getElementById("formulario");

for (let i = 0; i < objDatosFormulario.campos.length; i++) {
  let p = document.createElement("p");

  let label = document.createElement("label");
  label.setAttribute("for", objDatosFormulario.campos[i].label);
  label.textContent = objDatosFormulario.campos[i].label;

  let input = document.createElement("input");
  input.id = objDatosFormulario.campos[i].id;
  input.name = objDatosFormulario.campos[i].name;
  input.required = objDatosFormulario.campos[i].obligatorio;

  formulario.appendChild(p);
  p.append(label, input);
}

let button = document.getElementById("validar");
formulario.append(button);
