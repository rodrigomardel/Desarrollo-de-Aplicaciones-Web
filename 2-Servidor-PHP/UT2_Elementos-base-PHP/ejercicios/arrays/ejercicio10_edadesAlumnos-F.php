<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EJ10-RMD-20241006</title>
</head>
<body>
    <?php
    /*
    Es preciso llevar un control sobre la edad de los alumnos matriculados en los Ciclos Formativos de la familia de Informática 
    y Comunicaciones del CIFP Juan de Colonia. Interesa recoger de cada ciclo:

        Nº de alumnos menores de edad.
        Nº de alumnos entre 18 y 22.
        Nº de alumnos mayores de 22.

        ¿En algún ciclo solo hay alumnos entre 18 y 22 años? Indica si de da está situación con un mensaje.
    */
    $contador = 0;
    $mensaje = "";
    $matriculasInformaticaComunicaciones = ['IC' => [  "A001" => 18,
                                                        "A002" => 22,
                                                        "A003" => 28,
                                                        "A004" => 19,
                                                        "A005" => 17,
                                                        "A006" => 17,
                                                        "A007" => 20,
                                                        "A008" => 26], //2menores, 4mitad, 2mayores
                                            'SMR' =>[   "A009" => 17,
                                                        "A010" => 27,
                                                        "A011" => 30,
                                                        "A012" => 22,
                                                        "A013" => 20,
                                                        "A014" => 17,
                                                        "A015" => 39,
                                                        "A016" => 26], //2menores, 2mitad, 4mayores
                                             'ASIR'=>[ "A021" => 18,
                                                        "A022" => 20,
                                                        "A023" => 22,
                                                        "A024" => 19,
                                                        "A025" => 21,
                                                        "A026" => 18,
                                                        "A027" => 22,
                                                        "A028" => 20], //8mitad
                                             'DAW'=>[   "A029" => 25,
                                                        "A030" => 19,
                                                        "A031" => 20,
                                                        "A032" => 21,
                                                        "A033" => 18,
                                                        "A034" => 22,
                                                        "A035" => 20,
                                                        "A036" => 17], //1menor, 6mitad, 1mayor
                                             'DAM'=>[   "A037" => 16,
                                                        "A038" => 17,
                                                        "A039" => 19,
                                                        "A040" => 22,
                                                        "A041" => 28,
                                                        "A042" => 35,
                                                        "A043" => 40,
                                                        "A044" => 50] //2menores, 2entre, 4mayores 
                                            ];

    //Menores de edad
    echo "<strong> Número de alumnos menores de edad: </strong> <br>";
    foreach($matriculasInformaticaComunicaciones as $ciclo => $alumnos){
        echo "$ciclo → ";

            foreach($alumnos as $matricula => $edad){
                if($edad < 18)
                $contador++;
            }

        echo "$contador alumnos. <br>";
        $contador = 0;
    }      
    echo "<br><br>";
    
    //Entre 18 y 22
    echo "<strong> Número de alumnos entre 18 y 22 años: </strong> <br>";
    foreach($matriculasInformaticaComunicaciones as $ciclo => $alumnos){
        echo "$ciclo → ";

            foreach($alumnos as $matricula => $edad){
                if($edad >= 18 && $edad <= 22)
                $contador++;
            }

        if(count($alumnos) == $contador ){
            echo "¡Todos los alumnos! $contador alumnos.<br>";
        } else{      
            echo "$contador alumnos.<br>";
        }
        
        $contador = 0;
    }      
    echo "<br><br>";

    //Mayores de 22
    echo "<strong> Número de alumnos mayores de 22: </strong> <br>";
    foreach($matriculasInformaticaComunicaciones as $ciclo => $alumnos){
        echo "$ciclo → ";

            foreach($alumnos as $matricula => $edad){
                if($edad > 22)
                $contador++;
            }

        echo "$contador alumnos. <br>";
        $contador = 0;
    }      
    echo "<br><br>";
?>
    
</body>
</html>