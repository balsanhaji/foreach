<template>
	<input :type="type" :placeholder="placeholder" />
</template>

<script>
	export default {
		name: 'MonInput',
		props: ['type', 'placeholder']
	}
</script>

<style>
	input {
		height: 3em;
		border-right: 0;
		border-left: 0;
		padding-left: 10px;
	}
</style>