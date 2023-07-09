<!-- props -->
<!-- 데이터는 한 곳에 보관함 그리고 필요하면 가져다 씀 -->
<!-- 자식컴포넌트가 부모가 가진 테이터를 쓰려면 -->
<!-- props로 데이터를 전송해야한다. -->
<!-- 방법 -->
<!-- 데이터를 보낸다 -->
<!-- 등록한다 -->
<!-- 사용한다. -->
<template>

  <!-- 자식컴포넌트 -->
  <!-- <ModalConponent v-bind:데이터이름="데이터이름"/> -->
  <!-- step1 밑에 데이터를 골라서 보내준다. -->
  <ModalConponent :원룸들="원룸들" :누른거="누른거" :모달창열렸니="모달창열렸니"/>
  

  <div class="menu">
    <a v-for="(prosss) in menus" :key="prosss">{{prosss}} </a>
  </div>


 <DiscountComponent/>

 <!-- <div v-for="(pros,index) in 원룸들" :key="pros.id">
  <img @click="모달창열렸니=true; 누른거 = index"  :src="pros.image" class="room-img" alt="룸1">
  <h4 @click="모달창열렸니=true; 누른거 = index">{{pros.title}}</h4>
  <p @click="모달창열렸니=true; 누른거 = index">{{pros.price}}원</p>
</div> -->

<ProcutComponent v-bind:원룸들="원룸들" :누룬거="누른거"/>

  
</template>

<script>

import 작명 from './assets/oneroom.js';

import {apple,apple2} from './assets/oneroom.js';
apple,apple2;
작명;

import data from './assets/oneroom.js';
import DiscountC from './ComponentDiscount.vue';
import ModalC from './ComponentModal.vue';
import ProductC from './ComponentProduct.vue';
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
    ProcutComponent : ProductC,
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

