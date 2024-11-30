<?php

require_once("./Persona.php");
require_once("./OperacionesEstudiante.php");
require_once("./Estudiante.php");


$notasEstudiante1 = [4,6,3,4];
$estudiante1 = new Estudiante("Rodrigo", 37, $notasEstudiante1);


$estudiante1::registrarEstudiante();
echo $estudiante1->mostrarInfo();
echo $estudiante1->calcularMedia();
echo $estudiante1->estaAprobado();




?>