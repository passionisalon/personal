<!-- 컴포넌트는 긴 HTML을 한 단어로 줄일 수 있는 문법이다 -->
<!-- Vue파일 import해오기 -->
<!-- components:{}에등록하기 -->
<!-- 사용하기 -->
<template>

  <ModalConponent/>

  <div class="menu">
    <!-- <a v-for="(prosss,index) in products" :key="prosss.id">{{prosss.name}} {{ index }}</a> -->
    <a v-for="(prosss) in menus" :key="prosss">{{prosss}} </a>
  </div>


 <DiscountComponent/>

 <div v-for="(pros,index) in 원룸들" :key="pros.id">
  <img @click="모달창열렸니=true; 누른거 = index"  :src="pros.image" class="room-img" alt="룸1">
  <h4 @click="모달창열렸니=true; 누른거 = index">{{pros.title}}</h4>
  <p @click="모달창열렸니=true; 누른거 = index">{{pros.price}}원</p>
</div>


  
</template>

<script>

import 작명 from './assets/oneroom.js';

import {apple,apple2} from './assets/oneroom.js';
apple,apple2;
작명;

import data from './assets/oneroom.js';
import DiscountC from './ComponentDiscount.vue';
import ModalC from './ComponentModal.vue';
export default {
  name: 'App',
  data(){
    return {
      // 데이터 보관함
      누른거 : 0,
      모달창열렸니 : false,
      singoCount : 0,
      singo : 0,
      sin : 0,
      menus :['Home','Shop','About'],
      products : [
                  {id : 'i1',name : '역삼동원룸',price:'60만원'},
                  {id : 'i2',name : '천호동원룸',price:'70만원'},
                  {id : 'i3',name : '마포구원룸',price:'80만원'}
                  ],
      원룸들 : data,
      스타일 : 'font-style : bold'
    }
  },
  methods:{

    modals(){
      if(this.모달창열렸니==true){
        this.모달창열렸니 =false;
      }
    }
  },
  components: {
    DiscountComponent : DiscountC,
    ModalConponent : ModalC,
  }
}
</script>
<!-- 동적 UI 만드는 법:
0.HTML CSS로 디자인해두셈(기본)
1.UI의 현재 상태를 데이터로 저장해둠
2.데이터에 따라 UI가 어떻게 보일지 작성
-->
<style>
body{
  margin:0;
}
div{
  box-sizing:border-box;
}
.black-bg{
  width:100%;
  height:100%;
  background: rgba(0,0,0,0.5);
  position:fixed;
  padding:20px;
}
.white-bg{
width:100%;
background:white;
border-radius:8px;
padding:20px;
}
.room-img{
  width:100%;
  margin-top:40px;
}
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

