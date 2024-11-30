<?php
// MUY RECOMENDABLE llamar igual al archivo que a la clase, así como en los namespaces
class Alumno{
    const CICLO = "DAW";
    private $nombre;
    private $edad;

    //Constructor mágico no es compatible
    /*function __construct ($nombre, $edad){
        $this->nombre = $nombre;
        $this->edad = $edad;
    }*/

    //Constructores programados no se puede llamar igual (no hay poliformismo).
    function AlumnoNombreEdad ($nombre, $edad){
        $this->nombre = $nombre;
        $this->edad = $edad;
    }

    function AlumnoNombre ($nombre){
        $this->nombre = $nombre;
    }

    function __get ($atributo){
        return $this->$atributo;
    }

    function __set($atributo, $valor){
        $this->$atributo = $valor;
    }

}






?>