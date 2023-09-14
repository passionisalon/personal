<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <a href="/user">사용자목록</a>
  </div>
</template>

<script>
// @ is an alias to /src
export default{
  name: 'HomeView',
  methods:{
    getData(){
      axios.get('http://localhost:8080/')
        .then(()=>{
        })  // end axios
    }// end getData
  },
}

</script>
<style scoped>
a{
  color:black;
  text-decoration: none;
  font-weight:bold;
  font-size:1.5rem;
}
</style>