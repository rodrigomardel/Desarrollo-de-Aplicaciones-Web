<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio2-RMD-20240924</title>
</head>
<body>
    <?php
    /*Inicializa tres variables numéricas al valor que tú quieras y:
    a) Visualiza cuál es el mayor
    b) Visualiza el número de máximos*/
    
    $num1 = 4;
    $num2 = 5;
    $num3 = 7;
    
    $contadorMaximos = 1;
    $maxProvisional = $num1;

    
    if($maxProvisional < $num2){
        $maxProvisional = $num2;
        $contadorMaximos = 1;   
        } else if ($num2 == $maxProvisional){
            $contadorMaximos ++;
        }

    if($maxProvisional < $num3){
        $maxProvisional = $num3;
        $contadorMaximos = 1;   
        } else if ($num3 == $maxProvisional){
            $contadorMaximos ++;
        }

    $maximo = $maxProvisional;

    echo "$maximo es el máximo <br>";
    echo "$contadorMaximos es el número de máximos <br>";
    ?>
</body>
</html>