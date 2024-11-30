<?php
date_default_timezone_set("Europe/Madrid");

require_once("./Familia.php");
require_once("./FamiliaGastos.php");

$añoActual = date("Y");
$mesAnterior  = mktime(0, 0, 0, date("m")-1, date("d"),   date("Y"));
$importeGastos = ["Alimentacion" => 150,
                "Higiene personal" => 50,
                "Recibos" => 100,
                "Ocio" => 60];
$importeGastos1 = ["Alimentacion" => 120,
                "Higiene personal" => 10,
                "Recibos" => 300,
                "Ocio" => 60];
                

$familia1 = new FamiliaGastos(3000,2, $añoActual,$mesAnterior,$importeGastos);
echo "<br>";

echo $familia1->importeTotalGastos();

$familia2 = new FamiliaGastos(2000,4, $añoActual,$mesAnterior,$importeGastos);
echo "<br>";

echo $familia2->importeTotalGastos();







?>