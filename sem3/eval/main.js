const titreJeu = document.querySelector("#titre-du-jeu");

const header = document.querySelector("header");

const souhaitJeu = document.querySelector("#compte-utilisateurs-souhaitant-le-jeu");

const noteJeu = document.querySelector("#note-jeu");

const achatsJeu = document.querySelector("#compte-utilisateurs-ayant-le-jeu");

const typeJeu = document.querySelector("#type-du-jeu");

const publicJeu = document.querySelector("#public-cible");

const disponibiliteJeu = document.querySelector("#date-de-disponibilite");

const succesJeu = document.querySelector("#success ul");

let getTitle;

axios.get("http://localhost:3000/jeux").then((resultats) => {
	let res = resultats.data[0];
	getTitle = res.nom;

	// titre <title>
	document.title = "MAETS - "+res.nom;

	// titre h1
	titreJeu.textContent = res.nom;
	
	// images
	let imgs = res.images;
	imgs.forEach((image) => {
		let elDiv = document.createElement("div");
		elDiv.setAttribute("div", "images-du-jeu");
		let elImg = document.createElement("img");
		elImg.setAttribute("src", image);
		elImg.setAttribute("width", "200");
		elImg.setAttribute("height", "200");

		header.append(elDiv);
		elDiv.append(elImg);
	});

	// nombre d'utilisateus souhaitant le jeu
	souhaitJeu.textContent = `Utilisateurs souhaitant le jeu : ${res.note.votants}`;

	// note du jeu
	noteJeu.textContent = `Note moyenne : ${res.note.moyenne}`;

	// nombre d'utilisateus ayant le jeu
	achatsJeu.textContent = `Utilisateurs ayant le jeu : ${res.achats}`;

	// infos jeu
	typeJeu.textContent = res.types;
	publicJeu.textContent = res.public;
	let sortie = new Date(res.sortie * 1000);
	disponibiliteJeu.textContent = `${sortie.getDate()}/${sortie.getMonth()}/${sortie.getFullYear()}`;

	// succès disponibles
	let sccess = res.succes;
	sccess.forEach((suc) => {
		let elLi = document.createElement("li");
		elLi.classList.add("tag");
		elLi.classList.add("is-link");
		elLi.append(`Succès 1 - ${suc.score} pts`);

		succesJeu.append(elLi);
	});
});

const ajout = document.querySelector("#ajouter");
const ajoutCollection = document.querySelector("#ajout-collection");

ajout.addEventListener("click", (e) => {
	e.preventDefault();

	const ajoutJeu = {
		nom: `${getTitle}`
	};

	axios.post("http://localhost:3000/collection", ajoutJeu);
});