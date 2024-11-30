<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EJ19-RMD-20241008</title>
</head>
<body>
    <?php
    /*¿Cuál es la salida de cada uno de estos scripts?:*/

    /*Caso 1*/
    $var1 = 1;
    function ambito1(){
        $var2 = $var1;    //$var1 no se encuentra dentro del ámbito de la función por lo tanto $var2 no recibe ningún valor
        echo "Pasando por ambito1(): ";
        echo var_dump($var2)."<br>";
    }
    ambito1();//Salida ⇾  NULL


    /*Caso 2*/
    function ambito2(){
        global $var1; //Define a $var1 como variable global para todo el script
        $var2 = $var1; //a $var2 se le asigna el valor de $var1
        echo "Pasando por ambito2(): ";
        echo $var2."<br>";
    }
    ambito2();//Salida ⇾  1


    /*Caso 3*/
    function ambito3(){
        global $var1; //Define a $var1 como variable global para todo el script
        $var1++;
        echo "Pasando por ambito3():", $var1,"<br>";
    }
    ambito3();//Salida ⇾ Pasando por ambito3(): 2
    $var1++;
    echo "Pasando por ambito3():", $var1,"<br>";//Salida ⇾  3


    //**** valor actual de var1 == 3;
    /*Caso 4*/
    function ambito4(){
        global $var1; //Define a $var1 como variable global para todo el script
        static $var3 = 1;//Define a var3 como variable estática, su valor no es destruido al finalizar la función cuando se vuelve a llamar a la función toma el último valor. 
        $var2 = $var1 + $var3;
        $var3 += 10;
        echo "Pasando por ambito4():";
        echo $var2." ".$var3. "<br>";
    }
    ambito4();//Salida ⇾ 4 11
    //static $var3 == 11 
    ambito4();//Salida ⇾ 14 21


    /*Caso 5*/
    $var1 = 1;
    function ambito5($p){
        $p++;    
        return $p;
    }

    echo "Pasando por ambito5():";
    echo ambito5($var1). "<br>";// El paso de la variable $var1 no hace referencia al mismo espacio de memoria y no habrá variación en su valor $var == 1.
    //Salida ⇾ Pasando por ambito5():2 (ya que la función devuelve $p y este se incrementa).


    /*Caso 6*/
    function ambito6(){
        global $var1;//la variable pasa a ser global    
        $GLOBALS['var2'] = $var1 + 10;//suma el valor de la variable a 10 y lo guarda en la última posición disponible
    }

    ambito6();
    echo "Pasando por ambito6(): $var2 <br>";    //Salida ⇾ 11

    
    /*Caso 7*/
    function ambito(&$p){
        $p++;//incrementa la variable recibida por paso de referencia modificando su valor apuntando a la misma posición de memoria
    }
   
    ambito($var1);
    echo "Pasando por ambito7(): $var1 <br>"; //Salida ⇾ 2

    /*Caso 8*/
    const VALOR = 100;

    function ambito8(){
        $var1 = VALOR * 2;
        define('OTRO_VALOR', -50);//define otra constante «'OTRO_VALOR'» y su valor es -50 
        //var_dump(OTRO_VALOR);
        return $var1;//devuelve la linea 93 (200)
    }
    echo "Pasando por ambito8(): ".(ambito8() + OTRO_VALOR);// Salida ⇾ (200 + -50) = 150

    ?>
</body>
</html>