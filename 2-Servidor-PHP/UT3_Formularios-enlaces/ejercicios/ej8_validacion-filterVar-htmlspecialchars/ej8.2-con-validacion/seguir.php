<?php
/*
Diseña un formulario que capture un número y se visualice la tabla de multiplicar. Casos:
8.1.1.- El procesamiento incluido en otro archivo .php (atributo action de la etiqueta <from>)
*/

require_once("./validacion.php");

$numero = $_POST['numero'];
$enviado = $_POST['enviar'];

if (isset($enviado)) {

    if (!empty(intval($numero)) || $numero == 0) {//parsea a entero
        
        if(validarNumero($numero)){
            for ($i=0; $i <= 10; $i++) { 
                echo $numero. "×" .$i. " = ". $numero*$i .'<br>';
            }
            exit();
        } else {
            echo "** Solo son válidos números enteros entre 1 y 10 **";    
            require "./ej8.2.html";
        }
        
    } else {
        echo "<a href='./ej8.2.html'>Debe introducir un número. Intentelo de nuevo </a>";
    }

}

?>
