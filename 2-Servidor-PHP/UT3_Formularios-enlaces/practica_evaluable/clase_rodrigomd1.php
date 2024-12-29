<?php

require_once('./f_rodrigomd1.php');

/**
* Representa un libro con un título, un precio y la capacidad de calcular un precio final considerando descuentos.
*/
class Libro {

    /**Título del libro.*/
    protected string $titulo; 
    /**Precio base del libro.*/
    protected int $precio;    

    /**
     * Inicializa el libro con un título y un precio.
     * 
     * @param string $titulo El título del libro.
     * @param int $precio El precio base del libro.
     */
    public function __construct(string $titulo, int $precio) {
        $this->titulo = $titulo;
        $this->precio = $precio;
    }

    /**
     * Calcula el precio final del libro considerando posibles descuentos.
     * 
     * Descuentos disponibles:
     * - 10% si el cliente es premium.
     * - 10% si se aplica un vale de descuento para libros de género "Aventuras".
     * 
     * @return string El precio final del libro.
     */
    public function calcular_precio():string {       
        if (isset($_POST["dto"])) {
            $precio_final = $this->precio; 

            if (isset($_POST["dto"]["cliente_premium"])) {
                $precio_final -= $this->precio * 0.10; 
            }

            if (isset($_POST["dto"]["vale_10_aventuras"])) {
                    if(obtener_genero($this->titulo) == "Aventuras"){
                        $precio_final -= $this->precio * 0.10; 
                    }
                }
                return $precio_final; 
                
            } else {
            return $this->precio;
        }
    }

    /**
     * Convierte el objeto a una representación en texto.
     * Devuelve una cadena con el título del libro y su precio calculado.
     * 
     * @return string Representación textual del libro.
     */
    function __toString():string {
        return "<p style='color: rebeccapurple; font-size: 2rem'>Precio final del título <strong> $this->titulo → " . self::calcular_precio() . "€</strong></p>";
    }
}

?>
