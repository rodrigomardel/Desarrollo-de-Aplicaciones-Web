<?php
namespace ej3c\main;

require_once("./Alumno.php");
require_once("./Primero.php");
require_once("./Segundo.php");



use ej3c\Alumno as alum;
use ej3c\Primero as pri;
use ej3c\Segundo as seg;

/*Plantéate esta actividad utilizando clases y métodos abstractos.*/

//Primer curso
echo "<h4>Resultados primer curso:</h4>";
$resultado1CursoJaime = ""; //recoge el resultado de superaCursoPrimero() que se ha pasado por referencia
$alumno1primero = new pri\Primero("Jaime", 30, 8);
echo $alumno1primero->superaCurso($resultado1CursoJaime);


$resultado1CursoClaudia = ""; //recoge el resultado de superaCursoPrimero() que se ha pasado por referencia
$alumno2primero = new pri\Primero("Claudia", 33, 4);
echo $alumno2primero->superaCurso($resultado1CursoClaudia);
echo "<br> <br>";

//Segundo curso
echo "<h4>Resultados segundo curso:</h4>";
$alumno1segundo = new seg\Segundo ("Jaime", 30, 5, "aprobado", 6);
echo $alumno1segundo-> superaCurso($resultado1CursoJaime);

$alumno1segundo = new seg\Segundo ("Claudia", 33, 6, "suspenso", 6);
echo $alumno1segundo-> superaCurso($resultado1CursoClaudia);












?>