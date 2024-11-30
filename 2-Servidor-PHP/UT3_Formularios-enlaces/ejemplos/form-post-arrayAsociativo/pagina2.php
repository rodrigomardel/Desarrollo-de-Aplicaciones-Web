<?php

echo "El nombre de usuario es ". $_POST['usuario']['nombre']."<br>";
if($_POST["turno"]=="Diurno") {
    echo "Turno ⇾ Diurno";
} else {
    echo "Turno ⇾ Vespertino";
}


?>