<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
</body>
</html>
<?php
$db_host = 'localhost';
$db_usuario = 'root';
$db_clave = 'root'; //cambiar -> ('' no funciona)
$db_nombre = 'ciclos';



// A.- Procedimental
echo "<h4>Opción A - procedimental (API - mysqli)</h4>";
$conexion = mysqli_connect($db_host, $db_usuario, $db_clave);
// Comprobación de la conexión
if(mysqli_connect_errno()){
    echo "Fallo en la conexión";
} else {
    echo "Conexión establecida <br><br>";
    
    // Visualización de datos
    if(mysqli_select_db($conexion, $db_nombre)){
        $consulta = "SELECT * FROM alumno";
        $resultados = mysqli_query($conexion,  $consulta);
        // var_dump($resultados);
        while ($fila = mysqli_fetch_array($resultados)) {
            echo $fila['id_al']." ".$fila['nombre']." ".$fila['edad']." ".$fila['id_curso']."<br>";
        }
    } else {
        echo "No es posible acceder a la BBDD -> $db_nombre";
    }
    
    echo "<br><br>";
}



// B.- POO
echo "<h4>Opción B - POO (API - mysqli)</h4>";
$conexion = new mysqli($db_host, $db_usuario, $db_clave, $db_nombre);
// Comprobación de la conexión
if($conexion->connect_errno){
    echo "Fallo en la conexión";
} else {
    echo "Conexión establecida <br><br>";
    // Visualización de datos
    $consulta = "SELECT * FROM alumno";
    $resultados = $conexion->query($consulta);

    while ($fila = $resultados->fetch_array()) {
        echo $fila['id_al']." ".$fila['nombre']." ".$fila['edad']." ".$fila['id_curso']."<br>";
    }

    $conexion->close();
}




// C.- PDO
echo "<h4>Opción C - PDO</h4>";
$conexion = new PDO ('mysql:host=127.0.0.1; port=3306; dbname=ciclos', $db_usuario, $db_clave);
// Comprobación de la conexión
if($conexion->errorCode()){
    echo "Fallo en la conexión";
} else {
    echo "Conexión establecida <br><br>";
    // Visualización de datos
    $consulta = "SELECT * FROM alumno";
    $resultados = $conexion->query($consulta);

    foreach ($resultados as $fila) {
      echo $fila['id_al']." ".$fila['nombre']." ".$fila['edad']." ".$fila['id_curso']."<br>";
    }

    $conexion = null;
}


?>