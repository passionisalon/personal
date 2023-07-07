<template>

  <div class="black-bg" v-if="모달창열렸니 == true">
    <div class="white-bg">
      <h4>상세페이지임</h4>
      <p>상세페이지 내용임</p>
      <button @click="modals">닫기</button>
    </div>
  </div>

  <div class="menu">
    <!-- <a v-for="(prosss,index) in products" :key="prosss.id">{{prosss.name}} {{ index }}</a> -->
    <a v-for="(prosss) in menus" :key="prosss">{{prosss}} </a>
  </div>

  <div>
    <img src="../src/assets/room0.jpg" class="room-img" alt="룸1">
    <h4 @click="모달창열렸니 = true">{{ products[0].name }}</h4>
    <p>{{products[0].price}}</p>
    <!-- <button v-on:click="singo">허위매물신고</button><span>신고수 : 0</span> -->
    <button @click="increase">허위매물신고</button><span>신고수 : {{ singoCount }}</span>
    <!-- <button @mouseover="singoCount += 1">허위매물신고</button><span>신고수 : {{ singoCount }}</span> -->
  </div>
  <div>
    <img src="../src/assets/room1.jpg" class="room-img"  alt="">
    <h4>{{ products[1].name }}</h4>
    <p>{{products[1].price}}</p>
    <input type="button" @click="inc" value="허위매물신고"><span>신고수 : {{ singo }}</span>
    <!-- <button :click="inc">허위매물신고</button><span>신고수 : {{ singo }}</span> -->
  </div>
  <div>
    <img src="../src/assets/room2.jpg"  class="room-img"  alt="">
    <h4>{{ products[2].name }}</h4>
    <p>{{products[2].price}}</p>
    <button @click="incres">허위매물신고</button><span>신고수 : {{ sin }}</span>
  </div>
</template>

<script>
export default {
  name: 'App',
  data(){
    return {
      // 데이터 보관함
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

      스타일 : 'font-style : bold'
    }
  },
  methods:{
    increase(){
      this.singoCount++;
    },
    inc(){
      this.singo++;
    },
    incres(){
      this.sin++;
    },
    modals(){
      if(this.모달창열렸니==true){
        this.모달창열렸니 =false;
      }
    }
  },
  components: {

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
