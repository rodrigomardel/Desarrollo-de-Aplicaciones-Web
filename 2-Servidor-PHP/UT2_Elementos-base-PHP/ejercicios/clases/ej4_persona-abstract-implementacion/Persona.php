<?php
namespace ej4\Persona;

    abstract class Persona{

        const CONSTANTE = "Todos";
        static int $valor = 0;

        abstract function ayudas();
        abstract function mensaje();

        public static function modificarStatic(){
            self::$valor += 1;
            return self::$valor;
            
        }
        public static function otros(){
            return self::CONSTANTE. " sois buena gente. <br>";
        }

        public static function getNumEstudiantes() {
            return "Nº de estudiantes:". self::$valor. "<br>";
        }


    }





?>
