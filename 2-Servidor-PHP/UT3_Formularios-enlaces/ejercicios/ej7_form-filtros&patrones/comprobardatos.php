<?php
//COMPROBACIÓN DATOS
function sanitizarDato($dato){
    return htmlspecialchars(strtolower(trim($dato)));
}

function validarDato($dato) {
    $dato = sanitizarDato($dato);

    if (filter_var($dato, FILTER_VALIDATE_INT) !== false || filter_var($dato, FILTER_VALIDATE_FLOAT) !== false) {
         echo "** No son válidos números **";       
    } else {
        return preg_match('/^blanco$/', $dato);
    }
}
?>