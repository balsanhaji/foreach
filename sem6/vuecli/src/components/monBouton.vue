<template>
	<button :class="classe">{{titre}}</button>
</template>

<script>
	export default {
		name: 'monBouton',
		props: ['titre', 'classe']
	}
</script>

<style>
	.btn {
		background: linear-gradient(#4b4bc2, white, red, rebeccapurple);
		color:	#fff;
		width: 10em;
		height: 3em;
		font-weight: bold;
		border-radius: 6px;
		cursor: pointer;
		font-family: 'FreeSet';
		font-style: italic;
		text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
		font-size: large;
	}
</style>