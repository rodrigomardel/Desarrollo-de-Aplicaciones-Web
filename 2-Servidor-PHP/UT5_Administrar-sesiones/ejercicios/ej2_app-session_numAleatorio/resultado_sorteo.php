<?php
/*
Página 3: Visualizar la información como se muestra en el ejemplo. Si el nombre es Antonio, habrá premio si no, habrá que intentarlo de nuevo.
*/
session_start();
$usuario_ganador = "Antonio";

echo "El número aleatorio fue el...". $_SESSION['numero_premiado']."<br>";
echo "El usuario fue...". $_SESSION['usuario_premiado']."<br>";
echo "Los usuarios válidos son: ".implode(", ",$_SESSION['usuarios'])."<br>";
if($_SESSION['usuario_premiado'] == $usuario_ganador){
    echo "¡¡PREMIO!! por ser tú";
} else {
    echo "No has conseguido el premio <a href='./num_aleatorio.php'>Intentalo de nuevo</a>";
}
?>