/*
Aquí está el código de la clase Rabbit que extiende a Animal.
Desafortunadamente, los objetos Rabbit no se pueden crear. ¿Que pasa? Arréglalo.
*/
class Animal {
  constructor(name) {
    this.name = name;
  }
}

class Rabbit extends Animal {
  constructor(name) {
    super(name);
    this.created = new Date();
  }

  consultarFechaCreacion() {
    alert(`${this.name} fue creado ${this.created}`);
  }

  get nombreAnimal() {
    return this.name;
  }

  set nuevoNombre(newName) {
    this.name = newName;
  }
}

let rabbit = new Rabbit("Conejo Blanco"); // Error: this no está definido
alert(rabbit.name);
rabbit.consultarFechaCreacion();
alert(rabbit.nombreAnimal);
rabbit.nuevoNombre = "Conejo mágico";
rabbit.consultarFechaCreacion();
//se debe llamar al constructor de la clase que se hereda con el super
