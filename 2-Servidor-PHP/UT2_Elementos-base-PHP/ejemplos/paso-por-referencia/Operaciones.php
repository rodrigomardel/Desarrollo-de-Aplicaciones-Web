<?php
function operacion(&$a, $b){
    $aux = $a;//guardamos el paso por referencia
    $a = $a * $b;//caso de la multiplicacion y el resultado se devuelve por referencia
    return ($aux + $b);
}

$num1 = 5;
$num2 = 10;
echo "La suma es ". operacion($num1, $num2). "<br>";
echo "La multiplicación es $num1";

?>