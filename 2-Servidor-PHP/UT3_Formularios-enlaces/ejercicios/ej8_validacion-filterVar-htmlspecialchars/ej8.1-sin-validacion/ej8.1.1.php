<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EJ8.1-RMD-20241213</title>
</head>
<body>
<?php
/*
Diseña un formulario que capture un número y se visualice la tabla de multiplicar. Casos:
8.1.- Sin validación
*/

if (isset($_POST['enviar'])) {

    if (!empty($_POST['numero'])) {
        for ($i=0; $i <= 10; $i++) { 
            echo $_POST['numero']. "×" .$i. " = ". $_POST['numero']*$i .'<br>';
        }

    } else {
        echo "Debe introducir un número";
    }
}


?>

<form action="" method="post">
    Introduzca el número de la tabla de multiplicar que desea<br> 
    <input type="number" name="numero">
    <input type="submit" name="enviar">
</form>
    
</body>
</html>
