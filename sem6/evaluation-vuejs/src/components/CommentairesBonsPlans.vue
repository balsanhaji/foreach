<template>
	<ul>
		<li>{{utilisateur}}</li>
		<li>{{message}}</li>
	</ul>
</template>

<script>
	export default {
		name: 'CommentairesBonsPlans',
		props: {
			utilisateur: {
				type: String,
			},
			message: {
				type: String
			}
		}
	}
</script>

<style>

</style>