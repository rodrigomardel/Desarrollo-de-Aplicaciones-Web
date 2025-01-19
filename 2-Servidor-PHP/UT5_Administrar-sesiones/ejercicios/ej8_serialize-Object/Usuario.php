<?php

    /**
     * Clase Usuario
     * 
     * Representa un usuario con un nombre y una contraseña.
     */
    class Usuario {

        /**
         * @var string $nombre Nombre del usuario (protegido).
         */
        protected string $nombre;

        /**
         * @var string $contraseña Contraseña del usuario (protegido).
         */
        protected string $contraseña;

        /**
         * Constructor de la clase Usuario.
         * 
         * @param string $nombre Nombre del usuario.
         * @param string $contraseña Contraseña del usuario.
         */
        public function __construct(string $nombre, string $contraseña) {
            $this->nombre = $nombre;
            $this->contraseña = $contraseña;
        }

        /**
         * Método mágico __get.
         * Permite acceder a las propiedades protegidas de la clase.
         * 
         * @param string $atrib Nombre del atributo que se desea obtener.
         * @return mixed Valor del atributo solicitado.
         */
        function __get(string $atrib) {
            return $this->$atrib;
        }

        /**
         * Método mágico __toString.
         * Devuelve una representación en cadena del objeto Usuario.
         * 
         * @return string Descripción del usuario con su nombre y contraseña.
         */
        function __toString() {
            return "Usuario: $this->nombre <br> Contraseña: $this->contraseña";
        }
    }

?>
