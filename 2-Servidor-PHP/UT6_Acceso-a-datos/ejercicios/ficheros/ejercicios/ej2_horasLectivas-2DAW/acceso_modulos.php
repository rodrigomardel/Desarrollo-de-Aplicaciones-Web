<?php
$horasLectivas2DAW = ['DWEC' => 8, 'DWES' => 9, 'DAW' => 4, 'DIW' => 6, 'EIE' => 3];

$nomFichero = 'horasLectivas_Modulos2DAW.txt';

//Apertura del archivo para lectura y escritura, coloca el puntero al final del archivo
$ficheroModulos = fopen($nomFichero, 'a+');

//Escritura recorriendo los elementos del array
foreach ($horasLectivas2DAW as $modulo => $horas) {
    fwrite($ficheroModulos, "Horas lectivas $modulo: ".$horas. PHP_EOL);
}

fclose($ficheroModulos);
echo "Elementos agregados";
?>