<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="./pagina2.php" method="post">
        Usuario: <input type="text" name="usuario[nombre]"><br>
        Password: <input type="password" name="usuario[clave]"><br>

        Turno: <input type="radio" name="turno" value="Diurno"/>Diurno  
                <input type="radio" name="turno" value="Vespertino"/>Vespertino
        <br>
        <input type="submit" name="enviar" value="OK">
    </form>
</body>
</html>