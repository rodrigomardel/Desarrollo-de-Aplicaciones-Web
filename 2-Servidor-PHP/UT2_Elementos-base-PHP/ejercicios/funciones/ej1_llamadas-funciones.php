<?php

require_once('ej1_funcionesArray.php');

$numerosEnteros = [1,-2,20,88,22,-20,5,-44];
//$numerosEnteros = [1,-2,4,88,8,-20,5,-44];
$count = 0;


echo numerosNegativos ($numerosEnteros, $count);
echo "<br><br>";

echo media ($numerosEnteros);
echo "<br><br>";

echo cuadradoPoscicion ($numerosEnteros);
echo "<br><br>";


?>