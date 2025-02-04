<?php
require_once('../model/modelo.php');
$conexion_bd = new Conexion($_POST['bases-de-datos']);
// comprobar la conexión
// if(){

// } else {

    $resultado_consulta = $conexion_bd->relizar_consulta(htmlspecialchars($_POST['consulta']));
    $resultado_consulta = explode(';', $resultado_consulta);
    require_once('../view/mostrar_resultado.php')
// }
?>