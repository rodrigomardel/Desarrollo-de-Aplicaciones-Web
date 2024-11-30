<?php
/*Determina si a partir de una fecha para realizar una solicitud, se ha terminado el plazo.*/
date_default_timezone_set("Europe/Madrid");
setlocale(LC_ALL,"");

// $fechaSolicitud = time();

// function comprobarPlazo($fecha){
//     $fechaLimite = date("2024-10-14");
//     $segundosFechaLimite = strtotime($fechaLimite);

//     if($fecha > $segundosFechaLimite){
//         echo "El plazo «".$fechaLimite."» ha finalizado"; 
//     } else{
//         echo "¡Solicitud resgistrada!";
//     }
// }

// comprobarPlazo($fechaSolicitud);

//Alternativa
$fechaSolicitud = "20-10-2024";
$segundosFechaSolicitud = strtotime($fechaSolicitud);

function comprobarPlazo($fecha){
 if($fecha - time() < 0){//menos los segundos de la fecha actual
        echo "Solicitud fuera de plazo"; 
    } else{
       $diferencia = $fecha - time();
       $dias = (int)($diferencia/86400)+1;//un dia tiene 86400 seg. Se suma uno porque el dia actual (linea 10) no lo tiene en cuenta.
       echo "Solicitud en plazo. Aún le quedan $dias.";
    }
}

comprobarPlazo($segundosFechaSolicitud);

?>