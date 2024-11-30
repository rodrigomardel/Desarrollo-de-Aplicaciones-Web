<?php
namespace ej3\main;

require_once("./Alumno.php");
require_once("./Primero.php");
require_once("./Segundo.php");


use ej3\Alumno as alum;
use ej3\Primero as pri;
use ej3\Segundo as seg;

/*
Diseña una nueva clase Primero que extienda de Alumno: 
− Nuevo atributo, nota media del curso 
− Nuevo método, supera_curso (para ello la media será >= a 5). Diseña otra nueva clase, Segundo que extiende de Alumno: 
− Nuevo atributo, nota media del curso − Nuevo atributo, calificación de la FCT (valores posibles “apto” o “no apto”) 
− Nuevo atributo, calificación del módulo de proyecto 

− implementa el método supera_curso; en este caso el alumno de segundo, supera el curso si la media del curso es >=5, 
supera el proyecto y obtiene “apto” en la FCT y supera primero.
*/

// Creación y visualización user1
// $alumno1 = new alum\Alumno("Jaime", 30);
// echo $alumno1->Visualizar(). "<br>";

//Primer curso
echo "<h4>Resultados primer curso:</h4>";
$resultado1CursoJaime = ""; //recoge el resultado de superaCursoPrimero() que se ha pasado por referencia
$alumno1primero = new pri\Primero("Jaime", 30, 8);
echo $alumno1primero->superaCursoPrimero($resultado1CursoJaime);


$resultado1CursoClaudia = ""; //recoge el resultado de superaCursoPrimero() que se ha pasado por referencia
$alumno2primero = new pri\Primero("Claudia", 33, 4);
echo $alumno2primero->superaCursoPrimero($resultado1CursoClaudia);
echo "<br> <br>";

//Segundo curso
echo "<h4>Resultados segundo curso:</h4>";
$alumno1segundo = new seg\Segundo ("Jaime", 30, 5, "aprobado", 6);
echo $alumno1segundo-> superaCursoSegundo($resultado1CursoJaime);

$alumno1segundo = new seg\Segundo ("Claudia", 33, 6, "suspenso", 6);
echo $alumno1segundo-> superaCursoSegundo($resultado1CursoClaudia);
echo "<br> <br>";

//Alumno
$alumno1 = new alum\Alumno("Rodrigo", 37);
echo $alumno1. "<br>";//toString mágico 
echo $alumno1->nombre. "<br>"; //get mágico
$alumno1->nombre = "Pedro";
echo $alumno1->nombre. "<br>"; //get mágico
echo $alumno1. "<br>";//toString mágico 












?>