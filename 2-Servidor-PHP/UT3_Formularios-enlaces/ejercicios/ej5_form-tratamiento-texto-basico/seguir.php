<?php
//Comprobando POST
// foreach ($_POST as $key => $value) {
//     echo $key. ' :'. $value. '<br>';
// }

$dato = $_POST['dato'];
//«isset» comprueba si existe la variable
if (isset ($_POST['enviar'])){

    if(!empty($dato)){

        if(strtolower(trim($dato)) == 'blanco'){
            echo "¡Acertaste!". '<br>';
            exit("Fin de aplicación");
        } else {
            echo "Error. No es de color " .htmlspecialchars($dato). ".";
        }

    } else {
        echo "No has seleccionado ningún color.";
    }
}
?>