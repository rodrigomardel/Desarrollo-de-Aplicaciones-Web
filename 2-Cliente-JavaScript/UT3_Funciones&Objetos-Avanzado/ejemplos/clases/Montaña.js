class Montaña {
  constructor(nombre, altitud, provincia) {
    this.nombre = nombre;
    this.altitud = altitud;
    this.provincia = provincia;
  }

  perteneceA() {
    console.log(
      `La montaña ${this.nombre} tiene ${this.altitud} y pertenece a ${this.provincia}`
    );
  }
}
