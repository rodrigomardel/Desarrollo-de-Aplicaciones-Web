<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EJ18-RMD-20241015</title>
</head>
<body>
    <?php
    /*
    Muestra los fármacos que están caducados. Para ello, es necesario crear un array con 5 fármacos; de cada uno se 
    almacena su nombre y la fecha de caducidad. Utiliza una función que reciba el array y le devuelva sin los fármacos caducados.
    */

    $farmacos = [ "Paracetamol" => date("01/08/2023"),
                "Ibuprofeno" => date("15/03/2027"),
                "Omeprazol" => date("01/12/2022"),
                "Amoxicilina" => date("15/07/2025"),
                "Aspirina" => date("01/01/2028"), ];
    
    function filtrarFarmacosCaducados(Array $array) : Array{
        $farmacosSinCaducar = [];
        $fechaActual = time();

        foreach ($array as $nombre => $fechaCaducidad) {
            list($dia, $mes, $anio) = explode('/', $fechaCaducidad);
            $segundosFechaCaducidad = mktime(0, 0, 0, $mes, $dia, $anio);
    
            if ($segundosFechaCaducidad > $fechaActual) {
                $farmacosSinCaducar[$nombre] = $fechaCaducidad;
            }
        }
        return $farmacosSinCaducar;
    }
    
    $farmacosValidos = filtrarFarmacosCaducados($farmacos);
    print_r($farmacosValidos);
    ?>
    
</body>
</html>