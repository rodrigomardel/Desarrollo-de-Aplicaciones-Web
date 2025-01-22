<?php

    /**
     * Representa un usuario con un nombre, contraseña y un registro de acceso.
     */
    class Usuario {

        /**
         * Nombre del usuario.
         */
        protected string $nombre;

        /**
         * Contraseña del usuario.
         */
        protected string $contraseña;

        /**
         * Registro de accesos del usuario.
         */
        protected array $accesos;

        /**
         * Constructor de la clase Usuario.
         * 
         * @param string $nombre Nombre del usuario.
         * @param string $contraseña Contraseña del usuario.
         */
        public function __construct(string $nombre, string $contraseña) {
            $this->nombre = $nombre;
            $this->contraseña = $contraseña;
            $this->accesos = [];
        }

        /**
         * Permite acceder a las propiedades protegidas de la clase.
         * 
         * @param string $atrib Nombre del atributo que se desea obtener.
         * @return mixed Valor del atributo solicitado.
         */
        function __get(string $atrib):mixed {
            return $this->$atrib;
        }

        /**
         * Registra un nuevo acceso del usuario.
         */
        function añadirAcceso() {
            setlocale(LC_ALL,"es_ES");
            date_default_timezone_set("Europe/Madrid");
            array_push($this->accesos, date("D/M/Y h:i:s A"));
        }
    }

?>
