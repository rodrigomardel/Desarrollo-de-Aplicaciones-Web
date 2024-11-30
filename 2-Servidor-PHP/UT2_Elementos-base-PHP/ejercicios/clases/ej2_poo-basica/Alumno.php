<?php
namespace ej2\Alumno;

class Alumno{

static $ciclo = "DAW";
protected $nombre;
protected $edad;

public function __construct ($nombre, $edad){
    $this->nombre = $nombre;
    $this->edad = $edad;
}

public function visualizar(){
    return "El alumno $this->nombre, tiene $this->edad años.";
}

}

?>