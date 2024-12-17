<?php
/*
Diseña un formulario para capturar dos números menores de 100 y un signo de operación (+,-,x,/) y calcula el resultado de la operación. Visualiza el resultado. 
9.2.- Con validación. Diseña funciones para validar los operandos y el operador. Las funciones se incluirán en un archivo.
*/

require_once('./funciones.php');

$numero1 = $_POST['numero1'];
$numero2 = $_POST['numero2'];
$enviado = $_POST['enviar'];
$operacion = $_POST['operacion'];

if(isset($enviado)){
    // Validar que los números son válidos        
    if(!empty($numero1) && !empty($numero2) || $numero1 == 0  || $numero2 == 0){

        if(validarNumero($numero1) && validarNumero($numero2)){
            // Validar que la operación no sea división por cero
            if ($operacion === 'division' && $numero2 == 0) {
                echo "<a href='./form1-100.html'>No se puede dividir entre cero. Intentelo de nuevo</a>";
            } else {
                $_POST['resultado'] = operaciones($numero1, $numero2, $operacion);
                echo "<h4 style='color: rebeccapurple'>El resultado es: ".$_POST['resultado']."</h4>";
                exit();
            }

        } else{
            echo "<p color='yellow'> ** Introduzca un números menores que 100 **</p><a href='./form1-100.html'>Click para volver al formulario</a>";
        }
    } else {
        echo "<p color='yellow'> ** Debe introducir ambos valores **</p><a href='./form1-100.html'>Click para volver al formulario</a>";
    }
}

?>