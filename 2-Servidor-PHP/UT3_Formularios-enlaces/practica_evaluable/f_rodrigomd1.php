<?php
/**
 * Genera un array con los libros disponibles y sus géneros.
 * 
 * @return array array correspondiente.
*/
function construir_array():array{
    $array_libros = ['Ficción' => ['Atrapados', 'Dune'],
               'Aventuras' => ['Viajando','Vivir','Contigo'],
               'Misterio' => ['Inferno','Flandes','Da_Vinci']];
    return $array_libros;
}

/**
 * Validación del precio del libro; será un valor no vacío, real y positivo. Se visualiza un mensaje en caso de:
 *    - Estar vacío
 *    - No ser un valor real
 *    - No ser un valor positivo
 *      
 * 
 * @param string &$precio Referencia al valor del precio proporcionado por el usuario.
 * @param string &$mensaje_usuario Referencia al mensaje que se mostrará al usuario según la validación.
 * 
 * @return bool Devuelve `true` si el precio es válido, de lo contrario, devuelve `false`.
*/
function validar_precio(string &$precio, string &$mensaje_usuario):bool{
    if(!empty(htmlspecialchars(strtolower(trim($_POST["input_precio"]))))){

        if(filter_var($precio, FILTER_VALIDATE_FLOAT) !== false && $precio > 0){
            return true;
            
        } else{
            $mensaje_usuario = "<strong style='color: red; font-size: 1rem'>❌ El valor debe ser un número positivo</strong>";
            return false;
        }

    } else {
        $mensaje_usuario = "<strong style='color: red; font-size: 1rem'>¡Introduzca un valor!</strong>";
        return false;
    }

}

/**
 * Obtiene el género del titulo del libro solicitado en el formulario.
 * 
 * @param string $titulo_libro Titulo del libro correspondiente.
 * 
 * @return string $genero Género correspondiente al título.
 */
function obtener_genero(string $titulo_libro):string{

    foreach (construir_array() as $genero => $libros) {
        foreach ($libros as $libro) {
            if ($titulo_libro == $libro){
                return $genero;
            }
        }
    }
}

?>