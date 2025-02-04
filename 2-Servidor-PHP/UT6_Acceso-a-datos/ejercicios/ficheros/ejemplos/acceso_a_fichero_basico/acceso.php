<?php
$nom_fichero1 = 'modulos.txt';
$fichero1 = fopen($nom_fichero1, 'a+');
$dato = "dwes;9\n";
fwrite($fichero1,$dato);
$dato = "dwes;8\n";
fputs($fichero1, $dato);
$dato = "di;6". PHP_EOL; //(PHP_EOL) equivalente a la secuencia de escape \n 
fwrite($fichero1, $dato);
fclose($fichero1);

?>