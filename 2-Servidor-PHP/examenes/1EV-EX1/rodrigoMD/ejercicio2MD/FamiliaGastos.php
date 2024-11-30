<?php


    class FamiliaGastos extends Familia{

        private $año;
        private $mes;
        private $importeGastos = [];


        public function __construct ($ingresos, $miembros, $año, $mes, $importeGastos){
            parent::__construct($ingresos, $miembros);
            $this->año = $año;
            $this->mes = $mes;
            $this->importeGastos = $importeGastos;
        }

        public function importeTotalGastos(){
            $totalGastos = 0;
        
            foreach ($this->importeGastos as $value) {
                $totalGastos += $value* $this->miembros;
            }
            return "Importe total de los gastos en ". $this->año. " ha sido ". $totalGastos;

        }

}

?>