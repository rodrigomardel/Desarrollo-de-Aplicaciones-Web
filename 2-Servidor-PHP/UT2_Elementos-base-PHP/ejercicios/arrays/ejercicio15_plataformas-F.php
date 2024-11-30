<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EJ15-RMD-20241008</title>
</head>
<body>
    <?php
    /*
    Es preciso almacenar las plataformas web vistas en la UT1 y recoger de cada una de ellas sus componentes. 
    */

    $plataformas1 = ['WAMP' => array('Windows', 'Apache', 'MySQL', 'PHP'),
                    'XAMPP' => array('Windows', 'Apache', 'MySQL', 'PHP'),
                    'WISA' => array('Windows', 'IIS', 'SQL_Server', 'ASP.net'),
                    'Nueva' => array('Linux', 'NGINX', 'MariaDB', 'PHP')];


    $plataformas2 = ['WAMP' => array('S.O.' => 'Windows','Servidor Web' => 'Apache', 'Servidor B.D.' => 'MySQL','Tecnologia' => 'PHP'),
                    'XAMPP' => array('S.O.' => array('Windows','Linux'),'Servidor Web' => 'Apache', 'Servidor B.D.' => 'MySQL','Tecnologia' => array('PHP','Perl')),
                    'WISA' => array('S.O.' => 'Windows', 'Servidor Web' => 'IIS', 'Servidor B.D.' => 'SQL_Server','Tecnologia' => 'ASP.net'),
                    'WAMP' => array('S.O.' => 'Linux', 'Servidor Web' => 'NGINX', 'Servidor B.D.' => 'MariaDB','Tecnologia' => 'PHP')];


    //var_dump($plataformas2);

    /*Con un mensaje indica en cuales de ellas el servidor web es Apache.*/

    foreach($plataformas2 as $paqueteSoftware => $componente){
        foreach($componente as $tecnologia => $nombre){
            if($nombre == "Apache"){
                echo "$paqueteSoftware usa como servidor web $nombre"; 

            }
        }

    }

    /*Con un mensaje indica en cuales de ellas el S.O. es Windows.*/

    $resultado = "";

    foreach($plataformas2 as $paqueteSoftware => $componente){
        foreach ($componente as $valor){

            if(is_array($valor)){
                if(in_array('Windows',$valor));
                //codigo
            }else if($valor == 'Windows'){
                //codigo
            }
        }
        return $resultado;
    }

    echo $resultado;





               
    ?>
</body>
</html>