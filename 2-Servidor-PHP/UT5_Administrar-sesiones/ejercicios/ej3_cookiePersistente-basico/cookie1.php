<?php
//El servidor crea una cookie persistente
setcookie("prueba", "hay una cookie", time()+30);
echo "creada";
?>