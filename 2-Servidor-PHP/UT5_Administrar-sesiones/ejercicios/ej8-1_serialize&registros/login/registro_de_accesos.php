<?php
require_once('./Usuario.php');

$usuario = unserialize($_COOKIE['login']);
$accesosAlmacenados = $usuario->accesos;

?>
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de accesos</title>
		<style>
			body {
				font-family: Arial, sans-serif;
				background-color: #f0f0f0;
				height: 100vh;
				text-align: center;
			}
			.fin-sess{
				color: grey;
				font-weight: bold;
				font-size: 1.5rem;
			}
		</style>
</head>
<body>
    <h1>Registro de accesos</h1>
    <p>
        <?php  
        // Visualización usuario y accesos
        echo "Usuario correcto → <strong>$usuario->nombre</strong><br>Usted ya se logeó exitósamente en otro momento.<br></p><p>Fecha y hora del registro:<br>";  
        foreach ($accesosAlmacenados as $datosAcceso) {
            echo "$datosAcceso <br>";
        }
        ?>
    </p>
    
    <?php
        if($usuario){
            echo "<a href='./registro_de_accesos.php'>Actualizar</a>";

            // Agregar nuevo acceso
            $usuario->añadirAcceso();
            setcookie("login", serialize($usuario), time()+30);
            exit();
        } else {
            echo "<p class='fin-sess'>Su sesión ha expirado <br>
								<a href='../index.php'>Volver</a></p>";
        }
		?>
</body>
</html>
 



