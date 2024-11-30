<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejemplo de manipular variables y los tipos de datos</title>
</head>
<body>
    <?php

    //Es considerada vacía
    $valor = 0;
    if(empty($valor)){
        echo "Es una variable vacía $valor"." <br> ";
    }

    //Está definida
    if(isset($valor)){
        echo "Es una variable definida $valor"."<br>";
    }

    ?>
    
</body>
</html>