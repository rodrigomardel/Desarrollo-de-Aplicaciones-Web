<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UT2_EJ-6_RMD_20240930</title>
</head>
<body>
    <?php
    /*
    Inicializa una variable numérica a un valor entero el cual representa una cantidad de euros; 
    muestra en pantalla la misma cantidad pero expresada en billetes (de 100, 50, 20, 10 y 5 €). 
    El número de euros será un valor positivo; si es negativo mostrar un mensaje comunicando el error.
    */

    $totalEuros = 257;

    $billetes100 = 0;
    $billetes50 = 0;
    $billetes20 = 0;
    $billetes10 = 0;
    $billetes5 = 0;

    if($totalEuros<0){
        echo "Valor no válido";
    } else {
        $billetes100 = (int) ($totalEuros/100);
        $totalEuros  -=  $billetes100*100;
        echo "$billetes100 billete/s de 100€.<br>";

        $billetes50 = (int) ($totalEuros/50);
        $totalEuros  -=  $billetes50*50;
        echo "$billetes50 billete/s de 50€.<br>";

        $billetes20 = (int) ($totalEuros/20);
        $totalEuros  -=  $billetes20*20;
        echo "$billetes20 billete/s de 20€.<br>";

        $billetes10 = (int) ($totalEuros/10);
        $totalEuros  -=  $billetes10*10;
        echo "$billetes10 billete/s de 10€.<br>";

        $billetes5 = (int) ($totalEuros/5);
        $totalEuros  -=  $billetes5*5;
        echo "$billetes5 billete/s de 5€.<br>";
        echo "Sobran $totalEuros monedas";
    }

    ?>
</body>
</html>