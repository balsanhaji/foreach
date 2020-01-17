create table todos (
	num_todo serial primary key not null,
	nom_todo varchar,
	description_todo varchar,
	date_fin_todo date,
	num_liste serial references listes
);

create table listes (
	num_liste serial primary key not null,
	nom_liste varchar
);