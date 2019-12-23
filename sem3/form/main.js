const nom = document.querySelector("#nom");
const age = document.querySelector("#age");
const checkbox = document.querySelector("#checkbox");
const pets = document.querySelector("#pet-select");
const submit = document.querySelector("form");

// nom.addEventListener("keyup", (e) => {
// 	console.log(e.target.value);
// });

// age.addEventListener("input", (e) => {
// 	console.log(e.target.value);
// });

// nom.addEventListener("focus", (e) => {
// 	console.log("Focus OK");
// });

// nom.addEventListener("blur", (e) => {
// 	console.log("Focus perdu");
// });

// checkbox.addEventListener("input", (e) => {
// 	console.log("s'abonner", e.target.checked);
// });

// pets.addEventListener("input", (e) => {
// 	console.log("pet: ", e.target.value);
// });

// submit.addEventListener("submit", (e) => {
// 	e.preventDefault();

// 	const datas = {
// 		nom:	nom.value,
// 		age:	age.value,
// 		abonner:checkbox.checked,
// 		pet:	pets.value
// 	}

// 	console.log(datas.nom, datas.age, datas.abonner, datas.pet);
// })

/* vinyls */

const form = document.querySelector("#ajouter-un-vinyl");
const titre = document.querySelector("#titre");
const prix = document.querySelector("#prix");

const vinyls = [
	{
		nom: "Whatever People Say ...",
		prix: 12.5
	}, 
	{
		nom: "Prequelle",
		prix: 24
	}
];

form.addEventListener("submit", (e) => {
	e.preventDefault();

	const datasVinyl = {
		titre:	titre.value,
		prix:	prix.value
	}

	vinyls.push(datasVinyl);
})

console.log(vinyls);

vinyls.forEach((vinyl, i) => {
	j = i+1;
	console.log(i,j);
	document.querySelector(`.vinyl:nth-child(${j}) h2`).append(vinyl.nom);
	document.querySelector(`.vinyl:nth-child(${j}) .prix`).append(vinyl.prix);
});