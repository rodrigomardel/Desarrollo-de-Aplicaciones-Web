<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .msg-implementar{
            color: orange;
        }
    </style>
</head>
<body>
    <form action="./controler/controlador.php" method="POST">
        <span>Elegir una BBDD:</span>
        <select name="bases-de-datos" id="bases-de-datos">
            <?php
            $bases_de_datos = acceso_bases_de_datos();
            for ($i=0; $i <count($bases_de_datos) ; $i++) { 
                echo '<option value = '.$bases_de_datos[$i]. '>'. $bases_de_datos[$i]. '</option>'; 
            }
            ?>
        </select>
        <br>
        <span class="msg-implementar">** cinema y libreria pendiente de implementar</span>
        <br>
        <p>Consulta a realizar:</p>
        <textarea name="consulta" id="consulta"></textarea>
        <br>
        <input type="submit" name="continuar" value="Continuar">
    </form>
</body>
</html>