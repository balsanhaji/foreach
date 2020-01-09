<template>
	<div id="app">
		<ComposantEnfant></ComposantEnfant>
		<monBouton :titre="leTitre" classe="btn"></monBouton>
		<br /><br />
		<MonInput :type="monType" :placeholder="monPlaceholder" />
	</div>
</template>

<script>
	import ComposantEnfant from './components/ComposantEnfant';
	import monBouton from './components/monBouton';
	import MonInput from './components/MonInput';

	export default {
		name: 'app',
		data() {
			return {
				leTitre: 'COLGATE',
				monType: 'text',
				monPlaceholder: 'HAHAHA'
			}
		},components: {
			ComposantEnfant,
			monBouton,
			MonInput
		}
	};
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