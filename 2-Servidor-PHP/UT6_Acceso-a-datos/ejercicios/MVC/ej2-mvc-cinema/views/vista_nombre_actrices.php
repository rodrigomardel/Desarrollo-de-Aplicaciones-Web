<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Vista peliculas dramáticas</title>
    </head>

    <body>
        <h1>Actrices</h1>
        <?php
            function mostrarNombreActrices($actrices){
                foreach($actrices as $actriz){
                    echo "$actriz<br/>";
                }
            }
            mostrarNombreActrices(explode(";", $actrices));
        ?>
        <a href='../index.php'>Volver</a>
    </body>

</html>