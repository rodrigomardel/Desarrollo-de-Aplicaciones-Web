
    <?php
    /*
    A partir del array indexado o numérico del ejercicio 1 del listado de actividades anterior crea una función para cada apartado:
e)
Crear dos nuevos arrays: uno cuyas componentes almacenen como valor el doble de los componentes del array original de este ejercicio y otro cuyas componentes almacenen la mitad del valor de las componentes originales. Utiliza array_map() y funciones variable.
f)
Ordena sus componentes utilizando la función sort() y rsort(); a continuación, inserta un nuevo valor sin perder el orden en el vector.
g)
Busca un valor concreto, utilizando las funciones in_array() o array_search(), con y sin coincidencia de tipos.
h)
Incrementa en dos más sus componentes y calcula de nuevo la media de ellas.
i)
Elimina la última componente con unset() o con array_pop()
Para ello, crea una librería con las funciones diseñadas e incluye la librería en el script principal. Las sentencias de visualización no se incluirán en los códigos de las funciones diseñadas sino en el script principal.
*/

   

    /*Muestra el número de componentes negativas.*/
    function numerosNegativos (Array &$array, ?int $number): string{//?int podria devolver un nulo(informativo)
        $resultado = "";

        for($i = 0; $i < count($array); $i++){
            if($array[$i] < 0){
                $resultado .= strval($array[$i]);
                $number++;
            }
        }
        return $resultado = "Hay $number numeros negativos y son → $resultado"; 
    }

    /*Muestra la media de las componentes.*/
    function media (Array $array): string{
        $numComponentes = 0;
        $resultado = "";
        $suma = 0;

        for($i = 0; $i < count($array); $i++){
                $suma += $array[$i];
                $numComponentes++;
        }
        return $resultado = "La media es → ". $suma / $numComponentes ; 
        // var_dump($resultado);
    }
   

    /*Visualiza las posiciones del array en las que se almacene como valor el cuadrado de su posición. 
    Si no se da esta circunstancia en ninguna componente, indícalo con un sencillo mensaje.*/
    function cuadradoPoscicion(Array $array): string{
        $resultado = "";
        $contador = 0;

        foreach ($array as $posicion => $valor) {
            if($posicion * 2 == $valor){
                $resultado .= "El valor $valor corresponde con el cuadrado de la posición → $posicion <br>";
            }else if($posicion * 2 != $valor){
                $contador++;
            }            
        }

        if ($contador == count($array)){
            $resultado = "No hay ningún valor que corresponda con el cuadrado de su posición <br>";
        }

        return $resultado;
    }

    /*Visualizar el array en orden invertido.*/
    function ordenInvertido(Array $array): string{
        

    }

    

    ?>   
