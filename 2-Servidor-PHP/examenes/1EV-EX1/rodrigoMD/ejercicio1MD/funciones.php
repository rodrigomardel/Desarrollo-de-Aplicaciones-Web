<?php

    require_once("./datos.inc");

    //1.a
    function totalPlazasOnline($centrosFP, &$resultado){
        foreach ($centrosFP as $centros) {
                $resultado += $centros[1];      
        }
    }

 

    //1.b
    function nombreCentrosOnline($centrosFP){
        $centrosOnline = [];

        foreach ($centrosFP as $centros => $modalidad) {
             if($modalidad[1] == 0){
                $centrosOnline = $centros;
             }
        }
        return $centrosOnline;
    }
    

    //1.c
    function numPlazasOnline ($centrosFP, $nombre){
        foreach ($centrosFP as $nombreCentro => $modalidad) {
            if($nombre != $nombreCentro){
                return "El centro no existe";
            } else if ($nombre == $nombreCentro && $modalidad[1]<=0){
                return "El centro $nombreCentro no tiene plazas online";
            } else if ($nombre == $nombreCentro && $modalidad[1]>0){
                return "El centro $nombreCentro tiene plazas online";
            }
        }
    }


?>