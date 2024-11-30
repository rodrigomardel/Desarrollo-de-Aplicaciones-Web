<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EJ2-RMD-20241001</title>
</head>
<body>
    <?php
    /*Construye un array asociativo, que almacene las horas lectivas de cada módulo de 2º DAW Visualiza 
    sus valores de la forma más legible que sepas.*/

    $horasLectivas2DAW = ['DWEC' => 8, 'DWES' => 9, 'DAW' => 4, 'DIW' => 6, 'EIE' => 3];

    foreach($horasLectivas2DAW as $modulo => $horas){
        echo "El módulo $modulo tiene $horas horas semanales. <br>";

    }
    ?> 
</body>
</html>