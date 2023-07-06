<template>

    <div class="menu">
      <!-- <a v-for="(prosss,index) in products" :key="prosss.id">{{prosss.name}} {{ index }}</a> -->
      <a v-for="(prosss) in menus" :key="prosss">{{prosss}} </a>
    </div>
  
    <div>
      <h4>{{ products[0].name }}</h4>
      <p>{{products[0].price}}</p>
      <!-- <button v-on:click="singo">허위매물신고</button><span>신고수 : 0</span> -->
      <button @click="increase">허위매물신고</button><span>신고수 : {{ singoCount }}</span>
      <!-- <button @mouseover="singoCount += 1">허위매물신고</button><span>신고수 : {{ singoCount }}</span> -->
    </div>
    <div>
      <h4>{{ products[1].name }}</h4>
      <p>{{products[1].price}}</p>
    </div>
    <div>
      <h4>{{ products[2].name }}</h4>
      <p>{{products[2].price}}</p>
    </div>
  </template>
  
  <script>
  export default {
    name: 'App',
    data(){
      return {
        // 데이터 보관함
        singoCount : 0,
        menus :['Home','Shop','About'],
        products : [
                    {id : 'i1',name : '역삼동원룸',price:'60만원'},
                    {id : 'i2',name : '천호동원룸',price:'70만원'},
                    {id : 'i3',name : '마포구원룸',price:'80만원'}
                    ],
  
        스타일 : 'font-style : bold'
      }
    },
    methods:{
      increase(){
        this.singoCount++;
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
  