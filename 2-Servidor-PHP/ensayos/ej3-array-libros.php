<?php

$libros = ["Novela" => ["La perla", "La larga marcha", "La milla verde"],
            "Programación" => ["Java Limpio", "PHP8"],
            "Aventura" => ["RumboBici", "Cry Freedom", "Nacidos para correr", "Acampada libre"]];





function contarLibrosPorGenero($array) {
    $numLibros = 0;
    $resultado = "";

    foreach ($array as $genero => $libros) {     
        $numLibros = count($libros);   
        $resultado .= $genero ." tiene ". $numLibros. " libros <br>";
    }
    
    return $resultado;
}
echo $resultado = contarLibrosPorGenero($libros);
echo "<br>";


function consultarGenero($titulo, $array):string{
    foreach($array as $genero => $libros){
        foreach($libros as $libro){
            if($libro == $titulo){
                return $genero;
            }
        }
    }
}
echo consultarGenero("Java Limpio",$libros);
echo "<br>";


function porcentajeLibrosPorGenero($array) {
    $totalLibros = 0;
    $resultado = "";

    foreach ($array as $libros) {
        $totalLibros += count($libros);
    }

    foreach ($array as $genero => $libros) {     
        $numLibros = count($libros);   
        $porcentaje = ($numLibros / $totalLibros) * 100;
        $resultado .= $genero . " tiene " . round($porcentaje, 2) . "% de los libros.<br>";
    }
    
    return $resultado;
}

echo porcentajeLibrosPorGenero($libros);
echo "<br>";



function Hola(){
    echo "Adios";
}
$funcionAnterior = "Hola";
$funcionAnterior();


?>