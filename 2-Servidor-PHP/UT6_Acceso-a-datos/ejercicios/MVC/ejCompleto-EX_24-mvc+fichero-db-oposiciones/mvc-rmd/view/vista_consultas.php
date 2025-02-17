<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
        font-family: sans-serif;
        margin: 20px;
        background-color: #f0f0f0; 
        color: #333; 
        }

        h2 {
        text-align: center;
        margin-bottom: 10px;
        color:rgb(30, 0, 255); 
        }

        table {
        width: auto; 
        margin: 20px auto; 
        border-collapse: collapse;
        border: 1px solid #ccc;
        }

        th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
        border: 1px solid #ccc; 
        }

        th {
        background-color:rgb(94, 119, 219); 
        color: white;
        }
        
        td {
        background-color:rgb(34, 188, 170);
        color: white;
        }

        a {
        display: block;
        text-align: center;
        margin-top: 20px;
        color: #007bff;
        text-decoration: none;
        }

        a:hover {
        text-decoration: underline;
        }
    </style>
</head>

<body>
    <?php
        function viewRespuestaPlaza($resultadoConsulta){
            echo "<h2>Opositores con plaza</h2><table><tr>
            <th>Código opositor</th>
            <th>Nota práctica</th>
            <th>Nota teoría</th>
            </tr>";
            while($arrayFila = $resultadoConsulta->fetch()){
                echo "<tr><td>$arrayFila[0]</td><td>$arrayFila[1]</td><td>$arrayFila[2]</td></tr>";
            }
            echo "</table><br>";
            echo "<a href='../index.php'>Volver</a>";
        }
       
        function viewRespuestaBolsa($resultadoConsulta){
            echo "<h2>Opositores en bolsa de trabajo</h2><table><tr><th>Código opositor</th></tr>";
            while($arrayFila = $resultadoConsulta->fetch()){
                echo "<tr><td>$arrayFila[0]</td></tr>";
            }
            echo "</table><br>";
            echo "<a href='../index.php'>Volver</a>";
        }

        function viewRespuestaNoApto($resultadoConsulta){
            echo "<h2>Opositores NO aptos</h2><table><tr><th>Código opositor</th></tr>";
            while($arrayFila = $resultadoConsulta->fetch()){
                echo "<tr><td>$arrayFila[0]</td></tr>";
            }
            echo "</table><br>"; 
            echo "<a href='../index.php'>Volver</a>";
        }
    ?>
</body>

</html>