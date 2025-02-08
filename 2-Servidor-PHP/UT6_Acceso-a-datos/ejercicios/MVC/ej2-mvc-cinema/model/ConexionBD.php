<?php
class ConexionBD{
    /** Conexión a la base de datos */
    public $bd_conexion;

    /** Conexión a la base de datos deseada */
     public function __construct(){
            $this->bd_conexion = new mysqli('localhost', 'root', 'root', 'cinema');
    }
}
?>