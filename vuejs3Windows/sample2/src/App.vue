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
            <a class="nav-link active" aria-current="page" href="#"><router-link to="/">홈페이지</router-link></a>
            <a class="nav-link" href="#"><router-link to="/list">리스트페이지</router-link></a>
            <a class="nav-link" href="#">Pricing</a>
            <a class="nav-link disabled">Disabled</a>
          </div>
        </div>
      </div>
    </nav>

    <!-- <div>
      <h4>개발자의 블로그입니다.</h4>
      <p>Vue로 만들었음</p>
    </div> -->
    <router-link to="/">홈페이지</router-link>
    <br>
    <router-link to="/list">리스트페이지</router-link>
    <br>
    <div class="mt-4">
      <router-link to="/detail" v-bind:blogData="blogData">블로그글</router-link>
    </div>
    <router-view :blogData="blogData"></router-view>

    <!-- <ListComponent v-bind:blogData="blogData"/> -->

  </div>
</template>

<script>
import ListComponent from './components/ListComponent.vue'
import Home from './components/HomeComponent.vue'
import blog from './assets/blog.js'
export default {
  name: 'App',
  data(){
    return{
      blogData : blog,
    }
  },
  components: {
    // ListComponent:ListComponent,
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
