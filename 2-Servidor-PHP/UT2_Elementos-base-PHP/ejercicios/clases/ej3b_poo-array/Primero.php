<?php
namespace ej3b\Primero;
use ej3b\Alumno as alum;

class Primero extends alum\Alumno{

    private $notaMedia = array();

    public function __construct ($nombre, $edad, $notaMedia){
        parent::__construct($nombre, $edad);
        $this->notaMedia = $notaMedia;
    }


    public function calculoMediaA(){
        $media = 0;

        foreach ($this->notaMedia as $valor) {
            $media += $valor;
        }
        $media = $media/count($this->notaMedia);

        return $media;
    }


//  Usando iteradores
    public function calculoMediaB(){
        $media = 0;
        $iterador = new ArrayIterator($this->notaMedia);

        for ($i=0 ; $i < $iterador->count()  ; $i++ ) { 
            $media += $iterador->current();
            $iterador->next();
        }

        $media = $media/count($this->notaMedia);

        return $media;
    }

    public function superaCursoPrimero($media): string{
        if($media >= 5){
            $resultadoCurso = "curso <strong>aprobado</strong>";
            $resultado = "El/la alumno/a $this->nombre tiene el $resultadoCurso.". " Nota media → ". $this->calculoMediaA() ."<br>";
        } else{
            $resultadoCurso = "curso <strong>suspenso</strong>";
            $resultado = "El/la alumno/a $this->nombre tiene el $resultadoCurso.". " Nota media → ". $this->calculoMediaA() ."<br>";
        }
        return $resultado;  
    }

}

?>