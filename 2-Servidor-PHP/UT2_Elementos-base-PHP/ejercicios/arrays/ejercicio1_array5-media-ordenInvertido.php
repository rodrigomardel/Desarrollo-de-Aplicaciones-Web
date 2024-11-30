<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EJ1-RMD-20241001</title>
</head>
<body>
    <?php
    /*Construir un array de 5 componentes de tipo int (valores positivos y negativos)*/

    $numerosEnteros = [1,-2,14,88,-10];

    $suma = 0;
    $numElementos = 0;
    $arrayInvertido = [];
    $arrayNuevo = [];
    $valorDoble = 0;
    

    /*Muestra el número de componentes negativas.*/
    echo "Valores negativos de la matriz: <br>";
    foreach($numerosEnteros as $valor){
        if($valor<0 && is_int($valor)){
            echo "$valor <br>";
        } 
    }
    echo "<br><br>";



    /*Muestra la media de las componentes.*/
        foreach($numerosEnteros as $valor){
        $numElementos++;
        $suma += $valor;     
    }
    echo "Media: ". $suma / $numElementos. "<br>";
    echo "<br><br>";
 


    /*Visualiza las posiciones del array en las que se almacene como valor el cuadrado de su posición.
    Si no se da esta circunstancia en ninguna componente, indícalo con un sencillo mensaje.*/   
    foreach($numerosEnteros as $posicion => $valor){
        if($posicion*2 == $valor){
            echo "El cuadrado de la posición: $posicion → corresponde con su valor: $valor <br>";
        }else if ($posicion*2 != $valor){
            echo "El cuadrado de la posición: $posicion → <strong>NO</strong> corresponde con su valor: $valor <br>";
        }
    }
    echo "<br><br>";



    /*Visualizar el array en orden invertido.*/
    foreach($numerosEnteros as $valor){
        $arrayInvertido[]=$valor;
        $numElementos++;
    }
    echo "Matriz en orden invertido: <br>";
    for ($i = $numElementos - 1; $i >= 0; $i--) {
        echo $arrayInvertido[$i].",";
    }
    echo "<br><br>";



    /*Crear un nuevo array cuyos componentes tomarán como valor el doble de los componentes de este primer array.*/
    echo "Matriz con valores dobles: <br>";
    foreach($numerosEnteros as $valor){
        $arrayNuevo[$valorDoble] = $valor * 2;
        echo $arrayNuevo[$valorDoble].",";
    }
    echo "<br><br>";


    
    /*Incrementa en dos más sus componentes y calcula de nuevo la media de ellas.*/
    $numeroElementos = 0;
    $numerosEnteros[] = 12;
    $numerosEnteros[] = 10;
    echo "Media matriz incrementada: <br>";
    echo "Matriz →";

    foreach ($numerosEnteros as $valor){
        $suma += $valor;
        $numeroElementos++;
        echo $valor. ",";
    }
    echo "<br>";
    echo "Media: ". $suma /  $numeroElementos. "<br>";
  
    ?>
</body>
</html>