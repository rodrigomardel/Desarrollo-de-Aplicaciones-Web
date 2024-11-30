class RelojC {
  constructor({ plantilla }) {
    this.plantilla = plantilla;
  }

  mostrar() {
    let date = new Date();

    let hours = date.getHours();
    if (hours < 10) hours = "0" + hours;

    let mins = date.getMinutes();
    if (mins < 10) mins = "0" + mins;

    let secs = date.getSeconds();
    if (secs < 10) secs = "0" + secs;

    let output = this.plantilla
      .replace("h", hours)
      .replace("m", mins)
      .replace("s", secs);

    console.log(output);
  }

  stop() {
    clearInterval(this.temporalizador);
  }

  start() {
    this.temporalizador = setInterval(() => {
      this.mostrar();
    }, 1000);
  }
}

// let miReloj = new RelojC({ plantilla: "h:m:s" });
// miReloj.start();
// setTimeout(() => {
//   miReloj.stop();
// }, 5000);

/*
Partimos de la clase Reloj que has creado en un ejercicio anterior.
Crea una nueva clase RelojExtendido que herede de Reloj y agregue la propiedad precision: 
este es el número de milisegundos que entre “tics”, es decir, el número de milisegundos entre cada console.log() 
que muestra la hora. El valor por defecto es 1000 (1 segundo).
*/

class RelojExtendido extends RelojC {
  constructor({ plantilla }) {
    super({ plantilla });
    this.precision = super.mostrar();
  }
}

let miRelojExtendido = new RelojExtendido({ plantilla: "h:m:s" });
