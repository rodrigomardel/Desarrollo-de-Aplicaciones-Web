<?php
namespace ej3b\main;

require_once("./Alumno.php");
require_once("./Primero.php");


use ej3b\Alumno as alum;
use ej3b\Primero as pri;

/*
Diseña una nueva clase Primero que extienda de Alumno: 
− Nuevo atributo, las calificaciones de los módulos del curso se recogen en un array 
− Nuevo método que calcule la media de las calificaciones.
*/

$notasPrimeroJaime = ['ED' => 8, "PR" => 8, "BD" => 9, "FOL" => 8, "SI" => 7];
$notasPrimeroClaudia = ['ED' => 4, "PR" => 6, "BD" => 3, "FOL" => 4, "SI" => 4];

//Primer curso
echo "<h4>Resultados primer curso:</h4>";
$alumno1primero = new pri\Primero("Jaime", 30, $notasPrimeroJaime);
$mediaPrimero =  $alumno1primero->calculoMediaA();
echo $alumno1primero->superaCursoPrimero($mediaPrimero);
echo "<br>";


$alumno2primero = new pri\Primero("Claudia", 33, $notasPrimeroClaudia);
$mediaPrimero =  $alumno2primero->calculoMediaA($notasPrimeroClaudia);
echo $alumno2primero->superaCursoPrimero($mediaPrimero);










?>