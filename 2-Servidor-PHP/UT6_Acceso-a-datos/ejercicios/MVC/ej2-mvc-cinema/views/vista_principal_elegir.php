<?php
// Habilitar todos los errores
error_reporting(E_ALL);
ini_set('display_errors', 1);

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vista principal</title>
    <link rel="stylesheet" href="./style.css">
</head>
<body>
    <form action="./controller/controler.php" method="POST">
      <table>
          <tr>
              <td>
                  <p>Elige una consulta:</p>
                  <select name="consultas">
                      <?php
                      $numOpcion = 0;
                      // Carga dinámica de las consultas disponibles
                      foreach (consultas_disponibles() as $consulta) {
                        echo "<option value='$numOpcion'> $consulta </option>";
                        $numOpcion++;
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