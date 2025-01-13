<?php
/*
Página 2: Crear un array de nombres: Marcos, Ana, Silvia, Pedro, Antonio. Obtener el nombre almacenado en el array a partir de la posición indicada por el número aleatorio generado en página1.
*/
session_start();

$usuarios = ["Marcos", "Ana", "Silvia", "Pedro", "Antonio"];
$_SESSION['usuarios'] = $usuarios;

$_SESSION['usuario_premiado'] = $usuarios[$_SESSION['numero_premiado']];


?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Continuar</title>
</head>
<body>
    <h3>¡¡ Sigue jugando !!</h3>
    <form action="./resultado_sorteo.php" method="post">
        <input type="submit">
    </form>
    
</body>
</html>