<?php
class Alumno{
    const TASA_MATRICULA = 2;
    static int $numeroMatricula = 0;
    static Array $coleccionAlumnos = [];
    private string $matricula;
    private string $nombre;
    private int $edad;

    function __construct (string $nombre, int $edad){
        $this->nombre = $nombre;
        $this->edad = $edad;
        $this->matricula = "M-". self::incremento();
    }

    public function agregarAlumno(){
        foreach ($this as $key => $value) {
            echo "$key  $value <br>";
        }
        self::$coleccionAlumnos[] = $this;
    } 

    public function calcularImporteMatricula(){
        $importe;

        if($this->edad < 18){
            $importe = 0;
        } else {
            $importe = self::TASA_MATRICULA;
        }
        return "El importe de la matricula de $this->nombre es $importe <br>";
    }

    public static function incremento(){
        return (++self::$numeroMatricula);
    }

    function __get ($atributo){
        return $this->$atributo;
    }

    function __set($atributo, $valor){
        $this->$atributo = $valor;
    }

}