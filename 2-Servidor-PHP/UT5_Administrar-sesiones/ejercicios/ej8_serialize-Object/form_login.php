<?php
/*
 Serialización de los datos. Diseña la clase Usuario cuyos atributos serán nombre y contraseña y cuyos métodos únicamente su constructor y recuperador de atributos (__construct y __get, métodos mágicos). Diseña un pequeño formulario para un login y almacena los datos en el objeto. Si el usuario es “admin” y la contraseña “mjuan” mostrar el mensaje de “Bienvenido” y la próxima vez que acceda a la aplicación mostrar el mensaje “Usuario correcto”. Nombre_usuario. “Usted ya se logeó exitósamente en otro momento”. Si el usuario no es el indicado, mostrar el mensaje “Acceso denegado”.
*/
require_once('./Usuario.php');
$mensaje = "";

// Comprobación datos cookie
if (isset($_COOKIE['login'])) {
    $usuario = unserialize($_COOKIE['login']);
    echo "<p>Usuario correcto -> <strong>". $usuario->nombre. " </strong><br>Usted ya se logeó exitósamente en otro momento.</p>";
    $ocultarFormulario = "hidden"; 
    exit();

    } else {  

        if (isset($_POST['enviar'])) {
            // Credenciales correctas
            if ($_POST['usuario'] == 'admin' && $_POST['contraseña'] == 'mjuan') {
                $mensaje =  "<h2>¡Bienvenido!</h2>";
                $usuario = new Usuario($_POST['usuario'], $_POST['contraseña']);
                setcookie("login", serialize($usuario), time()+30);
            // Credenciales erróneas
            } else {
                $mensaje = "Acceso denegado";
            }
        }

    } 

?>


<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de Inicio de Sesión</title>
    <link rel="stylesheet" href="./style.css">
</head>
<body>
    <div class="login-container">
        <form action="#" method="post" <?php echo $ocultarFormulario; ?>>
            <h2>Iniciar Sesión</h2>
            <div class="input-group">
                <label for="usuario">Nombre de Usuario</label>
                <input type="text" id="usuario" name="usuario" placeholder="Ingresa tu nombre de usuario" >
            </div>
            <div class="input-group">
                <label for="contraseña">Contraseña</label>
                <input type="password" id="contraseña" name="contraseña" placeholder="Ingresa tu contraseña" >
            </div>
            <button type="submit" name="enviar">Entrar</button>
            <p><?php echo $mensaje;?></p>
        </form>
    </div>
</body>
</html>



