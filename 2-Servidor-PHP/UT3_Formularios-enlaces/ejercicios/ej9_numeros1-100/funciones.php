<?php

/*Valida que es un número entero menor que 100*/
function validarNumero($numero){
    $datoValido = htmlspecialchars(strtolower(trim($numero)));

    if ((filter_var($datoValido, FILTER_VALIDATE_INT) === false || filter_var($datoValido, FILTER_VALIDATE_FLOAT) === false) || $datoValido > 100){
        return false;
    } else {
        return true;
    }
}

/*Calcula la operacion de dos números dados*/
function operaciones($numero1, $numero2, $operacion){
    switch ($operacion) {
        case 'suma':
            return $numero1 + $numero2;
        case 'resta':
            return $numero1 - $numero2;
        case 'multiplicacion':
            return  $numero1 * $numero2;
        case 'division':
            return  $numero1 / $numero2;
        default:
            return null;
    }
}

?>