<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

require_once('ConexionBD.php');

class Actores extends ConexionBD{


      /** LLamada a al constructor de la clase padre */
      function __construct(){
        parent::__construct();
      }


      /** Selección de las actrices */
      function obtenerActrices(){
        $query = "SELECT nombre_apellidos FROM actor WHERE sexo = 'f'";
        $resultadoQuery = $this->bd_conexion->query($query);

        $cadenaConsulta = "";
        while ($fila = $resultadoQuery->fetch_array()) {
          $cadenaConsulta .= $fila['nombre_apellidos']. ";";
        }
        return $cadenaConsulta;
      }


      /**Selección de actores de una determinada nacionalidad */
      function obtenerNacionalidades(){
        $query = "SELECT DISTINCT nacionalidad FROM actor";
        $resultadoQuery = $this->bd_conexion->query($query);

        //pusheo a un array y devolución con implode para evitar el último espacio en blanco
        $arrayConsulta = [];
        while ($fila = $resultadoQuery->fetch_array()) {
          array_push($arrayConsulta , $fila['nacionalidad']) ;
        }
        return implode(";", $arrayConsulta);
      }


      /**Contar número de actrices o actores que pertenecen a una misma nacionalidad */
      function contarActoresPorNacionalidad($nacionalidad){
        $query = "SELECT COUNT(id_actor) FROM actor WHERE nacionalidad='$nacionalidad'";
        $resultadoQuery = $this->bd_conexion->query($query);

        $cadenaConsulta = "";
        while ($fila = $resultadoQuery->fetch_array()) {
          $cadenaConsulta = $fila[0];
        }
        return $cadenaConsulta;
      }


      /**Obtener el id del actor seleccionado */
      function obtenerIdActor($nom_actor){
      $query = "SELECT id_actor FROM actor WHERE nombre_apellidos='$nom_actor'";
      $resultadoQuery = $this->bd_conexion->query($query);

      $cadenaConsulta = "";
      while ($fila = $resultadoQuery->fetch_array()) {
        $cadenaConsulta = $fila[0];
      }
      return $cadenaConsulta;
    }

}
?>