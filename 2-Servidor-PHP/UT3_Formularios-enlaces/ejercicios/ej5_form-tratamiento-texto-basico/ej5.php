<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EJ5-RMD-20241210</title>
</head>
<body>

<!-- ¿De qué color es el caballo blanco de Santiago? 
Crea un formulario que capture un string; tanto si aciertas como si no, 
visualiza un mensaje indicándolo. 
Este pequeño tratamiento estará incluido en otra página web (atributo action de <form>). Utiliza:
Método POST -->

<form action="./seguir.php" method="post">
    ¿De qué color es el caballo blanco de Santiago?<br> 
    <input type="text" name="dato">
    <input type="submit" name="enviar">
</form>
    
</body>
</html>
