<?php
/*
Añade validación al string tecleado en el ejercicio 6 y permite mostrar de nuevo el formulario si el string no es correcto.

Función de usuario para sanitizar el dato tecleado (aplicar funciones: trim, htmlspecialchars, ...)
Función de usuario para validar el dato (aplicar un filtro: filter_var(...) y un patrón: preg_match(...))

Tratamiento:
SI el dato es correcto entonces: mensaje -> ¡Acertaste!
    SI NO -> Volver a intentarlo
FIN SI
*/

require_once('comprobardatos.php');

$dato = $_POST['dato'];
$enviado = $_POST['enviar'];

//RECOGIDA DATOS
if (isset ($enviado)){

    if(!empty($dato)){

        if(validarDato($dato)){
            echo "¡Acertaste!". '<br>';
            exit();
        } else {
            echo "Error - No es de color " .sanitizarDato($dato). ".";
        }     

    } else {
        echo "No has seleccionado ningún color.";
    }

    require "./ej7-form.php";

} else {
    require "./ej7-form.php";
}

?>
