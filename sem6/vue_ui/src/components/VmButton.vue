<template>
	<button :class="{'button-outline' : outline, 'button-clear': clear}">{{texte}}</button>
</template>

<script>
export default {
	name: 'VmButton',
	props: {
		texte: {
			type: String
		},
		outline: {
			type: Boolean
		},
		clear: {
			type: Boolean
		}
	}
	// computed: {
	// 	element() {
	// 		return this.outline ? 'button-outline' : this.clear ? 'button-clear' : '';
	// 	}
	// }
}
</script>

<style>

</style>