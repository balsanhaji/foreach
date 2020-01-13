
<template>
	<div id="app">
		<table>
			<tr>
				<th>Titre</th>
				<th>Code</th>
				<th>Utilisateur</th>
				<th>Date d'expiration</th>
				<th>Commentaires</th>
				<th>Ajouter un commentaire</th>
			</tr>
				<BonsPlans
				v-for="plan in bonplans"
				:key="plan.id"
				:titre="plan.titre"
				:code="plan.code"
				:utilisateur="plan.utilisateur"
				:expireLe="plan.expireLe"
				:commentaires="plan.commentaires"
				></BonsPlans>
		</table>

		<br /><br />

		<AjoutDeBonPlan @ajouter-bon-plan="ajouterBonPlan"></AjoutDeBonPlan>
	</div>
</template>

<script>
	import axios from 'axios';
	import BonsPlans from './components/BonsPlans';
	import AjoutDeBonPlan from './components/AjoutDeBonPlan';
	import CommentairesBonsPlans from './components/CommentairesBonsPlans';

	export default {
		name: 'app',
		data() {
			return {
				bonplans: [],
			};
		},
		computed: {

		},
		components: {
			BonsPlans,
			AjoutDeBonPlan,
			CommentairesBonsPlans
		},
		methods: {
			ajouterBonPlan(bonPlan) {
				const bonPlanAAjouter = Object.assign({}, bonPlan);
				axios.post(`http://localhost:3000/bonplans`, bonPlanAAjouter)
					.then((reponse) => {
						this.bonplans.push(reponse.data);
					});
			},
			ajouterCommentaire(commentaire) {
				const commentaireAAjouter = Object.assign({}, commentaire);
				axios.patch(`http://localhost:3000/bonplans`, { commentaires : commentaireAAjouter })
					.then((reponse) => {
						this.bonplans.push(reponse.data);
					});
			}
		},
		created() {
			axios.get('http://localhost:3000/bonplans')
			.then((reponse) => {
				this.bonplans = reponse.data
			})
		}
	}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
