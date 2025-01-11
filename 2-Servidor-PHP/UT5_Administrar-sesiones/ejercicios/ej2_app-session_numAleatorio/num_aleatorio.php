<?php
/* Página 1: genera un número aleatorio del 0 al 4. */
session_start();
$numero = random_int(0,4);
$_SESSION['numero_premiado'] = $numero;
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Juega</title>
</head>
<body>
    <h3>¡¡ Juega y consigue tu premio !!</h3>
    <form action="./participantes.php" method="post">
        <input type="submit">
    </form>
    
</body>
</html>