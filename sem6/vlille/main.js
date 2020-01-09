const app = new Vue({
	el: '#app',
	data: function() {
		return {
			stations: [],
			retraits: [],
			retrait: {
				station: "",
				abonné: {
					nom: "",
					prenom: "",
					numeroCarte: ""
				}
			}
		};
	},
	computed: {
		nomComplet() {
			return this.utilisateur.nom+' '+this.utilisateur.prenom;
		},
		isValide() {
			if(this.retrait.abonné.nom !== "" && this.retrait.abonné.prenom !== "" && this.retrait.abonné.numeroCarte !== "")
				return "Formulaire valide";
			else return false;
		}
	},
	methods: {
		validerFormulaire() {
			axios.post("http://localhost:3000/retraits", this.retrait);
		}
	},
	created: function() {
		axios.get('http://localhost:3000/stations')
			.then(resultat => {
				this.stations = resultat.data;
				this.retrait.station = this.stations[0].nom;
		});

		axios.get('http://localhost:3000/retraits')
			.then(resultat => {
				this.retraits = resultat.data;
		});
	}
});