<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  methods: {
    isLogin() {
      const username = Cookies.get("username")
      if (username == null || username === '') return false;
      return true
    }
  }
}
</script>

<style>
@import url(./assets/iconfont/material-icons.css);
html,body,#app{
  height: 100%;
}
</style>
