<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Vista peliculas dramáticas</title>
    </head>

    <body>
        <h1>Películas dramáticas</h1>
        <?php
          function mostrarPeliculasDrama($peliculas){
                foreach($peliculas as $titulo){
                    echo "$titulo<br/>";
                }
            }
            mostrarPeliculasDrama(explode(";", $peliculasDrama));
            ?>
        <a href='../index.php'>Volver</a>
    </body>

</html>