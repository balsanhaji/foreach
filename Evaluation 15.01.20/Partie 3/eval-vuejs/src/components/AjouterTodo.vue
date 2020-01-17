<template>
	<modal name="hello-world" height="auto" :scrollable="true">
		<h1>Ajouter un todo</h1>
		<form @submit.prevent>
			<p>
				<input type="text" v-model="nouveauTodo.nom" placeholder="Nom">
			</p>
			<p>
				<textarea v-model="nouveauTodo.description" placeholder="Description"></textarea>
			</p>
			<p>
			<input type="text" v-model="nouveauTodo.dateFin" placeholder="Date de fin">
			</p>
			<p>
				<Listes :listes="listes" @get-selected="pload => getSelected(pload)"></Listes>
			</p>
			<p>
				<button :disabled="!todoValide" @click="ajouter">Ajouter</button>
			</p>
		</form>
	</modal>
</template>

<script>
	import Listes from './Listes';

	export default {
		name: 'AjouterTodo',
		props: ['listes'],
		data() {
			return {
				nouveauTodo: {
					id: undefined,
					nom: "",
					description: "",
					dateFin: "",
					termine: false,
					liste_id: 0
				}
			};
		},
		components: {
			Listes
		},
		computed: {
			todoValide() {
				return this.nouveauTodo.nom && this.nouveauTodo.description && this.nouveauTodo.dateFin;
			}
		},
		methods: {
			ajouter() {
				this.$emit('ajouter-todo', {
					...this.nouveauTodo
				});
				this.$modal.hide('hello-world');
			},

			getSelected(pload) {
				this.nouveauTodo.liste_id = pload.newSelected;
				console.log(pload.newSelected);
			}
		}
	}
</script>

<style>
	form {
		display: flex;
		flex-direction: column;
		width: 90%;
		margin: auto;
		text-align: center;
	}
	h1 {
		text-align: center;
	}
	form input {
		height: 2em;
		padding-left: 5px;
		border: 0;
		width: 100%;
		box-shadow: 0px 0px 15px -10px #000;
		font-family: inherit;
	}
	form textarea {
		height: 5em;
		padding-left: 5px;
		border: 0;
		width: 100%;
		box-shadow: 0px 0px 15px -10px #000;
		padding:5px 0 0 5px;
		font-family: inherit;
	}
	form button {
		height: 2em;
		background: #fff;
		box-shadow: 0px 0px 10px -8px #000;
		border: 1px solid;
		font-family: inherit;
		width: 14em;
		font-weight: bold;
		cursor: pointer;
	}
</style>