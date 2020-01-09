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
			}
		};
	}
})