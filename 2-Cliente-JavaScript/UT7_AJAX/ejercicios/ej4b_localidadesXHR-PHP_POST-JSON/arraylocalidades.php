<?php
 //Array de localidades
$array_localidades = array("Burgos","Gumiel","Miranda","Lerma","Aranda","Hacinas", "Salas", "Frías", "Vivar", "Villadiego");

//Tomamos el valor del input procedente de la URL
$json = file_get_contents('php://input');
$data = json_decode($json);
$localidad = $data->localidad;
$esta = "N";

if ($localidad !== ""){
    $localidad = strtolower($localidad); //Pasamos la localidad a minúsculas
    
    foreach($array_localidades as $loc){ //Cada elemento del array lo pasa a $loc en cada iteración
        if(strnatcasecmp($localidad, $loc)== 0) { //Si coincide la cadena pasada con algún elemento del array
            $esta = "S";
        }
    }
}
echo $esta;
?>