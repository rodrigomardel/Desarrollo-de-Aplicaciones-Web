<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio6-RMD-20240924</title>
</head>
<body>
    <?php
    /*Muestra en pantalla la suma de los números del 1 al 100 no terminados en 3.*/
    
    for ($i = 1; $i <= 100; $i++){
        $ultimoNumero = "";
        
        $ultimoNumero = $ultimoNumero. (string)($i % 10);

        if($ultimoNumero != 3){
            echo "$i<br>";
            $suma += $i;
        }
    }

    echo "Total: $suma";
    ?>
</body>
</html>