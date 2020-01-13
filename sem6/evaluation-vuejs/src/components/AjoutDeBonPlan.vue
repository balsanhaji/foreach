<template>
    <form @submit.prevent>
        <label>
            Titre
            <input type="text" v-model="nouveauBonPlan.titre" placeholder="Titre">
        </label>
        <label>
            Nom d'utilisateur
            <input type="text" v-model="nouveauBonPlan.utilisateur" placeholder="Nom d'utilisateur">
        </label>
        <label>
            Code
            <input type="text" v-model="nouveauBonPlan.code" placeholder="Code">
        </label>
        <label>
            Date d'expiration
            <input type="text" v-model="nouveauBonPlan.expireLe" placeholder="Date d'expiration">
        </label>
        <label>
            URL de l'image
            <input type="text" v-model="nouveauBonPlan.image" placeholder="URL de l'image">
        </label>

		<br /><br />
        <button :disabled="!bonPlanValide" @click="ajouter">Ajouter un bon plan</button>
    </form>
</template>

<script>
	export default {
		name: 'AjoutDeBonPlan',
		data() {
			return {
				nouveauBonPlan: {
					id: undefined,
					titre: "",
					image: "",
					temperature: "",
					expireLe: "",
					code: "",
					utilisateur: "",
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
			bonPlanValide() {
				return this.nouveauBonPlan.titre && this.nouveauBonPlan.utilisateur && this.nouveauBonPlan.code && this.nouveauBonPlan.expireLe;
			}
		},
		methods: {
			ajouter() {
				this.$emit('ajouter-bon-plan', {
					...this.nouveauBonPlan
				});
			}
		}
	}
</script>

<style>

</style>