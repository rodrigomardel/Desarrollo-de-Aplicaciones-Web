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
    /*Inicializa una variable a un valor entero de tres cifras.
     Determinar si es capicúa.*/
    
    $num = 5225;
    $numCopiaTexto = "";
    $numCopia = $num;

    while($numCopia > 0){
        $numCopiaTexto = $numCopiaTexto. (string)($numCopia % 10);
        $numCopia = (int)($numCopia / 10);
    }

    echo "El número ", $num, ( $num == (int)$numCopiaTexto ? " es capicúa" : " no es capicúa"); 

  
    ?>
</body>
</html>