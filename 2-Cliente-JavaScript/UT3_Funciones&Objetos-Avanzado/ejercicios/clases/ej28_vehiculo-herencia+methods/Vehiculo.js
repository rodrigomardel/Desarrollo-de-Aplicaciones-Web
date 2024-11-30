/*
Crea una clase denominada Vehículo que tenga algunas características como el color, marca, modelo y la velocidad máxima que puede alcanzar. 

También tendrá tres métodos además del constructor: comenzar que mostrará el mensaje “Encender motor”, 
parar que mostrará “Apagar motor” y distanciaMax que recibirá un parámetro con indicando el tiempo de funcionamiento 
y calculará la distancia máxima que puede haber recorrido, que será el resultado de multiplicar la velocidad máxima por el tiempo. 
*/
class Vehiculo {
  constructor(marca, modelo, color, velocidadMaxima) {
    this.marca = marca;
    this.modelo = modelo;
    this.color = color;
    this.velocidadMaxima = velocidadMaxima;
  }

  comenzar() {
    alert("Encender motor");
  }

  parar() {
    alert("Apagar motor");
  }

  distanciaMax(tiempoFuncionamiento) {
    alert(this.velocidadMaxima * tiempoFuncionamiento);
  }
}

// let vehiculo1 = new Vehiculo("VW", "California", "Azul", 200);
// vehiculo1.comenzar();
// vehiculo1.parar();
// vehiculo1.distanciaMax(2);

/*
Partimos de la clase Vehiculo que has creado en un ejercicio anterior.

Crea dos clases más, ambas deben heredar de Vehículo: 
•	Coche: cuya velocidad máxima será 120 y sobrescribirá el método parar para que muestre “Aparcar”. 
•	Avión: cuya velocidad máxima será 1000 y sobrescribirá los métodos comenzar, para que muestre “Despegar”, 
y parar, para que muestre “Aterrizar”.
*/

class Coche extends Vehiculo {
  constructor(marca, modelo, color) {
    super(marca, modelo, color, 120);
  }

  parar() {
    console.log("Aparcar");
  }
}

class Avion extends Vehiculo {
  constructor(marca, modelo, color) {
    super(marca, modelo, color, 1000);
  }
  comenzar() {
    console.log("Despegar");
  }
  parar() {
    console.log("Aterrizar");
  }
}

let coche1 = new Coche("Audi", "A4", "Rojo");
coche1;
coche1.parar();
coche1.distanciaMax(2);
