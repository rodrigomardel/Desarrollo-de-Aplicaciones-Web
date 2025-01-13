<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Control de sesiones</title>
</head>
    <body>
        <?php
        session_start();
        echo $_SESSION['alumno']."¡¡ El aula 25 te espera !!"."<br>";
        echo "Nota: ". $_SESSION['nota']."<br>";
        echo "-------------------------- <br>";
        echo "Variable SID: ". session_name()."<br>SID: ". session_id()."<br>";
        //session_destroy();
        ?>
    </body>
</html>