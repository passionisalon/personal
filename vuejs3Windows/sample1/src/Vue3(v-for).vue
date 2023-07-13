<template>

    <div class="menu">
      <!-- <a v-for="(prosss,index) in products" :key="prosss.id">{{prosss.name}} {{ index }}</a> -->
      <a v-for="(prosss) in menus" :key="prosss">{{prosss}} </a>
    </div>
  
    <div v-for='item in products' :key='item.id'>
      <h4 class="" :style='스타일'>{{item.name}}</h4>
      <p>{{ item.price }}</p>
    </div>
  </template>
  
  <script>
  export default {
    name: 'App',
    data(){
      return {
        // 데이터 보관함
        menus :['Home','Shop','About'],
        products : [
                    {id : 'i1',name : '역삼동원룸',price:'60만원'},
                    {id : 'i2',name : '천호동원룸',price:'70만원'},
                    {id : 'i3',name : '마포구원룸',price:'80만원'}
                    ],
  
        스타일 : 'font-style : bold'
      }
    },
    components: {
  
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
  .menu{
    background: darkslateblue;
    padding:15px;
    border-radius:5px;
  }
  .menu a{
    color:white;
    padding: 10px;
  }
  </style>
  