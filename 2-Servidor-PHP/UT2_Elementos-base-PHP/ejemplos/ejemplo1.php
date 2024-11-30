<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ejemplo1-echo</title>
</head>
<body>
    <?php
    $nombre = "Rodrigo";
    
    echo "Hola", $nombre;
    echo "Hola <br>", $nombre;
    echo "Hola ","<b>",$nombre,"</b>";
    echo "Hola <b>$nombre</b>";
    echo 'Hola <b>$nombre</b>',"<br>";

    $num = 4;
    echo var_dump($num), "<br>";
    $num = 4.5;
    echo var_dump($num), "<br>";
    $otro = NULL;
    echo var_dump($otro), "<br>";
    $estado = true;
    echo var_dump($estado), "<br>";

    foreach ($_SERVER as $componente => $valor){
        echo "$componente: $valor <br>";
    }
    ?>   
</body>
</html>