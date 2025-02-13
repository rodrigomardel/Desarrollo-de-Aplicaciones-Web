<?php
try{

    require_once("../model/OperacionesBD.php");
    $operacionesBD = new OperacionesBD();

        if (isset($_POST['aceptar'])) {
            $idMascota = htmlspecialchars($_POST['idMascota']);
        
                $mensajeResulActualizacion = $operacionesBD->actualizarEstado($idMascota);
                echo $mensajeResulActualizacion;
                $operacionesBD->cerrarConexion();
            }
    
} catch (Exception $e){
    echo "Error: " . $e->getMessage();
}
?>