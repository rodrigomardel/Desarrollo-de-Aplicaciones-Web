<?php

require_once('./clase_rodrigomd1.php');
require_once('./f_rodrigomd1.php');

/**Información para el usuario.*/
$mensaje_usuario = "";
/**Precio introducido.*/
$precio_input = $_POST["input_precio"];
/**Libro con su precio correspondiente.*/
$libro_precio_final = "";


/**Control que valida el formulario y muestra la salida en el navegador.*/
if (isset($_POST["enviar"])) {

    if(validar_precio($precio_input, $mensaje_usuario)){
        $libro_precio_final = new Libro( $_POST["titulo_libro"], $precio_input);
        echo $libro_precio_final;
        exit();
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PR1-UT3-RMD-20241217</title>
    <!-- Diseña una aplicación web para que a partir de un formulario se muestre un mensaje indicando el
    precio de un libro una vez aplicados determinados descuentos. Para ello será necesario diseñar
    un formulario para insertar el título del libro, su precio habitual y la aplicación de ciertos
    descuentos (cliente premium y vale 10% descuento aplicable a los libros de aventuras). -->
    <style>
        :root{
            font-family: Verdana, Geneva, Tahoma, sans-serif;
            font-size: 18px;
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
            font-size: 1.2rem;
            td{
                padding: 20px;
                border: 1px double black;
                background-color: lightsteelblue;
                border-radius: 10px;
            }
            button{
                background-color: lemonchiffon;
                padding: 2px 25px;
                border-radius: 10px;
                font-size: 1.1rem;
                box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.5);
            }
            .buttons{
                display: flex;
                justify-content: space-around;
            }
            .button_reset:hover{
                background-color: red;
            }
            .button_submit:hover{
                background-color: green;
            }
        }
        .precio_obligatorio{
            color: red;
            font-weight: bold;
            font-size: 1rem;
        }
        select#titulo_libro{
            font-size: 1.2rem;
        }
        input#precio{
            font-size: 1.2rem;
        }       
    </style>
</head>
<body>
    <form action="" method="POST">
        <h2>¡Vivir sin leer es peligroso, te obliga a creer en lo que te digan!</h2>
        <table>
            <tr>
            <!-- TITULOS -->
                <td rowspan="4">
                    <label for="titulo_libro">Seleccione un título:</label>
                    <select name="titulo_libro" id="titulo_libro">
                        <?php
                        /** Construcción de forma dinámica del select correspondiente a los títulos disponibles.*/
                        foreach (construir_array() as $libros) {
                            foreach ($libros as $libro) {
                                echo "<option value='$libro'>$libro</option>";
                            }
                        }
                        ?>
                    </select>
                </td>
            <!-- PRECIO -->
                <td >
                    <label for="precio">Precio:</label>
                    <input type="text" name="input_precio" id="precio" value='<?php echo htmlspecialchars($precio_input)?>'><span class="precio_obligatorio">* obligatorio </span><br><?php echo $mensaje_usuario ?>
                </td>
             </tr>
             <!-- DESCUENTO -->
            <tr>
                <td rowspan="2">
                    <p>Descuento <em>(oferta acumulable):</em></p>
                    <input type="checkbox" name="dto[cliente_premium]" id="cliente_premium" value="cliente_premium" >
                    <label for="cliente_premium">Cliente premium</label>
                    <br>
                    <input type="checkbox" name="dto[vale_10_aventuras]" id="vale_10_aventuras" value="vale_10_aventuras" >
                    <label for="vale_10_aventuras">Vale 10% en libros de aventuras</label>
                </td>
            </tr>
            <tr>
            </tr>
            <!-- BOTONES -->
            <tr>
                <td class="buttons">
                    <button class="button_reset" type="reset" name="reset">Borrar</button>
                    <button class="button_submit" type="submit" name="enviar">Enviar</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>