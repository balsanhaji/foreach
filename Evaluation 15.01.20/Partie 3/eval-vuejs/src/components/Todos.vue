<template>
	<div id="todos">
		<ul>
			<!-- <li>{{nom}}</li> -->
			<li>
				<input type="checkbox" />
				<div class="todoText">
					<span class="desc">{{description}}</span><br />
					<span class="date">{{nouvelleDate}}</span>
				</div>
				<div class="todoEdit">
					<button @click="editer" class="edit"><font-awesome-icon icon="edit" size="2x" class="space" /></button>
					<button @click="supprimer" class="del"><font-awesome-icon icon="trash-alt" size="2x" /></button>
				</div>
			</li>
		</ul>

	</div>
</template>

<script>
	import axios from 'axios';

	export default {
		name: 'Todos',
		data() {
			return {
				newDate: new Date(),
				nouvelleDate: ""
			}
		},
		props: {
			nom: {
				type: String
			},
			description: {
				type: String
			},
			dateFin: {
				type: String
			},
			termine: {
				type: Boolean,
			},
			liste_id: {
				type: Number
			}
		},
		methods: {
			getDate() {
				this.newDate = new Date(this.dateFin);
				this.nouvelleDate = this.newDate.getDate()+' '+this.newDate.toLocaleString('default', { month: 'short' })+' '+this.newDate.getFullYear();

				return this.nouvelleDate;
			},
			editer() {
			},
			putTodo() {

			},
			supprimer() {
				this.$emit('delete-todo', {

				});
			}
		},
		created() {
			this.getDate();
		}
	}
</script>

<style>
	ul {
		margin:0;
		padding:0;
		list-style-type: none;
	}

	#todos {
		width: 70%;
		margin: 1em auto 0;
		padding: 10px;
		box-shadow: 0px 0px 10px -8px #000000;
	}

	#todos li {
		display: flex;
	}
		#todos .todoText {
			flex: 2;
			text-align: left;
			padding-left: 20px;
		}
			#todos .desc {
				font-size: 20px;
			}
			#todos .date {
				font-size: 11px;
			}

		#todos .todoEdit {
			display: flex;
			align-items: center;
		}
			#todos .space {
				margin-right: 20px;
			}

		#todos .edit {
			margin-right:10px;
		}
		#todos .del, #todos .edit {
			background: transparent;
			border:0;
			cursor: pointer;
		}
</style>