<?php
/** 
 * Control que asocia el actor buscado con las peliculas en las que intervino.
 */

if (isset($_POST['enviar'])) {
    //asignar id actor
    $nombreActor = htmlspecialchars($_POST["actor"]);
    require_once ('../model/Actores.php');
    $actor = new Actores();
    $idActor = $actor->obtenerIdActor($nombreActor);

    //asignar id con titulos
    require_once ('../model/Intervenir.php');
    $actoresIntervenir = new Intervenir();
    $peliculas = $actoresIntervenir->peliculasIntervinoActor($idActor);
    require_once ('../views/titulos_peliculas_actor.php');
}

?>