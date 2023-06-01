<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
  import Show from "./views/showprofile/Show.vue"
  import ProfileSubmit from "./views/studentprofile/ProfileSubmit.vue"
  import Login from "./views/login/Login.vue"
  export default {
    name: 'App',
    components: {
      Show,
      ProfileSubmit,
      Login,
    }
  }
</script>

<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
