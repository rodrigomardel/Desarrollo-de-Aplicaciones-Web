-- Crear BBDD y usar
CREATE DATABASE ciclos;
use ciclos;

-- Crear tablas
CREATE TABLE curso (
    id_curso INT, 
    denominacion VARCHAR(15), 
    CONSTRAINT pk_curso PRIMARY KEY (id_curso)) ENGINE=InnoDB;

CREATE TABLE alumno (
    id_alumno INT PRIMARY KEY,
    nombre VARCHAR(15),
    edad INT,
    id_curso INT,
    CONSTRAINT fk_alumno FOREIGN KEY (id_curso) 
        REFERENCES curso(id_curso) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
) ENGINE=InnoDB;


-- Modificar clave foranea
    ALTER TABLE alumno DROP FOREIGN KEY fk_alumno;
    ALTER TABLE alumno ADD  CONSTRAINT fk_alumno FOREIGN KEY (id_curso) REFERENCES curso(id_curso) ON DELETE CASCADE ON UPDATE CASCADE;


-- Modificación nombre
ALTER TABLE alumno CHANGE id_alumno id_al INT;

-- Mostrar
DESC alumno;


-- Insetar datos curso
INSERT INTO curso (id_curso, denominacion) VALUES (1,'DAW1');
INSERT INTO curso (id_curso, denominacion) VALUES (2,'DAW2');
-- Visualizacion
SELECT * FROM curso;

-- Insertar datos alumnos definiendo directamente los valores
INSERT INTO alumno VALUES (1, 'Ana', 18, 1), (2, 'Sergio', 18, 1), (3, 'Jorge', 19, 1),  (4, 'Maria', 21, 2);
-- INSERT INTO alumno  VALUES (5, “Pedro”, 23, 3); *No existe el curso 3*
INSERT INTO alumno  VALUES (5, 'Pedro', 23, 2);
-- INSERT INTO alumno  VALUES (6, “Juan”, 21); *Falta definir el último campo*
INSERT INTO alumno  VALUES (6, 'Juan', 21, NULL) ;


-- Consultas
-- Datos de los alumnos que tengan 18 años
SELECT * FROM alumno WHERE edad = 18;

-- Nombre y edad de los alumnos que tengan 18 años 
SELECT nombre, edad FROM alumno WHERE edad = 18;

-- Nombre de los alumnos que no tengan 18 años
SELECT nombre FROM alumno WHERE edad != 18;

-- Edad del alumno que se llama Jorge 
SELECT edad FROM alumno WHERE nombre = 'Jorge';

-- Datos de los alumnos cuyo código de alumno no sea NULL 
SELECT * FROM alumno WHERE id_curso is not NULL;

-- Nombre de los alumnos que tengan o 18 años o 21 
SELECT * FROM alumno WHERE edad = 18 or edad = 21;

-- Nombre de los alumnos que tengan entre 18 y 21 (ambos inclusives) 
SELECT * FROM alumno WHERE edad>=18 and edad<=21;
