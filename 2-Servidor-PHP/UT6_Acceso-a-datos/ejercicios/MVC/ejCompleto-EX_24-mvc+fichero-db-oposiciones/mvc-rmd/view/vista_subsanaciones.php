<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Resultado subsanación</h1>
    <p>
        <?php
        echo $mensajeInfo;
        $operacionesBD->cerrarConexion();
        ?>
    </p>
    <a href="../index.php">Volver</a>
</body>
</html>