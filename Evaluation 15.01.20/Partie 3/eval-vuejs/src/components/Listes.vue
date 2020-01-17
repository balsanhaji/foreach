<template>
	<div id="listes">
		<select v-model="selected" class="classic">
			<option disabled>Choisir une liste</option>
			<option v-for="liste in listes" :key="liste.id" :value="liste.id" @click="getSelected">
				{{liste.nom}}
			</option>
		</select>
	</div>
</template>

<script>
	import axios from 'axios';

	export default {
		name: 'Listes',
		data() {
			return {
				selected: 0
			}
		},
		props: {
			listes: {
				type: Array
			}
		},
		methods: {
			getSelected() {
				console.log('selected:'+this.selected)
				this.$emit('get-selected', {
					newSelected: this.selected
				});
			}
		}

	}
</script>

<style>
	#listes {
		width: 40%;
		float: left;
	}

	#listes select {
		display: inline-block;
		font: inherit;
		line-height: 1.5em;
		margin: 0;
		-webkit-box-sizing: border-box;
		box-sizing: border-box;
		-moz-appearance: none;
		width: 100%;
		padding-left: 5px;
		font-size: 13px;
		box-shadow: 0px 0px 10px -8px #000000;
		border: 1px;
	}

	#listes select.classic {
		background-image: linear-gradient(45deg, transparent 50%, #fff 50%), linear-gradient(135deg, #fff 50%, transparent 50%), linear-gradient(to right, #2c3e50,
		#2c3e50);
		background-position: calc(100% - 10px) calc(.7em - 1px), calc(100% - 5px) calc(.7em - 1px), 100% 0;
		background-size: 4px 4px, 5px 5px, 1.5em 1.5em;
		background-repeat: no-repeat;
		cursor: pointer;
	}
</style>