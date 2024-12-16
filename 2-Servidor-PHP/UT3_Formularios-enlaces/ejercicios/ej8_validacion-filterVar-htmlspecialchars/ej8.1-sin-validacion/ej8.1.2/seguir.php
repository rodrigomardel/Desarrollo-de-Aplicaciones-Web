<?php
/*
Diseña un formulario que capture un número y se visualice la tabla de multiplicar. Casos:
8.1.1.- El procesamiento incluido en otro archivo .php (atributo action de la etiqueta <from>)
*/

$numero = $_POST['numero'];
$enviado = $_POST['enviar'];

if (isset($enviado)) {

    if (!empty($numero)) {
        for ($i=0; $i <= 10; $i++) { 
            echo $numero. "×" .$i. " = ". $numero*$i .'<br>';
        }
        require "./ej8.1.1.php";


    } else {
        echo "Debe introducir un número";
        require "./ej8.1.1.php";
    }
    
}

?>
