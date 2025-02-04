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
        $nombre = $_POST['nombre'];
        $edad = $_POST['edad'];
        $id_curso = $_POST['id_curso'];

        // Insercción de datos
        $consulta = "INSERT INTO alumno VALUES ($id_al, '$nombre', $edad, $id_curso)";

        $conexion->query($consulta);
        $conexion->close();

        echo "<h1> Alumno insertado </h1>";
    
    }
}


?>