<?php
date_default_timezone_set("Europe/Madrid");//franga horaria
//setlocale(LC_ALL,"");//"es_ES", "0"

//echo time();
echo "Fecha actual: ".date("D-M-Y")."<br>";
echo "Hora actual: ". date("h:i:s")."<br>";

print_r(getdate());
echo idate("d")."<br>";

//hora del momento
echo strftime("%A-%B-%Y");
?>