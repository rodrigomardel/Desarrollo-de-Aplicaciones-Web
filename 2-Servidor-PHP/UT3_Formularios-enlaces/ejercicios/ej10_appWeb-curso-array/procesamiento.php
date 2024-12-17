<?php
require_once('./DatosAlumno.php');


if(isset($_POST['enviar'])){

    if(!empty($_POST['ciclo']) && !empty($_POST['curso']) && !empty($_POST['opciones'])){
        DatosAlumno::visualizar($_POST['ciclo'], $_POST['curso'], $_POST['opciones']);
    } else {
        echo "<p color='yellow'>** Debe completar todos los campos **</p><a href='./form.html'>Click para volver al formulario</a>";
    }

}


?>