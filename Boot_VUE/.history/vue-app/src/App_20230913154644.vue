<template>
  <!-- <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>  |
    <router-link to="/user">UserList</router-link>  |
    <router-link to="/user/findById">UserSelect</router-link> |
    <router-link to="/user/editById">UserUpdate</router-link> |
    <router-link to="/user/save">UserCreate</router-link> |
  </nav> -->
  <router-view/>
</template>
<script>
  export default{
    created(){
        const user = sessionStorage.getItem('setUser');
        // console.log("JSON : ",JSON.parse(user));

        if(user){
          console.log('사용자 정보가 있습니다.');
          console.log('user : ',user, this.base64(user));
          // this.$store.commit('setUser',JSON.parse(user));
        }

    }, // end created
    methods:{
      base64(user){
        return JSON.parse(decodeURIComponent(window.atob(user)));
      }, // end base64
    },  // end methods
  }
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
