<?php
namespace ej3b\Alumno;

class Alumno{

static string $ciclo = "DAW";
protected string $nombre;
protected int $edad;

public function __construct ($nombre, $edad){
    $this->nombre = $nombre;
    $this->edad = $edad;
}

public function visualizar(): string{
    return "El alumno $this->nombre, tiene $this->edad años.";
}

}

?>