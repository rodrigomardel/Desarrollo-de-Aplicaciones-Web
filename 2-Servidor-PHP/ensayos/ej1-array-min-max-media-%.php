<?php

/*Crea un array asociativo bidimensional para almacenar información de estudiantes. 
Cada estudiante debe tener un nombre y tres notas de evaluación.
Implementa las siguientes funciones en PHP:
Una función que calcule la nota máxima y mínima de cada estudiante.
Una función que calcule la media de cada estudiante.
Una función que calcule el porcentaje de estudiantes aprobados (nota media >= 5).
Muestra los resultados en pantalla, incluyendo el porcentaje de estudiantes aprobados.*/

$estudiantes1EV = ["Juan Delgado" => [5,6,7], 
                "Rodrigo Martínez" => [6,8,8], 
                "Óscar Perez" => [4,5,4],
                "Raúl Perez" => [4,5,4]];



/*Calculo nota mínima*/                
function notaMin($array): string {
    $texto = "";
    
    foreach ($array as $estudiante => $evaluacion) {
        $min = 999999;
        foreach ($evaluacion as $value) {
            if($min > $value){
                $min = $value;
            }
        }
        $texto .= "$estudiante su nota mínima es  → $min <br>";
    }
    return $texto;
}

echo "<h4>Nota mínima</h4>";
echo notaMin($estudiantes1EV);
echo "<br><br>";

/*Calculo nota máxima*/                
function notaMax($array): string {
    $texto = "";
    
    foreach ($array as $estudiante => $evaluacion) {
        $max = -999999;
        foreach ($evaluacion as $value) {
            if($max < $value){
                $max = $value;
            }
        }
        $texto .= "$estudiante su nota máxima es  → $max <br>";
    }
    return $texto;
}

echo "<h4>Nota máxima</h4>";
echo notaMax($estudiantes1EV);
echo "<br><br>";

/*Calculo nota media*/                
function notaMedia($array): string {
    $texto = "";
    
    foreach ($array as $estudiante => $evaluacion) {
        $contador = 0; 
        $total = 0;
        foreach ($evaluacion as $value) {
            $total += $value;
            $contador ++;
        }
        $texto .= "$estudiante su nota media es  →". $total/$contador. "<br>";
    }
    return $texto;
}

echo "<h4>Nota media</h4>";
echo notaMedia($estudiantes1EV);
echo "<br><br>";

/*Calculo porcentaje estudiantes aprobados*/
function porcentajeAprobados($array): float {
    $totalEstudiantes = count($array); 
    $aprobados = 0; 

    foreach ($array as $evaluacion) {
        $sumaNotas = 0;
        
        foreach ($evaluacion as $nota) {
            $sumaNotas += $nota;
        }
        $media = $sumaNotas / count($evaluacion);

        if ($media >= 5) {
            $aprobados++;
        }
    }

    $porcentajeAprobados = ($aprobados / $totalEstudiantes) * 100;

    return $porcentajeAprobados;
}

echo "<h4>Porcentaje aprobados</h4>";
echo porcentajeAprobados($estudiantes1EV);
echo "<br><br>";

?>

