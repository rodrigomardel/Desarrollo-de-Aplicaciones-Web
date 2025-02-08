<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

require_once('ConexionBD.php');

/** Proporciona información de las peliculas en la BBDD cinema*/
class Peliculas extends ConexionBD{

    /** LLamada a al constructor de la clase padre */
    function __construct(){
        parent::__construct();
    }


    /**Selección de las películas dramáticas */
    function obtenerPeliculasDrama(){
        $query = "SELECT titulo FROM pelicula WHERE genero = 'drama'";
        //acceso a la conexión del atributo heredado
        $resultadoQuery = $this->bd_conexion->query($query);
        $cadenaConsulta = "";
        /*fecth_array() devuelve una matriz indexada y asociativa de la misma fila*/
        while($fila =  $resultadoQuery->fetch_array()){
            // $mensaje .= $fila[0] . ";"; -> indexado
            $cadenaConsulta .= $fila['titulo'] . ";";
        }
        return $cadenaConsulta;
    }

}
?>