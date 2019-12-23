/* PARTIE 1 */

/*  */
create table film (
	id_film serial primary key not null,
	titre_film varchar,
	type_film_film serial references type_film
);

/*  */
create table type_film (
	id_type_film serial primary key not null,
	libelle_type_film varchar
);

/*  */
insert into type_film(libelle_type_film) values('action');
insert into film(titre_film, type_film_film) values('Léon', 1);

/*  */
insert into type_film(libelle_type_film) values('dessin animé');
insert into film(titre_film, type_film_film) values('Kiki la petite sorcière', 2);

/*  */
alter table type_film add column limite_age_type_film numeric;

/*  */
update type_film set limite_age_type_film = 8 where libelle_type_film = 'dessin animé';
update type_film set limite_age_type_film = 16 where libelle_type_film = 'action';

/*  */
films.SQL


/* PARTIE 2 */

/*  */
create table personne (
	id_personne serial primary key not null,
	nom_personne varchar,
	prenom_personne varchar,
	date_naissance_personne date
)

/*  */
insert into personne(nom_personne, prenom_personne, date_naissance_personne) values('AL SANHAJI', 'Bilal', '18/07/1992');

/*  */
create table location (
	id_location serial primary key not null,
	date_debut_location date,
	date_fin_location date,
	personne_location serial references personne,
	film_location serial references film
);

/*  */
create table location (
	id_location serial primary key not null,
	date_debut_location date,
	date_fin_location date,
	personne_location serial references personne,
	film_location serial references film
);

/*  */
insert into location(date_debut_location, date_fin_location, personne_location, film_location)
values('13/12/2019','31/12/2019', 1, 13);

/*  */
alter table film add column prix_film numeric;

/*  */
update film set prix_film = 5.5 where id_film between 1 and 6;
update film set prix_film = 6.7 where id_film between 7 and 13;
update film set prix_film = 7.3 where id_film between 14 and 18;
update film set prix_film = 4.9 where id_film between 19 and 23;

/*  */
locations.SQL


/* PARTIE 3 */

/*  */
select nom_personne, prenom_personne, date_naissance_personne from personne;

/*  */
select film.titre_film, type_film.libelle_type_film from film, type_film where film.type_film_film = type_film.id_type_film;

/*  */
select count(film.id_film) as nb_films, type_film.libelle_type_film from film, type_film where film.type_film_film = type_film.id_type_film group by type_film.libelle_type_film order by nb_films;

/*  */
select count(distinct location.film_location) from location;

/*  */
select count(location.film_location) from location where (location.date_fin_location > now() or location.date_fin_location is null);

/*  */
select count(location.film_location) from location where (location.date_fin_location > now() or location.date_fin_location is null);

/* max() : Le film a été loué puis loué à nouveau */
select film.titre_film from film, location where film.id_film = location.film_location group by film.titre_film having max(location.date_fin_location) < now();

/*  */
select film.titre_film, personne.nom_personne, personne.prenom_personne from film, personne, location where film.id_film = location.film_location and location.personne_location = personne.id_personne order by film.titre_film;

/*  */
select film.titre_film, personne.nom_personne, personne.prenom_personne from film, personne, location where film.id_film = location.film_location and location.personne_location = personne.id_personne and location.date_fin_location > now() order by film.titre_film;

/*  */
select film.titre_film, personne.nom_personne, personne.prenom_personne from film left join location on film.id_film = location.film_location and location.date_fin_location > now()left join personne on location.personne_location = personne.id_personne order by film.titre_film

/*  */
select film.titre_film, count(location.film_location) as nbfilms from film left join location on location.film_location = film.id_film group by film.titre_film order by nbfilms;

/*  */
select personne.nom_personne, count(location.personne_location) as nbfilms from personne left join location on location.personne_location = personne.id_personne group by personne.nom_personne order by nbfilms;

/*  */
select location.personne_location from location, personne where location.date_fin_location >= now() and location.personne_location = personne.id_personne group by location.personne_location having count(location.personne_location) > 1;

/* */
select location.personne_location from location, personne where location.date_fin_location >= now() and location.personne_location = personne.id_personne or location.date_fin_location is null group by location.personne_location having count(location.personne_location) > 1;