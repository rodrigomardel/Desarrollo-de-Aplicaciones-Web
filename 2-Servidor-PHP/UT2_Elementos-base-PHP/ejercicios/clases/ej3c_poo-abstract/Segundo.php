<?php
namespace ej3c\Segundo;
use ej3c\Alumno as alum;
    //Al extender a la clase abstracta debe implementar sus métodos abstractos.
    class Segundo extends alum\Alumno{

        private int $notaMedia;
        private string $calificacionFCT;
        private int $notaPoyecto;

        public function __construct ($nombre, $edad, $notaMedia, $calificacionFCT, $notaPoyecto){
            parent::__construct($nombre, $edad);
            $this->notaMedia = $notaMedia;
            $this->calificacionFCT = $calificacionFCT;
            $this->notaPoyecto = $notaPoyecto;

        }

        public function superaCurso(&$resultadoPrimero): string{
            if($resultadoPrimero == "curso <strong>aprobado</strong>" && 
            $this->notaMedia >= 5 && 
            $this->calificacionFCT == "aprobado" &&
            $this->notaPoyecto >= 5){
                $resultado = "La/el alumna/o $this->nombre tiene el curso <strong>aprobado</strong>. Nota media → $this->notaMedia <br>";
            } else{
                $resultado = "La/el alumna/o $this->nombre tiene el curso <strong>suspenso</strong>. Nota media → $this->notaMedia <br>";
            }
            return $resultado; 
        }

    }

?>