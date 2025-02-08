<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vista nacionalidades</title>
    <link rel="stylesheet" href="../style.css">
</head>
<body>
    <form action="../controller/control_nacionalidades.php" method="POST">
      <table>
          <tr>
              <td>
                  <p>Elige una nacionalidad:</p>
                  <select name="consultas">
                      <?php
                      // Carga dinámica de las nacionalidades disponibles
                      foreach (explode(";", $nacionalidades) as $nacionalidad) {
                        echo "<option value='$nacionalidad'> $nacionalidad </option>";
                      }
                      ?>
                  </select>
              </td>
              <td>
                <button type="submit" name="enviar">Enviar</button>
              </td>
          </tr>
      </table>
    </form>
</body>
</html>