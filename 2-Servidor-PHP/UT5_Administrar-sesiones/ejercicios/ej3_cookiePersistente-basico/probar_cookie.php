<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test cookie</title>
</head>
<body>
    <?php

    if (isset($_COOKIE['prueba'])) {
        echo $_COOKIE['prueba']. ' estoy activa';
    }

    ?>
    
</body>
</html>