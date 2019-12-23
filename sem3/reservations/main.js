let reservations = [
    {
        nom: 'Ferro',
        nombre: 2,
        dates: 'Du 2 au 5 décembre 2019'
    }, {
        nom: 'Boitelle',
        nombre: 5,
        dates: 'Du 5 au 6 décembre 2019'
    }, {
        nom: 'Boniface',
        nombre: 3,
        dates: 'Du 1 au 2 décembre 2019'
    }
];

const form = document.querySelector("form");

form.addEventListener("submit", (e) => {
	e.preventDefault();

	const newReservation = {
		nom:	document.querySelector("#nom").value,
		nombre: Number(document.querySelector("#nombre").value),
		dates:	document.querySelector("#dates").value
	};
	reservations.push(newReservation);

	afficher(reservations);
});

const afficher = (reservationsAAfficher) => {
	document.querySelector("#reservations").textContent = "";
	reservationsAAfficher.forEach((reservation, index) => {
		// Création du li
		const liReservation = document.createElement('li');

		// Création de l'article
		const articleReservation = document.createElement("article");
		articleReservation.classList.add("reservation");

		// Création du titre
		const titreReservation = document.createElement("h2");
		titreReservation.textContent = "Réservation pour: " + reservation.nom;

		// Ajout du titre dans l'article
		articleReservation.append(titreReservation);

		// Création des informations
		const ulInformations = document.createElement("ul");
		ulInformations.classList.add("informations");

		// Ajout de la liste des informations
		const liNombre = document.createElement("li");
		liNombre.textContent = "Nombre d'adultes: " + reservation.nombre;
		ulInformations.append(liNombre);
		const liDates = document.createElement("li");
		liDates.textContent = "Dates: " + reservation.dates;
		ulInformations.append(liDates);
		articleReservation.append(ulInformations);

		// Ajout de l'article dans le li
		liReservation.append(articleReservation);

		// Récupérer la liste #reservations
		const ulReservations = document.querySelector("#reservations");

		// Ajout de la réservation dans la liste
		ulReservations.append(liReservation);

		// Création du bouton
		const boutonSupprimer = document.createElement("button");
		boutonSupprimer.textContent = "Supprimer";
		boutonSupprimer.addEventListener("click", (e) => {
			reservations.splice(index, 1);
			afficher(reservations);
			console.log(reservations);
		});
		articleReservation.append(boutonSupprimer);
	});
};

afficher(reservations);