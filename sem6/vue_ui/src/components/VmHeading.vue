<template>
  <component :is="element">{{texte}}</component>
</template>

<script>
export default {
	name: 'VmHeading',
	props: ['texte', 'type'],
	computed: {
		element() {
			return `h${this.type}`
		}
	}
}
</script>

<style>

</style>