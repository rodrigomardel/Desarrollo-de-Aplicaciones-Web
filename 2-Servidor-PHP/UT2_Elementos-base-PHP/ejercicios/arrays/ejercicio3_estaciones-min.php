<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EJ3-RMD-20241001</title>
</head>
<body>
    <?php
    /*
    Construye un array asociativo, donde las componentes son las cuatro estaciones del año. 
    Almacena en cada componente los días lectivos correspondientes.
        Muestra la estación con menor número de días lectivos.
        Calcula el total de días lectivos.
    */

    $diasLectivosEstacionales = ['Primavera' => 50, 'Verano' =>10, 'Otoño' => 60, 'Invierno' => 40];
    $min = 99999;
    $totalDiasLectivos = 0;

    foreach($diasLectivosEstacionales as $estacion => $horas){
       if ($min > $horas){
            $min = $horas;
            $texto = "$estacion es la estación con menor horas lectivas → {$min}h.";
        }
        $totalDiasLectivos += $horas;
    }

    echo $texto. "<br>";
    echo "El total de días lectivos anuales es de $totalDiasLectivos.";
    ?>
</body>
</html>