<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EJ9-20241004-RMD</title>
</head>
<body>
    <?php
    /*
    Supongamos que hay 5 alumnos en DWES que obtienen de nota final un sobresaliente. 
    Crear un array bidimensional que almacene de los 5 alumnos su número de matrícula y la calificación obtenida en la 1ª y en la 2ª evaluación. 
    */
    
    
    //Arreglar con notas reales para calcular media.
    $alumnosNotaSobresaliente = ['1ª Evaluación' => 
                                    ['A2023' => 9.2,
                                    'M4567' => 9.5, 
                                    'E2309' => 9.9,
                                    'B2021' => 9,
                                    'B2022' => 9],
                                    
                                '2ª Evaluación' =>
                                ['A2023' => 9,
                                'M4567' => 9, 
                                'E2309' => 9.7,
                                'B2021' => 9.1,
                                'B2022' => 10]
                               ];


    //Muestra los números de matrícula junto a las medias obtenidas
    echo "<strong> - Matriculas y notas medias por evaluación - <strong><br><br>";
    foreach($alumnosNotaSobresaliente as $evaluacion => $resultados){
        echo "$evaluacion <br>";
        foreach ($resultados as $matricula => $nota){
           echo "Nº de matricula: $matricula - Nota: $nota <br>";
        }
    }
    echo "<br><br><br>";


    $max = 0;
    //Muestra la media más alta junto a su matrícula
    echo "<strong> - Matricula y nota más alta - <strong><br><br>";
    foreach($alumnosNotaSobresaliente as $evaluacion){
        foreach ($evaluacion as $matricula => $nota){
            if($max < $nota){
                $max = $nota;
            }
        }
    }
    echo "Nº de matricula: $matricula - Nota: $nota <br>";

    ?>
    
</body>
</html>