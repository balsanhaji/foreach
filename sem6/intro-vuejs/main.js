const app = new Vue({
	el: '#app',
	data: function() {
		return {
			titre: 'Mon application...',
			mesClasses: 'gros-titre',
			boutonDesactive: false,
			sourceDeLimage:'https://www.uniconexed.org/wp-content/uploads/2017/05/canstockphoto75383057-happy-new-year-2020-770x544.jpg',
			afficherMessage: true,
			genre: ['femme', 'homme'],
			formes: [
				{id: 0, nom:'Pathé DIOP'},
				{id: 1, nom:'Bilal AL SANHAJI'}
			],
			adresse: {
				rue: 'Faubourg d\'Arras',
				numero: 59,
				ville: {
					codePostal: 59000,
					nom: 'Fâches-Thumesnil'
				}
			}
		};
	}
})