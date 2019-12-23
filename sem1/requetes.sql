CREATE TABLE jeux (
	num_jeu integer NOT NULL,
	titre_jeu char NOT NULL,
	note_jeu char NOT NULL,
	description_jeu text NOT NULL,
	public_jeu char NOT NULL,
	date_sortie_jeu date NOT NULL,
	prix_jeu integer NOT NULL,
	resume_jeu text NOT NULL,
	date_achat_jeu date NOT NULL,
	PRIMARY KEY (num_jeu)
);

CREATE TABLE users (
	num_user integer NOT NULL,
	mail_user char NOT NULL,
	pseudo_user char NOT NULL,
	date_naissance_user date NOT NULL,
	avatar_user char NOT NULL,
	PRIMARY KEY (num_user)
);

CREATE TABLE types (
	num_type integer NOT NULL,
	nom_type char NOT NULL,
	num_jeu integer,
	num_user integer,
	PRIMARY KEY (num_type),
	FOREIGN KEY (num_jeu) REFERENCES jeux,
	FOREIGN KEY (num_user) REFERENCES users
);

CREATE TABLE images (
	num_image integer NOT NULL,
	nom_image char NOT NULL,
	num_jeu integer,
	PRIMARY KEY (num_image),
	FOREIGN KEY (num_jeu) REFERENCES jeux
);

CREATE TABLE notes (
	num_note integer NOT NULL,
	nom_note char NOT NULL,
	num_jeu integer,
	num_user integer,
	PRIMARY KEY (num_note),
	FOREIGN KEY (num_jeu) REFERENCES jeux,
	FOREIGN KEY (num_user) REFERENCES users
);

CREATE TABLE succes (
	num_succes integer NOT NULL,
	nb_succes integer NOT NULL,
	points_succes integer NOT NULL,
	num_jeu integer,
	num_user integer,
	PRIMARY KEY (num_succes),
	FOREIGN KEY (num_jeu) REFERENCES jeux,
	FOREIGN KEY (num_user) REFERENCES users
);

CREATE TABLE publics (
	num_public integer NOT NULL,
	type_public integer NOT NULL,
	num_jeu integer,
	PRIMARY KEY (num_public),
	FOREIGN KEY (num_jeu) REFERENCES jeux
);

CREATE TABLE parties (
	derniere_partie date NOT NULL,
	num_jeu integer,
	num_user integer,
	PRIMARY KEY (num_jeu, num_user),
	FOREIGN KEY (num_jeu) REFERENCES jeux,
	FOREIGN KEY (num_user) REFERENCES users
);

CREATE TABLE souhaits (
	date_souhait date NOT NULL,
	num_jeu integer,
	num_user integer,
	PRIMARY KEY (num_jeu, num_user),
	FOREIGN KEY (num_jeu) REFERENCES jeux,
	FOREIGN KEY (num_user) REFERENCES users
);