<?php
/*Control de los datos del nuevo opositor */
error_reporting(E_ALL);
ini_set('display_errors', 1);

  try{
    
    require_once("../model/OperacionesBD.php");
    $operacionesBD = new OperacionesBD();

    if (isset($_POST['borrar'])) {
        $codigoOpositor = $_POST['codOpo'];

        // Pequeño tratamiento para evitar valores vacíos
        if(empty($codigoOpositor)){
          echo "** Valor vacío ** <br><a href='../view/vista_borrar.html'>Volver</a>";
        } else {
          // Borrado
          $mensajeResulBorrado = $operacionesBD->eliminarOposotior($codigoOpositor);
          echo $mensajeResulBorrado. "<br><a href='../index.php'>Volver</a>";
          $operacionesBD->cerrarConexion();
        }
      
    }

  } catch (Exception $e) {
    echo "Error: " . $e->getMessage();
  }

?>