<?php
namespace ej4\main;

require_once("./Persona.php");
require_once("./Joven.php");

use ej4\Persona as per;
use ej4\Joven as jov;

$joven1 = new jov\Joven(1,17);
jov\Joven::modificarStatic();
echo $joven1->visualizar();
echo $joven1->ayudas();
echo $joven1->mensaje();
echo $joven1->getNumEstudiantes();



// var_dump($joven1);


?>