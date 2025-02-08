<?php
/**
 * Controlador principal encargado de redireccionar las opciones seleccionadas en la vista principal.
 */

 if (isset($_POST['enviar'])) {
    switch ($_POST['consultas']) {
        case 0:
            require_once('../model/Peliculas.php');
            $peliculas = new Peliculas();
            $peliculasDrama = $peliculas->obtenerPeliculasDrama();
            require_once('../views/vista_peliculas_drama.php');
           
            break;

        
        case 1:
            require_once('../model/Actores.php');
            $actores = new Actores();
            $actrices = $actores->obtenerActrices();
            require_once('../views/vista_nombre_actrices.php');
            break;

        case 2:
            require_once('../model/Actores.php');
            $actores = new Actores();
            $nacionalidades = $actores->obtenerNacionalidades();
            require_once('../views/vista_nacionalidades.php');
            break;

        case 3:
            require_once('../views/formulario_actor.html');
            break;

    }
}
?>