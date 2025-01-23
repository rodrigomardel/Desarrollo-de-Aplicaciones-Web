<?php
/*
 Serialización de los datos. Diseña la clase Usuario cuyos atributos serán nombre y contraseña y cuyos métodos únicamente su constructor y recuperador de atributos (__construct y __get, métodos mágicos). Diseña un pequeño formulario para un login y almacena los datos en el objeto. Si el usuario es “admin” y la contraseña “mjuan” mostrar el mensaje de “Bienvenido” y la próxima vez que acceda a la aplicación mostrar el mensaje “Usuario correcto”. Nombre_usuario. “Usted ya se logeó exitósamente en otro momento”. Si el usuario no es el indicado, mostrar el mensaje “Acceso denegado”.

    **EXTENSIÓN:
    Además de almacenar en el objeto del usuario su nombre y contraseña, se almacene información sobre el momento en el que el usuario intenta acceder a la aplicación; es decir, cada vez que el usuario con credenciales correctas acceda a la aplicación se visualice su nombre y la fecha y la hora (hh:mm:ss) de los accesos
*/
$mensaje = "";
require_once('./login/Usuario.php');

// Comprobación datos cookie
if (isset($_COOKIE['login'])) {
    header('location: ./login/registro_de_accesos.php');
    exit();
   
    } else {  

        if (isset($_POST['enviar'])) {

            // Credenciales correctas
            if ($_POST['usuario'] == 'admin' && $_POST['contraseña'] == 'mjuan') {

                $usuario = new Usuario($_POST['usuario'], $_POST['contraseña']);
                $usuario->añadirAcceso();
                setcookie("login", serialize($usuario), time()+30);

                header('location: ./login/acceso_bienvenida.html');

            // Credenciales erróneas
            } else {
                $mensaje = "Acceso denegado <br> Credenciales incorrectas";
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
    <link rel="stylesheet" href="./assets/style.css">
</head>
<body>
    <div class="login-container">
        <form action="" method="post">
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
            <p class="error"><?php echo $mensaje; ?></p>
        </form>
    </div>
</body>
</html>



