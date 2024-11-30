<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Arrays asociativos-RMD-20240926</title>
</head>
<body>
    <?php
    /*
    Ejemplo array asociativo para almacenar las horas lectivas diarias
    del módulo DWES.
    */

    $horasDiariasDWES = ['Lunes' => 2, 'Martes' => 3, 'Miércoles' => 0,
    'Jueves' => 2, 'Viernes' => 2];

    $totalHorasSemanales  = 0;
    
    foreach ($horasDiariasDWES as $dias => $horas) {
        echo "Los $dias hay $horas horas de DWES. <br>";
    }
    foreach ($horasDiariasDWES as $horas) {
        $totalHorasSemanales += $horas;
    }
    echo "El total de las horas semanales de DWES son <strong>$totalHorasSemanales</strong> <br><br>";


    /*Ejemplo array asociativo bidimensional*/
    $ganadores = ['Fiestas_2023' => array ('Tenis' => 'María Alonso', //unsando metodo array()
                                            'Ajedrez' => 'Antonio López',
                                            'Ping pong' => 'Ana Benito',
                                            'Mus' => 'Luis Martín'),
                  'Fiestas_2024' => ['Tenis' => 'Alba Gómez', //sintaxis «[]»
                                     'Ajedrez' => 'Sofía Perez',
                                     'Baile' => 'Benito Bailón']
                 ];
    
    var_dump($ganadores);
    echo "<br><br><br>";  
    
    //Competición y ganadores
    foreach($ganadores as $anno){
        foreach ($anno as $competicion => $ganador){
            echo "$competicion: $ganador<br>";
           
        }
    }
    echo "<br><br><br>";  

    //Año de fiestas, competición y ganadores
    foreach($ganadores as $fiesta => $anno){
        echo "$fiesta <br>";

        foreach ($anno as $competicion => $ganador){
            echo "$competicion: $ganador<br>";
        }
    }
    echo "<br><br><br>"; 

    /*
    Array para almacenar las horas lectivas de cada módulo de primero y segundo.
    */

    $horasModulosDAW = ['1ºDAW' => ['PR' => 8, 'BD' => 6, 'FOL' => 3, 'ED' => 3, 'SI' => 6, 'LM' => 4],
                        '2ºDAW' => ['DWEC' => 8, 'DWES' => 9, 'DAW' => 4, 'EIE' => 3, 'DIW' => 6]];

    
    //Mostrar las horas lectivas de cada módulo
    foreach($horasModulosDAW as $anno){
        foreach($anno as $modulo => $horas)
        echo "$modulo tiene $horas semanales <br>";
    }
    echo "<br><br>"; 

    //Mostrar las horas lectivas de cada módulo y curso
    foreach($horasModulosDAW as $anno => $curso){
        echo "<br>";
        echo "Curso → $anno <br>";
        foreach($curso as $modulo => $horas){
            echo "$modulo tiene $horas semanales <br>";
        }
    }
    echo "<br><br><br>"; 

    // Mostrar el total de horas lectivas de cada curso
    foreach($horasModulosDAW as $anno => $curso){
        echo "Curso → $anno ";
        $horasTotales = 0;
        foreach($curso as $modulo => $horas){
            $horasTotales += $horas;
        }
        echo "tiene $horasTotales horas totales. <br>";
    }

    /*Almacenar el número de equipos en la aulas de informática*/
    $equiposTotalesInformatica = ['1º DAW/DAM' => 25, '2º DAW/DAM' => 15, '1º ASIR' => 30, 
                                '2º ASIR' => 30, '1º SMR' => 20, '2º SMR' => 20];
    ?>



    
</body>
</html>