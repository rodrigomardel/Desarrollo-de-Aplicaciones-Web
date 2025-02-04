<?php

try{

    $conexion = new PDO ('mysql:host=127.0.0.1; port=3306; dbname=ciclos', 'root', 'root');
    
    // echo "conexión realizada". $_POST['id_al']. "" . $_POST['edad'];
    
    // seteo errores y excepciones
    $conexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // $consulta = "UPDATE alumno SET edad = ? WHERE id_al = ?";
    // version con marcadores (array asociativo)
    $consulta = "UPDATE alumno SET edad = :marcador1 WHERE id_al = :marcador2";

    $resultado = $conexion->prepare($consulta);

    $id_al = htmlspecialchars($_POST['id_al']);
    $edad = htmlspecialchars($_POST['edad']);

    // $resultadoCorrecto = $resultado->execute([$edad, $id_al]); // array de parámetros de la consulta preparada
    // version con marcadores (array asociativo)
    $resultadoCorrecto = $resultado->execute(['marcador1'=>$edad,'marcador2'=>$id_al]); // array de parámetros de la consulta preparada

    //
    if($resultado->rowCount()){
        echo "Actualización realizada";
    } else {
        throw new Exception("Error. No es posible la modificación");
        
    }

} catch (PDOException $e){
    // Texto de ejemplo
    echo "Lo sentimos... en breve estará disponible la aplicación.";
   error_log($e->getMessage());
}

?>