/*
Utiliza el fichero series.json.

Crea una página web que, al cargarse, haga una petición AJAX al servidor, que le devolverá el archivo JSON.

Si el archivo series.json no existe o no se ha podido cargar correctamente, se mostrará un texto indicándolo en la pantalla.

Si el archivo se carga correctamente, en la página se generará una tabla con los datos de las series, teniendo en cuenta las siguientes condiciones:

•	El título, la cadena y el director: el título será negrita, y el director en cursiva.
•	El año aparecerá en color rojo si la serie es anterior al año 2000, en amarillo si está entre el 2001 y el 2010 y en verde si es posterior al 2011. Estas variaciones se recogen en un archivo en CSS con reglas, como por ejemplo: .rojo, .amarillo o .verde. 
•	En la celda terminada habrá un icono que indique si la serie se ha terminado o no su emisión. Para ello, utiliza una fuente de iconos como por ejemplo Font Awesome (ver ejemplo de cómo hacerlo en la carpeta “prueba-fuentes”) o una imagen.
*/

document.addEventListener("DOMContentLoaded", () => {
  let tabla = document.createElement("table");
  document.body.append(tabla);

  cargarDatos();

  // Llamada al servidor
  function cargarDatos() {
    let url = new URL("./series.json", window.location.href);

    // let xhr = new XMLHttpRequest();
    // xhr.responseType = "json";
    // xhr.open("GET", url);

    // // Comprobacion respuesta
    // xhr.addEventListener("load", () => {
    //   if (xhr.status != 200) {
    //     alert(`Error ${xhr.status}: ${xhr.statusText}`);
    //   } else {
    //     let datos = xhr.response;
    //     cargarTabla(datos);
    //   }
    // });
    // xhr.send();

    // Equivalencia usando fetch
    fetch(url)
      .then((respuesta) => {
        if (!respuesta.ok) {
          throw new Error(`¡HTTP error! Status: ${Response.status}`);
        }
        return respuesta.json();
      })
      .then((datos) => cargarTabla(datos))
      .catch((err) => {
        console.error(err);
      });
  }

  // Visualización datos
  function cargarTabla(datos) {
    datos.series.forEach((serie) => {
      let tr = document.createElement("tr");
      console.log(serie);

      // Campos
      let tdTitulo = document.createElement("td");
      tdTitulo.style.border = "1px solid black";
      tdTitulo.innerHTML = `<strong> ${serie.titulo} </strong>`;

      let tdDirector = document.createElement("td");
      tdDirector.style.border = "1px solid black";
      tdDirector.innerHTML = `<em> ${serie.director} </em>`;

      let tdAño = document.createElement("td");
      tdAño.style.border = "1px solid black";
      if (serie.anio < 2000) {
        tdAño.classList.add("rojo");
        tdAño.textContent = serie.anio;
      } else if (serie.anio >= 2001 && serie.anio <= 2010) {
        tdAño.classList.add("amarillo");
        tdAño.textContent = serie.anio;
      } else if (serie.anio > 2011) {
        tdAño.classList.add("verde");
        tdAño.textContent = serie.anio;
      }

      let tdTerminada = document.createElement("td");
      let img = document.createElement("img");
      tdTerminada.style.border = "1px solid black";
      if (serie.terminada == "Si") {
        img.src = "./img/check-solid.svg";
        tdTerminada.append(img);
      } else {
        img.src = "./img/xmark-solid.svg";
        tdTerminada.append(img);
      }

      tr.append(tdTitulo);
      tr.append(tdDirector);
      tr.append(tdAño);
      tr.append(tdTerminada);

      tabla.append(tr);
    });
  }
});
