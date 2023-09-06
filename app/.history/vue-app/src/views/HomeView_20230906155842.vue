<template>
  <div class="home">
    <!-- yarn serve --port 8800 -->
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <a href="/user">사용자목록</a>
    <button @click="getData">데이터 호출</button>
  </div>
</template>

<script>
// @ is an alias to /src
export default{
  name: 'HomeView',
  methods:{
    getData(){
      axios.get('http://localhost:8080/')
        .then((response)=>{
          console.log("response Data : ",response);
        })
        .catch((error)=>{
          console.log("error : ",error);
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