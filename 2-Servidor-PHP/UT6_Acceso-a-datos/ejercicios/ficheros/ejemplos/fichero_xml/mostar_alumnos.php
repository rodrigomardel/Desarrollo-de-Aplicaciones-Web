<?php
echo "<h3>Versión Procedimental</h3>";
//Version procedimental
//Obtenemos un objeto de la clase SimpleXMLElement
$alumnos = simplexml_load_file("alumnos.xml");

// var_dump($alumnos);

$numero_alumnos = count($alumnos->alumno);

for ($i=0; $i < $numero_alumnos ; $i++) { 
    echo "ID_Alumno: " . $alumnos->alumno[$i]->id_al."  ".
    "Nombre: " . $alumnos->alumno[$i]->nombre."  ".
    "Edad: " .$alumnos->alumno[$i]->edad."  ".
    "Codigo: " . $alumnos->alumno[$i]->codigo."<br>";
}


echo "<br><br>";
echo "<h3>Versión POO</h3>";
//Version POO
require_once('./alumnos_xml.php');
//Creación del objeto a partir de un String
//$alumnosPOO = new SimpleXMLElement($xml);
//Creación del objeto con el constructor para indicar una URL
$alumnosPOO = new SimpleXMLElement("./alumnos.xml",0,true);

$numero_alumnos = count($alumnosPOO->alumno);

for ($i=0; $i < $numero_alumnos ; $i++) { 
    echo "ID_Alumno: " . $alumnos->alumno[$i]->id_al."  ".
    "Nombre: " . $alumnos->alumno[$i]->nombre."  ".
    "Edad: " .$alumnos->alumno[$i]->edad."  ".
    "Codigo: " . $alumnos->alumno[$i]->codigo."<br>";
}

?>