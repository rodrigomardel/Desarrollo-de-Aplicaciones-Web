<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio1-RMD-20240924</title>
</head>
<body>
    <?php
    /*Diseña un script para que con
    las variables $valor=50
    y $aux=‘producto’, obtengas
    las siguientes salidas en pantalla:*/
    
    $valor = 50;
    $aux ='producto';

    echo "Este '$aux'", " cuesta {$valor}$ <br>";
    echo "Este \"$aux\"", " cuesta {$valor}$ <br>";
    echo "Este $aux", ' cuesta $valor \$ <br>';
    echo "$aux: $valor \$ <br>";
    echo "{$aux}s", ": $valor \$"
    ?>
</body>
</html>