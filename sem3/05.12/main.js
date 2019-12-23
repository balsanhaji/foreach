const titre = document.querySelector("h1");

const fonction = () => {
	titre.textContent = "Bonsoir";
};

// setTimeout(fonction, 1000);

const inc = document.querySelector("#increment");
const demarrer = document.querySelector("#demarrer");
const stop = document.querySelector("#stop");

let i = 0;

const compteur = () => {
	i++;
	inc.textContent = i;
};

let interval;

demarrer.addEventListener("click", () => {
	clearInterval(interval);
	interval = setInterval(compteur,1000);
});
stop.addEventListener("click", () => {
	clearInterval(interval);
});

/* promesses */

const cafe = true;
const preparerLeCafe = new Promise((resolve, reject) => {
	if(cafe)
		reject(reject);
	else
		resolve(resolve);
});

preparerLeCafe.then(() => {
	console.log("Réparer la machine");
}).catch(() => {
	console.log("Servir le café");	
});

const essence = -1;
const demarrerVoiture = new Promise((resolve, reject) => {
	if(essence > 0)
		resolve("Démarrer la voiture");
	else
		reject("Impossible de démarrer la voiture");
});

demarrerVoiture.then((valeurRetournee) => {
	console.log(valeurRetournee);
}).catch((erreurRetournee) => {
	console.log(erreurRetournee);	
});


const attendre = new Promise((resolve) => {
	setTimeout(resolve, 5000);
});

attendre.then(() => {
	console.log("Fini !");
});

/* ======================= */

// Récupérer la liste #reservations
const ulReservations = document.querySelector("#reservations")
const viderAffichage = () => {
	ulReservations.innerHTML = ''
}

let res;

const afficher = (reservationsAAfficher) => {
	viderAffichage();
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
		// Ajout des informations
		articleReservation.append(ulInformations);
		// Creation du bouton
		const boutonSupprimer = document.createElement("button");
		boutonSupprimer.textContent = "Supprimer";
		boutonSupprimer.addEventListener("click", (e) => {
			// Supprimer l'élement du tableau (js)

			axios.delete(`http://localhost:3000/reservations/${reservation.id}`);
			
			// Afficher les réservations
			// viderAffichage();
			afficherGet();
		})
		articleReservation.append(boutonSupprimer);
		// Ajout de l'article dans le li
		liReservation.append(articleReservation);
		// Ajout de la réservation dans la liste
		ulReservations.append(liReservation);
	});
};

// let afficherGet = () => {
// 	axios.get("http://localhost:3000/reservations").then((resultats) => {
// 		res = resultats.data;
// 		afficher(res);
// 	});
// }

// afficherGet();

// const form = document.querySelector("#ajouter-une-reservation");

// form.addEventListener("submit", (e) => {
// 	e.preventDefault();

// 	const newReservation = {
// 		nom:	document.querySelector("#nom").value,
// 		nombre: Number(document.querySelector("#adultes").value),
// 		dates:	document.querySelector("#dates").value
// 	};

// 	axios.post("http://localhost:3000/reservations", newReservation).then(() => {
// 		afficherGet();
// 	 });
// });

/* ============================ */

const today = new Date();
document.querySelector("#today").textContent = today.getDate()+"/"+(today.getMonth()+1)+"/"+today.getFullYear();


// const city = document.querySelector("#city");
// const country = document.querySelector("#country");
// const desc = document.querySelector("#desc");
// const temp = document.querySelector("#temp");
// const icon = document.querySelector("#icon");

function kToC(kelvin) 
{
	var kTemp = kelvin;
	var kToCel = kTemp-273.15;
	return kToCel;
}

let getCity = "lille";

let getDatasVille = (e) => {
	axios.get(`http://api.openweathermap.org/data/2.5/weather?q=${e}&units=metric&lang=fr&appid=3c62f84366098487d2c7fe1ac262c64a`).then((resultats) => {
		let e = resultats.data;
		console.log(e);

		city.textContent = e.name;
		country.textContent = e.sys.country;
		temp.textContent = Math.trunc(e.main.temp)+"° C";
		desc.textContent = e.weather[0].description;
		wind.textContent = e.wind.speed;
		
		document.querySelector("#wicon").setAttribute(`src`, `http://openweathermap.org/img/wn/${e.weather[0].icon}@2x.png`);
	});
};

getDatasVille(getCity);

const formVille = document.querySelector("#actualiser-ville");

formVille.addEventListener("submit", (e) => {
	e.preventDefault();

	const newVille = document.querySelector("#ville").value;

	getDatasVille(newVille.toLowerCase());
});