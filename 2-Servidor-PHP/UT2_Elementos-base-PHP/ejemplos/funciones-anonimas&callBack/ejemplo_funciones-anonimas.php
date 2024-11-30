<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    /*Fuerza a que los tipos de datos de la llamada sean los especificados en la definición*/
    //declare(strict_types=1);

    require_once ("./ejemplo-callBack.php");
    /*Función anónima que reciba un número entero y visualice un mensaje.
    "Este es el número elegido →"*/
    $numeroElegido = function (int $num):void{
        echo "Este es el número elegido → $num <br>";
    };
    $numeroElegido(4);

    /*Función anónima para dibujar una línea de asteriscos en base al número*/
    $dibujar = function (int $num):string{
            echo "El dibujo obtenido es: ";
            $linea="";
            for($i = 1; $i <= $num; $i++){
                $linea .= '*';
            }
            return $linea;
    };


    $l = $dibujar(4);
    echo "$l <br> <br>";

    //Llamadas a funciones mediante call back incluidas en el archivo «ejemplo-callBack.php»;
    mostrar($numeroElegido,8);
    echo mostrar2($dibujar,8);

    ?>
    
</body>
</html>