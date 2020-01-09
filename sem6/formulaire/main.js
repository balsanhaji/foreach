const app = new Vue({
	el: '#app',
	data: function() {
		return {
			utilisateur: {
				nom: '',
				prenom: '',
				souhaiteEtreNotifie: false,
				genre: '',
				situation: '',
				age: 7
			},
			listeUtilisateurs: []
		};
	},
	computed: {
		nomComplet() {
			return this.utilisateur.nom+' '+this.utilisateur.prenom;
		},
		isValide() {
			if(this.utilisateur.situation !== "" && this.utilisateur.genre !== "")
				return true;
			else return false;
		}
	},
	methods: {
		validerFormulaire() {
			const clone = Object.assign({}, this.utilisateur);
			this.listeUtilisateurs.push(clone);
		}
	},
	created: function() {
		
	}
});