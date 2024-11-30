<?php

    class Estudiante extends Persona implements OperacionesEstudiante{

        const NOTA_MINIMA = 5;
        static int $numEstudiantes = 0;
        private $notas = [];

        public function __construct($nombre, $edad, $notas){
            parent::__construct($nombre, $edad);
            $this->notas = $notas;
        }

        public static function registrarEstudiante(){
            self::$numEstudiantes += 1;
            return self::$numEstudiantes;
        }

        public function mostrarInfo(){
            return "Estudiante: $this->nombre | Edad: $this->edad | Nº estudiante:". self::$numEstudiantes. "<br>";
        }

        public function calcularMedia(){
            $numeroNotas = count($this->notas); 
            $sumaNotas = 0;
            $media = 0;
        
            foreach ($this->notas as $nota) {
                 $sumaNotas += $nota;
            }

            $media = $sumaNotas/$numeroNotas;
            return "Nota media: $media <br>";
        }

        public function estaAprobado(){
            $resultado = "";
            if($this->calcularMedia() >= self::NOTA_MINIMA){
                $resultado = "$this->nombre está aprobado <br>";
            } else {
                $resultado = "$this->nombre está suspenso <br>";
            }
            return $resultado;
        }

        public static function getNumEstudiantes() {
            return self::$numEstudiantes;
        }



    }


?>