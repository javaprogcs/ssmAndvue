<template>
    <div id="app">
        <h1>任务列表</h1>
        <div>
            <input v-model="todo.name" placeholder="name"></input>
            <input v-model="todo.detail" placeholder="detail"></input>
     
            <button @click="submit">提交</button>
        </div>

        <ul>
            <li v-for="todo in todos">
                {{todo.name}} / {{todo.detail}}
            </li>
        </ul>
    </div>
</template>

<script>
 export default {
     name: 'app',
     data() {
         return {
             todos: [],
             todo: { name: '', detail: '' }
         }
     },
     methods: {
         submit() {
             console.log(this.todo);
             fetch('http://localhost:8080/todo', {
                 method: 'post',
                 body: JSON.stringify(this.todo)
             }).then(resp => resp.json())
               .then(data => {
                   this.todos.push(this.todo);
               });
         }
     },
     created () {

         fetch('http://localhost:8888/todo',{method:"get"})
             .then(resp => resp.json())
             .then(data => {
                 console.log(data);
                 this.todos = data
             });
     }
 }
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
