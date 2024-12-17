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
    $resultado = "";
    switch ($operacion) {  
        case 'suma':
            $resultado = $numero1 + $numero2;
            break;  
        case 'resta':
            $resultado = $numero1 - $numero2;
            break;
        case 'multiplicacion':
            $resultado = $numero1 * $numero2;
            break;
        case 'division':
            $resultado = $numero1 / $numero2;
            break;
        default:
            return null;
    }
    return $resultado;
}

?>