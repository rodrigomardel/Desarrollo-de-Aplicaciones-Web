<?php
class OperacionesBD{
    private $conexionBD;

    public function __construct(){
        try {
            $this->conexionBD = new PDO("mysql:host=localhost; port=3306; dbname=acogida", "root", "root");
            $this->conexionBD->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);    
        } catch (PDOException $e) {
            throw new Exception("Error en la conexión a la base de datos: " . $e->getMessage()) ;
        }
    }


    function obtenerLocalidadCentros(){
        try {
            $query = "SELECT DISTINCT localidad FROM centros";
            $resultadoConsulta = $this->conexionBD->query($query);
            return $resultadoConsulta;

        } catch (PDOException $e) {
            throw new Exception("Error en la consulta: " . $e->getMessage()) ;
        }
    }

    function nombreYespeciesRegistradas(){
        try {
            $query = "SELECT nombre, especie FROM mascotas";
            $resultadoConsulta = $this->conexionBD->query($query);
            return $resultadoConsulta;

        } catch (PDOException $e) {
            throw new Exception("Error en la consulta: " . $e->getMessage()) ;
        }
    }
    
    function numeroDePerros(){
        try {
            $query = "SELECT COUNT(*) FROM mascotas WHERE especie='p'";
            $resultadoConsulta = $this->conexionBD->query($query);
            return $resultadoConsulta;

        } catch (PDOException $e) {
            throw new Exception("Error en la consulta: " . $e->getMessage()) ;
        }
    }

    function numeroDeGatos(){
        try {
            $query = "SELECT COUNT(*) FROM mascotas WHERE especie='g'";
            $resultadoConsulta = $this->conexionBD->query($query);
            return $resultadoConsulta;

        } catch (PDOException $e) {
            throw new Exception("Error en la consulta: " . $e->getMessage()) ;
        }
    }
    
    function insertarMascota($idMascota, $nombreMascota, $especie, $sexo, $idCentro){
        try {
            $query = "INSERT into mascotas (id_mascota, nombre, especie, sexo, estado, id_centro) values (:idMascota, :nombreMascota, :especie, :sexo, 'A', :idCentro)";
            $resultadoConsulta = $this->conexionBD->prepare($query);
            $resultadoConsulta->bindParam(':idMascota', $idMascota, PDO::PARAM_INT);
            $resultadoConsulta->bindParam(':nombreMascota', $nombreMascota, PDO::PARAM_STR);
            $resultadoConsulta->bindParam(':especie', $especie, PDO::PARAM_STR);
            $resultadoConsulta->bindParam(':sexo', $sexo, PDO::PARAM_STR);
            $resultadoConsulta->bindParam(':idCentro', $idCentro, PDO::PARAM_STR);
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

    function actualizarEstado($idMascota){
        try {
            $query = "UPDATE mascotas SET estado = 'B' WHERE id_mascota = :idMascota";
            $resultadoConsulta = $this->conexionBD->prepare($query);
            $resultadoConsulta->bindParam(':idMascota', $idMascota, PDO::PARAM_INT);
            $resultadoConsulta->execute();

            $mensajeInfo = "";
            if($resultadoConsulta->rowCount() > 0){
                $mensajeInfo = "✔ Mascota acogida";
            } else{
                $mensajeInfo = "❌ Está mascota ya está en acogida";;
            }
            return $mensajeInfo;

        } catch (PDOException $e) {
            throw new Exception("Error en la consulta: " . $e->getMessage()) ;
        }
    }

    public function cerrarConexion() {
        $this->conexionBD = null;
    }
}
?>