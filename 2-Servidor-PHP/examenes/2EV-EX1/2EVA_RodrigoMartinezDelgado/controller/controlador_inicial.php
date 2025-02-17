<?php
try{
    require_once("../model/OperacionesBD.php");
    $operacionesBD = new OperacionesBD();

    if(isset($_POST['continuar'])){
            
            switch ($_POST['consultas']) {
                case 'localidad':
                    $localidadCentros = $operacionesBD->obtenerLocalidadCentros();
                    require_once('../view/vista_consultas.php');
                    mostrarLocalidades($localidadCentros);
                    $operacionesBD->cerrarConexion();
                    break;

                case 'especies':
                    $nombreYespecie = $operacionesBD->nombreYespeciesRegistradas();
                    require_once('../view/vista_consultas.php');
                    mostrarNombreYespecies($nombreYespecie);
                    $operacionesBD->cerrarConexion();
                    break;
                    
                case 'numeroPerros':
                    $numeroPerros = $operacionesBD->numeroDePerros();
                    require_once('../view/vista_consultas.php');
                    mostrarNumeroPerros($numeroPerros);
                    $operacionesBD->cerrarConexion();
                    break;

                case 'numeroGatos':
                    $numeroGatos = $operacionesBD->numeroDeGatos();
                    require_once('../view/vista_consultas.php');
                    mostrarNumeroGatos($numeroGatos);
                    $operacionesBD->cerrarConexion();
                    break;
            } 
    }

    if (isset($_POST['insertar'])) {
        require_once('../view/vista_insertar.html');
    }

    if (isset($_POST['actualizar'])) {
        require_once('../view/vista_actualizar.html');
    }

    if (isset($_POST['salir'])) {
        echo "<h1>¡Hasta pronto!</h1>";
        exit();
    }

} catch (Exception $e) {
    echo "Error: " . $e->getMessage();
}
?>