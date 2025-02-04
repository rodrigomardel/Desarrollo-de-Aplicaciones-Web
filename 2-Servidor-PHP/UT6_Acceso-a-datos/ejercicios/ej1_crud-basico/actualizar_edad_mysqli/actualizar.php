<?php
$db_host = 'localhost';
$db_usuario = 'root';
$db_clave = 'root';
$db_nombre = 'ciclos';

$conexion = new mysqli($db_host, $db_usuario, $db_clave, $db_nombre);
// Comprobación de la conexión
if($conexion->connect_errno){
    echo "Fallo en la conexión";
} else {
    // Datos formulario
    if(isset($_POST['enviar'])){
        $id_al = $_POST['id_al'];
        $edad = $_POST['edad'];

        // Actualización de datos
        $consulta = "UPDATE alumno SET edad = $edad WHERE id_al =  $id_al";

        $conexion->query($consulta);
        $conexion->close();

        echo "<h1> Actualización finalizada </h1>";

    }
}


?>