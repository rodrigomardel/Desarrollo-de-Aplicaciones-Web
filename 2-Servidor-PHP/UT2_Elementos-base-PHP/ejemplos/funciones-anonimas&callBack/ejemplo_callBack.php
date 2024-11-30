<?php
    function mostrar(callable $cbNumeroEligido, int $num ):void{
        $cbNumeroEligido($num);
        
    }
    function mostrar2(callable $cbDibujar, int $num ):string{
        $asteriscos= $cbDibujar($num);
        return $asteriscos;
    }
?>