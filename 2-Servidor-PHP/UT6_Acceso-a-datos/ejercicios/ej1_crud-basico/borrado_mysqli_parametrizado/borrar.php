<?php
$db_host = 'localhost';
$db_usuario = 'root';
$db_clave = 'root';
$db_nombre = 'ciclos';

try{

$conexion = new mysqli($db_host, $db_usuario, $db_clave, $db_nombre);

// Comprobación de la conexión con el servidor MYSQL
if(!$conexion->connect_errno){
    // Comprobar conexión con la tabla
    if ($conexion->select_db('ciclos')) {

        // Datos formulario
        if(isset($_POST['enviar'])){
            $id_al = htmlspecialchars($_POST['id_al']);
    
            // Borrado de datos mediante consulta parametrizada para mayor eficiencia y seguridad
            $consulta = "DELETE FROM alumno WHERE id_al = ?";
    
            $preparada = $conexion->prepare($consulta);
            $preparada->bind_param("i", $id_al); //'i' hace referencia al tipo de dato en este caso entero ('s'-> string , 'd' -> float)

            // Control si se ejecuta la consulta
            if ($preparada->execute()) {

                // Control si hay filas afectadas
                if ($preparada->affected_rows) {
                    echo "Borrado realizado";
                } else {
                    // echo "No ha sido posible borrar $id_al no existe en la BBDD";
                    // Equivalente a la línea de arriba lanzando una excepción
                    throw new mysqli_sql_exception  ("No ha sido posible borrar el alumno con id $id_al, no existe en la BBDD");
                }

            } else {
                echo "Sentencia incorrecta";

            }
            
        }
    } else {
        echo "No se ha podido conectar con la BBDD";
        
    }
} else {
    echo "Fallo en la conexión";
}


} catch(mysqli_sql_exception $e) { // Clase de excepciones asociadas a mysqli
    
    echo "** ERROR ". $e->getMessage()." **";
}
$conexion->close();


?>