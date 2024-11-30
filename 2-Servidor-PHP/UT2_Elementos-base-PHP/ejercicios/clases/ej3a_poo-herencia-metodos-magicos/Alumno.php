<?php
namespace ej3\Alumno;

    class Alumno{

        static string $ciclo = "DAW";
        protected string $nombre;
        protected int $edad;

        public function __construct ($nombre, $edad){
            $this->nombre = $nombre;
            $this->edad = $edad;
        }

        function __get($atrib){
            return $this->$atrib;
        }

        function __set($atrib, $value){
            $this->$atrib = $value;
        }

        function __toString(){
            return "El alumno $this->nombre, tiene $this->edad años.";
        }

        // public function visualizar(): string{
        //     return "El alumno $this->nombre, tiene $this->edad años.";
        // }
    }

?>