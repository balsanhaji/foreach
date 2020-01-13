<template>
	<tr>
		<td>{{titre}}</td>
		<td>{{code}}</td>
		<td>{{utilisateur}}</td>
		<td>{{expireLe}}</td>
		<td>
			<CommentairesBonsPlans v-for="commentaire in commentaires" 
				:key="commentaire.id"
				:utilisateur="commentaire.utilisateur"
				:message="commentaire.message"
			></CommentairesBonsPlans>
		</td>
		<td>
			<AjoutDeCommentaires @ajouter-commentaires="ajouterCommentaire"></AjoutDeCommentaires>
		</td>
	</tr>
</template>

<script>
	import axios from 'axios';
	import CommentairesBonsPlans from './CommentairesBonsPlans';
	import AjoutDeCommentaires from './AjoutDeCommentaires';

	export default {
		name: 'BonsPlans',
		props: {
			titre: {
				type: String
			},
			code: {
				type: String
			},
			utilisateur: {
				type: String
			},
			expireLe: {
				type: String,
			},
			commentaires: {
				type: Array
			}
		},
		components: {
			CommentairesBonsPlans,
			AjoutDeCommentaires
		},
		methods: {
			ajouterCommentaire(commentaire) {
				const commentaireAAjouter = Object.assign({}, commentaire);
				axios.patch(`http://localhost:3000/bonplans`, { commentaires : commentaireAAjouter })
					.then((reponse) => {
						this.bonplans.push(reponse.data);
					});
			}
		}
	}
</script>

<style>
	table {
		width: 70%;
		margin: auto;
	}

	table, th, td {
		border: 1px solid;
		border-collapse: collapse;
		padding: 10px;
	}
</style>