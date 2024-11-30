<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EJ11-RMD-20241007</title>
</head>
<body>
        <?php
        /*
        Palíndromo es aquel texto que se lee igual de derecha a izquierda que de izquierda a derecha (ej: Dabale arroz a la zorra el abad). 
        Es el típico manejo de string como si fuera un array indexado. Para determinar que un string es un palíndromo:
        
            Tratar el string a un array unidimensional
            Eliminar del array los caracteres blancos
            Crear un nuevo array con los mismos caracteres pero en orden invertido.
            Compararlos; si son iguales, la frase es un palíndromo
            Comprueba que es palíndromo “A mi me mima”.
            Comprueba que no es palíndromo “A mi no me mima”.
        */

        $frase = "a Mi mE mimA";

        /* Revisar no funciona
        // $fraseSinEspacios = "";

        // for($i = 0; $i < strlen($frase); $i++){
        //     if($frase[$i] != " "){
        //         $fraseSinEspacios .= $frase[$i];
        //     }
        // }

        // $palindromo = true;
        // $ultimoCaracter = strlen($fraseSinEspacios)-1;

        // for ($i = 0;($i < strlen($fraseSinEspacios) && $palindromo); $i++, $ultimoCaracter--){
        //     if($fraseSinEspacios[$i] != $fraseSinEspacios[$ultimoCaracter--]){
        //         $palindromo = false;
        //     }

        //     if($palindromo){
        //         echo "La frase $frase es un palindromo"."<br>";
        //     } else {
        //         echo "La frase $frase NO es un palindromo"."<br>";
        //     }

        // }*/

        /*Con uso de funciones de string*/

        $fraseEnMinusculas = strtolower($frase);
        $arrayFrase = explode(" ", $fraseEnMinusculas);
        $fraseMinusculasSinEspacios = implode("", $arrayFrase);// $fraseUnidaMinusculasSinEspacios = implode($arrayFrase);

        $fraseInvertida = strrev($fraseMinusculasSinEspacios);

        if (strcmp($fraseMinusculasSinEspacios,$fraseInvertida) == 0){
            echo "La frase $frase es un palindromo.";
        } else {
            echo "La frase $frase NO es un palindromo.";

        }

        ?>
</body>
</html>