<?php
if(isset($_COOKIE['ciclos'])){
    switch ($_COOKIE['ciclos']) {
        case 'asir':
            header('location:./asir.php');
            break;
        case 'daw':
            header('location:./daw.php');
            break;
        case 'dam':
            header('location:./dam.php');
            break;
            default:
            break;
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UT5-EJ5-RMD-20250110</title>
    <!-- Diseña una aplicación que ofrezca a través de una tabla tres enlaces a los tres ciclos de grado superior. Si eres de asir, se creará una cookie donde el parámetro enviado para su creación será asir, si eres de dam, el parámetro será dam y si eres de daw, el parámetro será daw. La próxima vez que accedas a la aplicación, ya no te pedirá que elijas el ciclo, sino que ya irás directamente a ver los módulos de 2º del ciclo en el cuál estás matriculado. Crea una cookie para conseguirlo. -->
    <style>
        :root{
            font-family: Verdana, Geneva, Tahoma, sans-serif;
            font-size: 16px;
        }
        form{
            display: flex;
            flex-direction: column;
            align-items: center;
            h2{
                color: rebeccapurple;
            }
        }
        table{
            border: 4px inset rebeccapurple;
            background-color: lightseagreen;
            padding: 2.5px;
            border-radius: 10px;
            box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.5);
            td{
                padding: 20px;
                border: 1px double black;
                background-color: lightsteelblue;
                border-radius: 10px;
            }
        }
        .button {
            display: inline-block;
            background-color:rebeccapurple;
            border-radius: 10px;
            padding: 5px 20px;
            margin-left: 15px;
            border: 2px solid black;
            box-shadow: 2px 2px rgba(0, 0, 0, 0.5);
            color: white;
            text-decoration: none;
            text-align: center;
        }
       
    </style>
</head>
<body>
    <form action="" method="POST">
        <h2>Ciclos Formativos de Grado Superior</h2>
        <table>
            <tr>
                <td>
                Desarrollo Aplicaciones Web
                </td>
                <td >
                <a href="./daw.php" class="button">Más información</a>
                </td>
             </tr>
             <tr>
                <td>
                Desarrollo de Aplicaciones Multiplataforma
                </td>
                <td >
                <a href="./dam.php" class="button">Más información</a>

                </td>
             </tr>
             <tr>
                <td>
                Administración de Sistemas Informáticos en Red
                </td>
                <td>
                <a href="./asir.php" class="button">Más información</a>
                </td>
             </tr>
     
        </table>
    </form>
</body>
</html>