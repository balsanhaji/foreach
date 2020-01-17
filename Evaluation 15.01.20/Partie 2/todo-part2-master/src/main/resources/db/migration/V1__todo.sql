create table liste
(
    id  SERIAL PRIMARY KEY,
    nom VARCHAR NOT NULL
);

create table todo
(
    id          SERIAL PRIMARY KEY,
    nom         VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    termine     BOOLEAN,
    dateFin     Date,
    liste_id    INTEGER REFERENCES liste
);

insert into liste(nom) values('mes todos');