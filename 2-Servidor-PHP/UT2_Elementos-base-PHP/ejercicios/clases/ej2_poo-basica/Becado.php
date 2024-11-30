<?php
namespace ej2\Becado;
use ej2\Alumno as alum;


class Becado extends alum\Alumno{

private $importeBeca;

public function __construct ($nombre, $edad, $importeBeca){
    parent::__construct($nombre, $edad);
    $this->importeBeca = $importeBeca;
}

public function visualizar(){

    $salida = parent::Visualizar();
    return "$salida y tiene una beca de  $this->importeBeca";
}


}

?>