<?php
/**Control principal */
error_reporting(E_ALL);
ini_set('display_errors', 1);

try{
    require_once("../model/OperacionesBD.php");
    $operacionesBD = new OperacionesBD();

    /**Subsanaciones y datos de opositores */
    if(isset($_POST['continuar'])){
            
            switch ($_POST['consultas']) {
                case 'subsanaciones':
                    $nomFichero = "../subsanaciones.txt";
                    $fichero = fopen($nomFichero, "r");//Abrir fichero en modo lectura

                    $mensajeInfo = "";
                    //Obtener las líneas del fichero
                    while ($lineaFichero = fgets($fichero)) {
                        $arrayDatos = explode(";", $lineaFichero);//Obtener array del string
                        $mensajeInfo .= $operacionesBD->subsanaciones($arrayDatos[0], trim($arrayDatos[1])) ."<br>";//Realizar update
                    }
                    //Envio de los mensajes informativos del resultado de la operación
                    require_once("../view/vista_subsanaciones.php");
                    break;

                case 'plaza':
                    $opositoresConPlaza = $operacionesBD->opositoresConPlaza();
                    require_once('../view/vista_consultas.php');
                    viewRespuestaPlaza($opositoresConPlaza);
                    $operacionesBD->cerrarConexion();
                    break;
                    
                case 'bolsa':
                    $opositoresBolsa = $operacionesBD->opositoresBolsaTrabajo();
                    require_once('../view/vista_consultas.php');
                    viewRespuestaBolsa($opositoresBolsa);
                    $operacionesBD->cerrarConexion();
                    break;
                    
                case 'noApto':
                    $opositoresNoAptos = $operacionesBD->opositoresNoAptos();
                    require_once('../view/vista_consultas.php');
                    viewRespuestaNoApto($opositoresNoAptos);
                    $operacionesBD->cerrarConexion();
            } 
    }

    /**Insertado de nuevos opositores */
    if (isset($_POST['insertar'])) {
        require_once('../view/vista_insertar.html');
    }

    /**Eliminación de opositores */
    if (isset($_POST['borrar'])) {
        require_once('../view/vista_borrar.html');
    }

} catch (Exception $e) {
    echo "Error: " . $e->getMessage();
}
?>