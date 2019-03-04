<template>
  <div id="app">
    <!--span>{{this.$store.state.count}}</span>
    <button v-on:click="addone">仓库加一</button-->
      <router-view></router-view>
  </div>
</template>

<script>
import testc from "./components/HelloWorld.vue"
export default {
  name: 'App',
  created: function() {
      var test = this.$route.query.test;
      //this.getData(test);
      },
  methods:{
    addone: function () {
      this.$store.commit("increment");
    },
  },
}
</script>
<style>

#app
{
  /*font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: green;*/
}
</style>
