<!-- 
  글 목록페이지,
  상세페이지 만들 예정 페이지 2~3개정도 만들어오기

 -->

<template>
  <div>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
            <a class="nav-link" href="#">Features</a>
            <a class="nav-link" href="#">Pricing</a>
            <a class="nav-link disabled">Disabled</a>
          </div>
        </div>
      </div>
    </nav>
    <div>
      <h4>개발자의 블로그입니다.</h4>
      <p>Vue로 만들었음</p>
    </div>

    <ListComponent v-bind:blogData="blogData"/>

  </div>
</template>

<script>
import ListComponent from './components/ListComponent.vue'
import blog from './assets/blog.js'
export default {
  name: 'App',
  data(){
    return{
      blogData : blog,
    }
  },
  components: {
    ListComponent:ListComponent,
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
  /* margin-top: 60px; */
}
</style>
