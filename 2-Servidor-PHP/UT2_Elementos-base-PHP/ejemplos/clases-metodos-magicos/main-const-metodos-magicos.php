<?php
require_once('./ejemplo_clase-metodos-magicos.php');

//Llamada constructor mágico
$alumno1 = new Alumno("Rodrigo" , 22);
var_dump($alumno1);
echo "<br>";

//Lamada constructor programado (Nombre Edad)
$alumno2 = new Alumno();
$alumno2->AlumnoNombreEdad("Mª Ángeles", 50);
var_dump($alumno2);
echo "<br>";

echo $alumno2->__get('edad');


?>