create DATABASE cinema;
use cinema;

CREATE TABLE actor(
    id_actor VARCHAR(5) PRIMARY KEY,
    nacionalidad VARCHAR(15),
    nombre_apellidos VARCHAR(45),
    sexo VARCHAR(1)
);

CREATE TABLE pelicula(
    titulo VARCHAR(50) PRIMARY KEY,
    genero VARCHAR(15),
    anno_prod YEAR
);

CREATE TABLE intervenir_actores_peliculas(
    id_actor VARCHAR(5) NOT NULL,
    titulo VARCHAR (50) NOT NULL,
    CONSTRAINT pk_intervenir PRIMARY KEY (id_actor, titulo),
    CONSTRAINT fk_intervenir_actor FOREIGN KEY (id_actor) REFERENCES actor(id_actor) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_intervenir_pelicula FOREIGN KEY (titulo) REFERENCES pelicula(titulo)
);

-- Datos actores
insert into actor (id_actor, nacionalidad, nombre_apellidos, sexo) values
	("00001","francés", "Jacqueline Bisset", "f"),
	("00002","española", "Antonio Banderas", "m"),
	("00003","española", "Belén Rueda", "f"),
	("00004","estadounidense", "Brad Pitt", "f"),
	("00005","estadounidense", "Laura Dern", "f");

-- Datos peliculas
insert into pelicula (titulo, genero, anno_prod) values
	("Dolor y gloria", "drama",2019),
	("Erase una vez...Hollywood","comedia",2019),
	("Historia de un matrimonio", "drama",2019),
	("La piel que habito", "thriller",2011);

-- Datos peliculas
insert into intervenir_actores_peliculas (id_actor, titulo) values
		("00002","Dolor y gloria"),
		("00004","Erase una vez...Hollywood"),
		("00005", "Historia de un matrimonio"),
		("00002", "La piel que habito");