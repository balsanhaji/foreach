<template>
    <form @submit.prevent>
        <label>
            Utilisateur
            <input type="text" v-model="nouveauCommentaire.utilisateur" placeholder="utilisateur">
        </label>
        <label>
            Message
            <input type="text" v-model="nouveauCommentaire.message" placeholder="Message">
        </label>

		<br /><br />
        <button :disabled="!commentaireValide" @click="ajouter">Ajouter un commentaire</button>
    </form>
</template>

<script>
	export default {
		name: 'AjoutDeCommentaires',
		data() {
			return {
				nouveauCommentaire: {
					commentaires: [
						{
							id: undefined,
							utilisateur: "",
							message: ""
						}
					]
				}
			};
		},
		computed: {
			commentaireValide() {
				return this.nouveauCommentaire.utilisateur && this.nouveauCommentaire.message;
			}
		},
		methods: {
			ajouter() {
				this.$emit('ajouter-commentaire', {
					...this.nouveauCommentaire
				});
			}
		}
	}
</script>

<style>

</style>