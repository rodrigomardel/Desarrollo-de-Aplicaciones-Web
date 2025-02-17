<?php
/*Control de los datos del nuevo opositor */
error_reporting(E_ALL);
ini_set('display_errors', 1);

try{

require_once("../model/OperacionesBD.php");
$operacionesBD = new OperacionesBD();

    if (isset($_POST['insertar'])) {
        // Asignación de cada input
        $codigoOpositor = htmlspecialchars($_POST['codOpo']);
        $notaTeorico = htmlspecialchars($_POST['notaT']);
        $notaPractico = htmlspecialchars($_POST['notaP']);

        // Pequeño tratamiento para evitar valores vacíos
        if (empty($codigoOpositor) || empty($notaTeorico) || empty($notaPractico)){
            echo "<p> ** Se deben completar los tres campos ** </p><a href='../view/vista_insertar.html'>Volver</a>";
        } else {
            // Insertado
            $mensajeResulInsert = $operacionesBD->insertarOpositor($codigoOpositor, $notaTeorico, $notaPractico);
            echo $mensajeResulInsert. "<br><a href='../index.php'>Volver</a>";
            $operacionesBD->cerrarConexion();
        }
    }
} catch (Exception $e){
    echo "Error: " . $e->getMessage();
}
?>