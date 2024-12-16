<?php
function validarNumero($numero){
    $datoValido = htmlspecialchars(strtolower(trim($numero)));

    if ((filter_var($datoValido, FILTER_VALIDATE_INT) === false || filter_var($datoValido, FILTER_VALIDATE_FLOAT) === false) || $datoValido < 1 || $datoValido > 10){
        return false;
    } else {
        return true;
    }

}
?>