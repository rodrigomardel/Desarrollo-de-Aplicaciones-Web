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

let vehiculo1 = new Vehiculo("VW", "California", "Azul", 200);
vehiculo1.comenzar();
vehiculo1.parar();
vehiculo1.distanciaMax(2);
