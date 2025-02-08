<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

require_once('ConexionBD.php');

class Intervenir extends ConexionBD{

      /** LLamada a al constructor de la clase padre */
      function __construct(){
        parent::__construct();
      }

      /** Peliculas en las que intervino un determinado actor */
      function peliculasIntervinoActor($id_actor){
        $query = "SELECT titulo FROM intervenir_actores_peliculas WHERE id_actor = '$id_actor'";
        $resultadoQuery = $this->bd_conexion->query($query);

        $cadenaConsulta = "";
        while ($fila = $resultadoQuery->fetch_array()) {
            $cadenaConsulta .= $fila['titulo']. ";";
        }
        return $cadenaConsulta;
      }
}
?>