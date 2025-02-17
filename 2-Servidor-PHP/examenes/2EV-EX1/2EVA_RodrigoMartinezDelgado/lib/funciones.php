<?php
 function mostrarLocalidades($resultadoConsulta){
    echo "<h2>Localidades donde se dispone de centros de acogida:</h2><ul>";
    while($arrayFila = $resultadoConsulta->fetch()){
        echo "<li>$arrayFila[0]</li>";
    }
    echo "</ul>";
}

function mostrarNombreYespecies($resultadoConsulta){
    echo "<h2>Nombre y especies:</h2><ul>";
    while($arrayFila = $resultadoConsulta->fetch()){
        echo "<li>$arrayFila[0] $arrayFila[1]</li>";
    }
    echo "</ul>";
}

function mostrarNumeroPerros($resultadoConsulta){
    echo "<h2>Actualmente en los centros hay un total de: ";
    while($arrayFila = $resultadoConsulta->fetch()){
        echo "$arrayFila[0]";
    }
    echo " perros</h2>";
}

function mostrarNumeroGatos($resultadoConsulta){
    echo "<h2>Actualmente en los centros hay un total de: ";
    while($arrayFila = $resultadoConsulta->fetch()){
        echo "$arrayFila[0]";
    }
    echo " gatos</h2>";
}
?>