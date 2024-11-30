<?php
namespace ej3c\Alumno;

    abstract class Alumno{

        static string $ciclo = "DAW";
        protected string $nombre;
        protected int $edad;

        public function __construct ($nombre, $edad){
            $this->nombre = $nombre;
            $this->edad = $edad;
        }

        abstract function superaCurso(&$resultadoCurso): string;
    }

?>