CREATE TABLE clients (
    num_client serial NOT NULL PRIMARY KEY,
    nom varchar,
    prenom varchar,
    adresse varchar,
    ville varchar,
    code_postal varchar,
    pays varchar,
    telephone varchar,
    email varchar
);

CREATE TABLE hotels (
    num_hotel serial NOT NULL PRIMARY KEY,
    nom varchar,
    adresse varchar,
    telephone varchar
);

CREATE TABLE classes (
    num_classe serial NOT NULL PRIMARY KEY
);

CREATE TABLE classes_hotel (
    num_hotel integer REFERENCES hotels,
    num_classe integer REFERENCES classes,
    caracteristiqu varchar
);

CREATE TABLE categories_chambre (
    num_code_categorie serial NOT NULL PRIMARY KEY,
    description varchar
);

CREATE TABLE couter (
    num_code_categorie integer REFERENCES categories_chambre,
    num_classe integer REFERENCES classes,
    prix numeric
);

CREATE TABLE chambres (
    num_chambre serial NOT NULL PRIMARY KEY,
    telephone varchar,
    num_code_categorie integer REFERENCES categories_chambre,
    num_hotel integer REFERENCES hotels
);

CREATE TABLE reservations (
    num_reservation serial NOT NULL PRIMARY KEY,
    date_debut timestamp,
    date_fin timestamp,
    date_arrhes timestamp,
    montant_arrhes numeric,
    num_client integer REFERENCES clients,
    num_chambre integer REFERENCES chambres
);


CREATE TABLE consommations (
    num_consommation serial NOT NULL PRIMARY KEY,
    date_consommation timestamp
);

CREATE TABLE consommer (
    num_client integer REFERENCES clients,
    num_consommation integer REFERENCES consommations
);

CREATE TABLE prestations (
    num_prestation serial NOT NULL PRIMARY KEY,
    designation varchar
);

CREATE TABLE concerner (
    num_prestation integer REFERENCES prestations,
    num_consommation integer REFERENCES consommations
);

CREATE TABLE offir (
    num_hotel integer REFERENCES hotels,
    num_prestation integer REFERENCES prestations
);



