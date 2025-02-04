<?php
// Creación/Apertura archivo
$nom_fichero = 'modulos.txt';
$fichero = fopen($nom_fichero, 'a+');

// Conexión base de datos
$conexion_ciclos = new PDO ('mysql:host=127.0.0.1; port=3306; dbname=ciclos', 'root', 'root');

// Consulta
$query = "SELECT * from alumno";
$resultado = $conexion_ciclos->query($query);

$alumno = "";
while ($alumno = $resultado->fetch(PDO::FETCH_ASSOC)) {

    $registro = $alumno['id_al']. " " .$alumno['nombre']. " " . $alumno['edad']. " " . $alumno['id_curso'].PHP_EOL;

    //Agregar registro al fichero
    fputs($fichero, $registro);
}

echo "Fichero creado";

fclose($fichero);

?>