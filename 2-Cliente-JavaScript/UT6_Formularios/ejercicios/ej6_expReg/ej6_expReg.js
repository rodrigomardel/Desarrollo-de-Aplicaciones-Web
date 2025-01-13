/*
Breaking Bad. Walter White y Jesse Pinkman tienen que controlar las bolsas de producto azul que cocinan para distribuir en Alburquerque. Para ello tienen que crear un formulario que almacene la información de cada bolsa y validarlo teniendo en cuenta lo siguiente:
*/
let form = document.forms.formBreakingBad;
let inputs = document.querySelectorAll("[type='text']");
let spans = document.querySelectorAll("span");

/* 1.	Fecha de creación: obligatorio, fecha válida y con formato dd/mm/aaaa. */
let fechaRegex =
  /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/(19[0-9]{2}|20[0-9]{2})$/;

/* 2.	Cocinero: será un nombre en clave formado por dos letras en mayúscula, un símbolo y cuatro dígitos (ej. WW$1234) */
let cocineroRegex = /^[A-Z]{2}.[0-9]{4}$/;

/* 3.	Destinatario: estará formado por dos o tres letras mayúsculas correspondientes al estado, un guion bajo, el nombre de la ciudad en minúsculas, dos puntos, y el código de distrito de 4 digitos (ej. NM_alburquerque:1234). */
let destinatarioRegex = /^[A-Z]{2,3}_[a-z]+:[0-9]{4}$/;

/* 4.	Gramos: será un número del 100 al 5000. */
let gramosRegex = /^([1-9][0-9]{2}|[1-4][0-9]{3}|5000)$/;

/* 5.	Número de cuenta de EEUU: supongamos que un número de cuenta estadounidense tiene el siguiente formato:
o	Dos letras
o	Dos dígitos
o	Un guion.
o	Doce dígitos de cuenta.
o	Un guion.
o	Cuatro dígitos de control
Ej. AB1234-123456789012-1234
Si el número de cuenta es correcto, se colocará en un campo de texto al lado del anterior, pero sin guiones: solamente los números y las letras. */
let cuentaRegex = /^[A-Z]{2}[0-9]{2}-[0-9]{12}-[0-9]{4}$/;

form.addEventListener("submit", (e) => {
  e.preventDefault();
  //array para almacenar los mensajes de error
  let errores = ["", "", "", "", ""];

  inputs.forEach((input, index) => {
    //campo vacío
    if (input.value.trim() === "") {
      errores[index] = "Campo obligatorio";
    } else {
      //validación de cada campo
      switch (input.id) {
        case "fecha":
          errores[index] = fechaRegex.test(input.value)
            ? ""
            : "Fecha inválida. Use el formato dd/mm/aaaa.";
          break;

        case "cocinero":
          errores[index] = cocineroRegex.test(input.value)
            ? ""
            : "Cocinero inválido. Use el formato WW$1234.";
          break;

        case "destinatario":
          errores[index] = destinatarioRegex.test(input.value)
            ? ""
            : "Destinatario inválido. Use el formato NM_alburquerque:1234.";
          break;

        case "gramos":
          errores[index] = gramosRegex.test(input.value)
            ? ""
            : "Gramos inválidos. Debe ser un número entre 100 y 5000.";
          break;

        case "cuenta":
          if (cuentaRegex.test(input.value)) {
            //versión sin guiones
            document.getElementById("cuentaSinGuiones").value =
              input.value.replace(/-/g, "");
            errores[index] = "";
          } else {
            errores[index] =
              "Cuenta inválida. Use el formato AB12-123456789012-1234.";
          }
          break;

        default:
          alert(
            `El campo con id ${input.id} no tiene una validación específica.`
          );
          break;
      }
    }
  });

  asignarErrores();

  // asignar los mensajes de error a los spans correspondientes
  function asignarErrores() {
    errores.forEach((error, index) => {
      spans[index].style.color = "red";
      spans[index].textContent = error;
    });
  }
});
