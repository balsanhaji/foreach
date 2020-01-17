<template>
	<div id="app">
		<header>
			<h1>Mes Todos</h1>
		</header>

		<div id="up">
			<Listes :listes="listes" @get-selected="pload => getSelected(pload)" @change="changerTodos"></Listes>
			<div class="right">
				<input type="checkbox" /> Todos terminés
				<input type="checkbox" /> Todos en cours
			</div>
		</div>

		<br />
		<AjouterTodo @ajouter-todo="ajouterTodo" :listes="listes"></AjouterTodo>

		<br />
		<Todos
			v-for="(todo,index) in todos" :key="todo.id"
			:description="todo.description"
			:dateFin="todo.dateFin"
			:termine="todo.termine"
			:liste_id="todo.liste_id"
			@delete-todo="deleteTodo(index, todo.id)">
		</Todos>

		<br /><br />
		<button @click="show" class="openModal">Ajouter un todo</button>
	</div>
</template>

<script>
	import axios from 'axios';
	import Listes from './components/Listes';
	import Todos from './components/Todos';
	import AjouterTodo from './components/AjouterTodo';

	export default {
		name: 'app',
		data() {
			return {
				listes: [],
				todos: [],
				idSelect: 1
			};
		},
		components: {
			Listes,
			Todos,
			AjouterTodo
		},
		methods: {
			ajouterTodo(todo) {
				const todoAAjouter = Object.assign({}, todo);
				axios.post(`http://localhost:3000/todos`, todoAAjouter)
					.then((reponse) => {
						this.changerTodos();
					});
			},
			show() {
				this.$modal.show('hello-world');
			},
			deleteTodo(index, idTodo) {
				axios.delete(`http://localhost:3000/todos/${idTodo}`)
				.then(() => {
					this.todos.splice(index, 1)
				});
			},
			getSelected(pload) {
				console.log('select!: '+pload.newSelected)
				this.idSelect = pload.newSelected;
				this.changerTodos();
			},
			changerTodos() {
				axios.get(`http://localhost:3000/todos?liste_id=${this.idSelect}`)
				.then((reponse) => {
					this.todos = reponse.data
				});
			}
		},
		created() {
			axios.get('http://localhost:3000/listes')
			.then((reponse) => {
				this.listes = reponse.data
			});

			this.changerTodos();
		}
	}
</script>

<style>
	body {
		margin:0;
		padding:0;
	}

	#app {
		font-family: 'Muli', 'Avenir', Helvetica, Arial, sans-serif;
		-webkit-font-smoothing: antialiased;
		-moz-osx-font-smoothing: grayscale;
		text-align: center;
		color: #2c3e50;
		margin-top:0;
	}

	header {
		display: flex;
		height: 5em;
		margin-bottom: 5em;
		background:	#499ee9;
		color:	#fff;
		padding-left: 20px;
	}

	#up {
		width: 70%;
		margin: auto;
		text-align: left;
	}
		#up .right {
			float: right;
		}

	.openModal {
		height: 2em;
		background: #fff;
		box-shadow: 0px 0px 10px -8px #000;
		border: 1px solid;
		font-family: inherit;
		width: 14em;
		font-weight: bold;
		cursor: pointer;
	}
</style>
