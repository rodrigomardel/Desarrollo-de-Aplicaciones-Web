<?php
session_start();
$_SESSION['alumno'] = "Esther";
$_SESSION['nota'] = 9.6;
//se acaba de iniciar una sesión y almacenado un dato en la variable superglobal
?>

<a href="./accesoaula.php"> Acceso al aula 25 </a>