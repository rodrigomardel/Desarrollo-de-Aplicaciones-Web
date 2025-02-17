<?php
try{

    require_once("../model/OperacionesBD.php");
    $operacionesBD = new OperacionesBD();

        if (isset($_POST['aceptar'])) {
            $idMascota = htmlspecialchars($_POST['idMascota']);
            $nombreMascota = htmlspecialchars($_POST['nombreMascota']);
            $especie = htmlspecialchars($_POST['especie']);
            $sexo = htmlspecialchars($_POST['sexo']);
            $idCentro = htmlspecialchars($_POST['idCentro']);

        
                $mensajeResulInsert = $operacionesBD->insertarMascota($idMascota, $nombreMascota, $especie, $sexo, $idCentro);
                echo $mensajeResulInsert;
                $operacionesBD->cerrarConexion();
            }
    
} catch (Exception $e){
    echo "Error: " . $e->getMessage();
}
?>