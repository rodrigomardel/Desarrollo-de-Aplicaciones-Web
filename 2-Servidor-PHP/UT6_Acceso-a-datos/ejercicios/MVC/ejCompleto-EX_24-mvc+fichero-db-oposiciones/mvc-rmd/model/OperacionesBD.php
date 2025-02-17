<?php
class OperacionesBD{
    /** Conexión a la base de datos */
    private $conexionBD;

    /** Conexión a la base de datos deseada */
    public function __construct(){
        try {
            $this->conexionBD = new PDO("mysql:host=localhost; port=3306; dbname=oposiciones", "root", "root");
            //Modo de informe de errores de PHP Data Objects.
            $this->conexionBD->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);    
        } catch (PDOException $e) {
            throw new Exception("Error en la conexión a la base de datos: " . $e->getMessage()) ;
        }
    }

    /** Subsanar notas teóricas */
    function subsanaciones($codOp, $notaTeorico){
        try {
            $query = "UPDATE resultados SET notat = :notaTeorico WHERE cod_op = :codOp";
            $resultadoConsulta = $this->conexionBD->prepare($query);
            $resultadoConsulta->bindParam(':notaTeorico', $notaTeorico, PDO::PARAM_INT);
            $resultadoConsulta->bindParam(':codOp', $codOp, PDO::PARAM_STR);
            $resultadoConsulta->execute();

            $mensajeInfo = "";
            if ($resultadoConsulta->rowCount()>0) {
                $mensajeInfo = "✔ Operación realizada"; 
            } else {
                $mensajeInfo = "❌ Operación NO realizada";
            }
            return $mensajeInfo;

        } catch (PDOException $e) {
            throw new Exception("Error en la consulta: " . $e->getMessage()) ;
        }
    }

    /** Opositores que han superado las dos pruebas */
    function opositoresConPlaza(){
        try {
            $query = "SELECT * FROM resultados WHERE notap >= 5 AND notat >= 5";
            $resultadoConsulta = $this->conexionBD->query($query);
            return $resultadoConsulta;

        } catch (PDOException $e) {
            throw new Exception("Error en la consulta: " . $e->getMessage()) ;
        }
    }

    /** Opositores que han superado una de las dos pruebas */
    function opositoresBolsaTrabajo(){
        try {
            $query = "SELECT * FROM resultados WHERE notap >= 5 XOR notat >= 5";
            $resultadoConsulta = $this->conexionBD->query($query);
            return $resultadoConsulta;

        } catch (PDOException $e) {
            throw new Exception("Error en la consulta: " . $e->getMessage()) ;
        }
    }
    
    /** Opositores que no han superado ninguna prueba */
    function opositoresNoAptos(){
        try {
            $query = "SELECT * FROM resultados WHERE notap < 5 AND notat < 5";
            $resultadoConsulta = $this->conexionBD->query($query);
            return $resultadoConsulta;

        } catch (PDOException $e) {
            throw new Exception("Error en la consulta: " . $e->getMessage()) ;
        }
    }
    
    /** Insertar nuevo opositor */
    function insertarOpositor($codigoOpositor, $notaTeorico, $notaPractico){
        try {
            $query = "INSERT into resultados (cod_op, notap, notat) values (:codigoOpositor, :notaTeorico, :notaPractico)";
            $resultadoConsulta = $this->conexionBD->prepare($query);
            $resultadoConsulta->bindParam(':codigoOpositor', $codigoOpositor, PDO::PARAM_STR);
            $resultadoConsulta->bindParam(':notaTeorico', $notaTeorico, PDO::PARAM_INT);
            $resultadoConsulta->bindParam(':notaPractico', $notaPractico, PDO::PARAM_INT);
            $resultadoConsulta->execute();

            $mensajeInfo = "";
            if($resultadoConsulta->rowCount() > 0){
                $mensajeInfo = "✔ Insertado realizado";
            } else{
                $mensajeInfo = "❌ Operación NO realizada";;
            }
            return $mensajeInfo;

        } catch (PDOException $e) {
            throw new Exception("Error en la consulta: " . $e->getMessage()) ;
        }
    }

    /** Eliminación de un determinado actor */
    function eliminarOposotior($codigoOpositor){
        try {
            $query = "DELETE FROM resultados WHERE cod_op = :codigoOpositor";
            $resultadoConsulta = $this->conexionBD->prepare($query);
            $resultadoConsulta->bindParam(':codigoOpositor', $codigoOpositor, PDO::PARAM_STR);
            $resultadoConsulta->execute();

            $mensajeInfo = "";
            if($resultadoConsulta->rowCount() > 0){
                $mensajeInfo = "✔ Borrado realizado";
            } else{
                $mensajeInfo = "❌ Operación NO realizada";;
            }
            return $mensajeInfo;

        } catch (PDOException $e) {
            throw new Exception("Error en la consulta: " . $e->getMessage()) ;
        }
    }

    /** Cierra la conexión a la base de datos */
    public function cerrarConexion() {
        $this->conexionBD = null;
    }
}
?>