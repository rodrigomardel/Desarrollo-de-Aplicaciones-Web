<?php
    require_once("./datos.inc");
    require_once("./funciones.php");
    
    //1.a
    $totalPlazasOnline;
    echo totalPlazasOnline($centrosFP, $totalPlazasOnline);
    echo "Total plazas online ". $totalPlazasOnline. "<br>";

    //1.b
    print_r(nombreCentrosOnline($centrosFP));
    echo "<br>";

    //1.c
    print_r(numPlazasOnline($centrosFP, "J. de Colonia"));
    echo "<br>";
    print_r(numPlazasOnline($centrosFP, "Florez"));
    echo "<br>";
    print_r(numPlazasOnline($centrosFP, "S. de Colonia"));







?>