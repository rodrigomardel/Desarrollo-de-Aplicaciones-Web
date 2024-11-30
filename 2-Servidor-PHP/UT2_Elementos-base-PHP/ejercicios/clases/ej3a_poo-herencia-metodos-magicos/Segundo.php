<?php
namespace ej3\Segundo;
use ej3\Alumno as alum;

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

public function superaCursoSegundo($resultadoPrimero): string{
    $resultado;
    if($resultadoPrimero == "curso <strong>aprobado</strong>" && 
    $this->notaMedia >= 5 && 
    $this->calificacionFCT == "aprobado" &&
    $this->notaPoyecto >= 5){
        $resultado = "La/el alumna/o $this->nombre ha superado el curso. Nota media → $this->notaMedia <br>";
    } else{
        $resultado = "La/el alumna/o $this->nombre <strong>NO</strong> ha superado el curso. Nota media → $this->notaMedia <br>";
    }
    return $resultado; 
}

}

?>