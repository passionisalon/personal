<template>
    <img alt="Vue logo" src="./assets/logo.png">
    <div>
      
      <h4 class="" :style='스타일'>{{products[0]}}</h4>
      <!-- <h4 class="red" :style="스타일">xx 원룸</h4> -->
      <p>{{price1}}만원</p>
    </div>
    <div>
      <h4 class="" :style='스타일'>{{products[1]}}</h4>
      <p>가격은 아무거나</p>
    </div>
    <div>
      <h4 class="" :style='스타일'>{{products[2]}}</h4>
      <p>가격은 아무거나</p>
    </div>
  </template>
  
  <script>
  export default {
    name: 'App',
    data(){
      return {
        // 데이터 보관함
        products : ['역삼동원룸','천호동원룸','마포구원룸'],
        price1 : 60,
        price2 : 70,
        logo : '원룸샵',
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
  </style>
  