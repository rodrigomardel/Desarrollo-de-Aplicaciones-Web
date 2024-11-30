<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php    
    $dato1 = 13; //número de aula
    // $dato2 = 'DWES';
?>
    <!-- <a href='./pagina2.php?dato1=13'>SEGUIR</a><br> -->
    <a href='./pagina2.php?dato1=<?php echo $dato1;?>&dato2="DWES"'>SEGUIR</a>

</body>
</html>