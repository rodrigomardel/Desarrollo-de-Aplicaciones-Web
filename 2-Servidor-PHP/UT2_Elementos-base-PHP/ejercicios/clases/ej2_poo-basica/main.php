<?php
namespace ej2\main;

require_once("./Alumno.php");
require_once("./Becado.php");

use ej2\Alumno as alum;
use ej2\Becado as bec;

$alumno1 = new alum\Alumno("Jaime", 30);
echo $alumno1->Visualizar(). "<br>";
echo alum\Alumno::$ciclo. "<br><br>";

$becado1 = new bec\Becado("Javier", 20, 1500);
echo $becado1->Visualizar(). "<br>";







?>