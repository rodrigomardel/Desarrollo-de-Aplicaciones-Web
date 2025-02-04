<?php
class Conexion{
    /** Conexión a la base de datos */
    private $bd_conexion;
    /**Mensaje de error  */
    private $mensaje_error;

    public function __construct($nom_base_de_datos){
        // try {
            $this-> bd_conexion = new mysqli('localhost', 'root', 'root', $nom_base_de_datos);
        // } catch (\Throwable $th) {
        //     //throw $th;
        // }

        
    }

    public function relizar_consulta($consulta){
        $mensaje = "";
        $resultado_consulta = $this->bd_conexion->query($consulta);

        while ($fila = $resultado_consulta->fetch_array()) {
            $mensaje .= $fila[0]. ';';
        }

        return $mensaje;
    }
       
}
?>