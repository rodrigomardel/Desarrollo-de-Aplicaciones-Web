<?php

class DatosAlumno{

    public static function visualizar(string $ciclo, string $curso, array $opciones){
        echo "<p>Alumno matriculado en → {$ciclo}<br/> Cursando → {$curso}<br/> Opciones: <br/>";
        foreach ($opciones as $valor) {
            echo "- {$valor} <br/>";
        }
    }

}

?>