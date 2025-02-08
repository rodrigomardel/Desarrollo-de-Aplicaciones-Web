<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

/**
 * Control encargado de mostrar el número de actores o actrices que pertenecen a una misma nacionalidad.
 */

 if (isset($_POST['enviar'])) {
  switch ($_POST['consultas']) {
    case 'francés':
      require_once('../model/Actores.php');
      $actores = new Actores();
      $numActores = $actores->contarActoresPorNacionalidad('francés');
      require_once('../views/num_nacionalidades.php');
      break;
    
    case 'española':
      require_once('../model/Actores.php');
      $actores = new Actores();
      $numActores = $actores->contarActoresPorNacionalidad('española');
      require_once('../views/num_nacionalidades.php');
      break;

    case 'estadounidense':
      require_once('../model/Actores.php');
      $actores = new Actores();
      $numActores = $actores->contarActoresPorNacionalidad('estadounidense');
      require_once('../views/num_nacionalidades.php');
      break;
  }
}

?>
