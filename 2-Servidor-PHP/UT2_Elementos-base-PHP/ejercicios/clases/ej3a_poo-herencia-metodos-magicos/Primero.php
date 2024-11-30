<?php
namespace ej3\Primero;
use ej3\Alumno as alum;

class Primero extends alum\Alumno{

private int $notaMedia;

public function __construct ($nombre, $edad, $notaMedia){
    parent::__construct($nombre, $edad);
    $this->notaMedia = $notaMedia;
}

public function superaCursoPrimero(&$resultadoCurso): string{
    $resultadoCurso;
    if($this->notaMedia >= 5){
        $resultadoCurso = "curso <strong>aprobado</strong>";
        $resultado = "El/la alumno/a $this->nombre tiene el $resultadoCurso. Nota media → $this->notaMedia <br>";
    } else{
        $resultadoCurso = "curso <strong>suspenso</strong>";
        $resultado = "El/la alumno/a $this->nombre tiene el $resultadoCurso. Nota media → $this->notaMedia <br>";
    }
    return $resultado;  
}

}

?>