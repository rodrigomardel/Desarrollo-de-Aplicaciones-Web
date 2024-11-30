<?php
namespace ej4\Joven;
use ej4\Persona as per;

    class Joven extends per\Persona{

        private int $id = 0;
        private int $edad = 0;

        public function __construct($id, $edad){
            $this->id = $id;
            $this->edad = $edad;
        }

        public function ayudas(){
            if($this->edad == 18){
                $mensaje = "Le correponde una ayuda de 400€ <br>";
            } else {
                $mensaje = "No le corresponde ninguna ayuda <br>";
            }
            return $mensaje;
        }

        public function mensaje(){
            return "Estás en la mejor edad. ¡Disfruta! <br>";
        }

        public function visualizar(){
            return "ID alumno: $this->id | Edad: $this->edad <br>";
        }

    }





?>