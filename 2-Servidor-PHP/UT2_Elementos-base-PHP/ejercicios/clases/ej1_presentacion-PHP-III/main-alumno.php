<?php
require_once('./Alumno.php');

$alumno1 = new Alumno("Rodrigo" , 30);
var_dump($alumno1);
echo "<br><br>";

$alumno2 = new Alumno("Pedro" , 40);
var_dump($alumno2);
echo "<br><br>";

//acceso a constante, hay que llamar a la clase ya que es un valor común a todos los objetos
echo "Tasa de la matricula: ";
echo Alumno::TASA_MATRICULA;
echo "<br><br>";

//acceso a valor estático, hay que llamar a la clase ya que es un valor común a todos los objetos
echo "Número de la última matricula: ";
echo Alumno::$numeroMatricula;
echo "<br><br>";


$alumno3 = new Alumno("Pedro" , 17);
var_dump($alumno3);
echo "<br>";
echo "Número de la última matricula: ";
echo Alumno::$numeroMatricula;
echo "<br><br>";

echo $alumno3->calcularImporteMatricula();
echo $alumno1->calcularImporteMatricula();

$alumno1->agregarAlumno();






?>