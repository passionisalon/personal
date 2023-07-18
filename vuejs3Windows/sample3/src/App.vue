<!-- 
 - 다른 곳에 서 쓸 것 같으면 컴포넌트
 - 라워로 나눌 페이지도 컴포넌트
 - 혹은 HTML이 너무 길어서 복잡하면 컴포넌트
 -->
 <!-- 숙제
1. App.vue에 인스타 데이터 저장
2. Post.Vue에 {{데이터바인딩}}
-->
<template>
  <div class="header">
    <ul class="header-button-left">
      <li>Cancel</li>
    </ul>
    <ul class="header-button-right">
      <li>Next</li>
    </ul>
    <img src="./assets/logo.png" class="logo" />
  </div>

  <ContainerComponent v-bind:infodata="infodata"/>
  <button @click="moreHomework">더보기</button>
  <!-- 서버에서 추가 게시물을 가져옴 그걸 <post>로 보여줄것 -->

  <!-- <div class="sample-box">임시 박스</div> -->
  <div class="footer">
    <ul class="footer-button-plus">
      <input type="file" id="file" class="inputfile" />
      <label for="file" class="input-plus">+</label>
    </ul>
  </div>
</template>

<script>
import datas from './assets/Data.js';

import ContainerComponent from './components/ContainerComponent';

import axios from 'axios';
// axios.get();
// axios.post();

// ajax요청하려면
// 1. axios라이브러리쓰던가 (대부분 이거 사용함)
// 2. 기본 fetch함수를 쓰던가 (최신브라우저에서만 사용할 수 있다.)
// npm install axios



export default {
  name: 'App',
  data(){
    return{
      infodata : datas,
      moreCount:0,
    }
  },
  components: {
    ContainerComponent : ContainerComponent,

  },
  methods:{
    more(){
      // axios.get('URL!!');
      // ajax 요청 공식
      // axios.get('https://codingapple1.github.io/vue/more0.json').then(function(result){
      //   // 요청성공시 실행 할 코드~
      //   console.log(result.data);
      // });
      axios.get('https://codingapple1.github.io/vue/more0.json').then((result)=>{
        console.log(result.data);
        // 람다식은 밖의 this를 그대로 사용할 수 있지만,
        // function으로 정의된 함수는 함수내로 this를 재정의하게 된다.
        this.infodata.push(result.data);
        // push함수는 해당 데이터의 끝에 데이터를 추가해주는 기능을 가지고 있다.
      })  //  end axios.get~
    }, // end more

    // axios.post('URL',{name:'kim'}).then().catch()
    // 성공했을 시 then으로 실패시 catch로

    // axios.post('URL',{name:'kim'}).then().catch((err)=>{
      // console.log(err);
    // })


      // 과제
    moreHomework(){
      if(this.moreCount==0){
        axios.get('https://codingapple1.github.io/vue/more0.json')
        .then((result)=>{
          this.moreCount++;
          console.log('11111 : ',this.moreCount);
          console.log(result.data);
          this.infodata.push(result.data);
        })
        .catch((err)=>{
          console.log(err);
        });
      }else{
        axios.get('https://codingapple1.github.io/vue/more1.json').then((result)=>{
          this.moreCount++;
          console.log('22222++ : ',this.moreCount);
          console.log(result.data);
          this.infodata.push(result.data);
        }).catch((err)=>{
          console.log(err);
        });
      }
    },  // end moreHomework
      


  }
}
</script>

<style>
@import './style.css';
body {
  margin: 0;
}

ul {
  padding: 5px;
  list-style-type: none;
}

.logo {
  width: 22px;
  margin: auto;
  display: block;
  position: absolute;
  left: 0;
  right: 0;
  top: 13px;
}

.header {
  width: 100%;
  height: 40px;
  background-color: white;
  padding-bottom: 8px;
  position: sticky;
  top: 0;
}

.header-button-left {
  color: skyblue;
  float: left;
  width: 50px;
  padding-left: 20px;
  cursor: pointer;
  margin-top: 10px;
}

.header-button-right {
  color: skyblue;
  float: right;
  width: 50px;
  cursor: pointer;
  margin-top: 10px;
}

.footer {
  width: 100%;
  position: sticky;
  bottom: 0;
  padding-bottom: 10px;
  background-color: white;
}

.footer-button-plus {
  width: 80px;
  margin: auto;
  text-align: center;
  cursor: pointer;
  font-size: 24px;
  padding-top: 12px;
}

.sample-box {
  width: 100%;
  height: 600px;
  background-color: bisque;
}

.inputfile {
  display: none;
}

.input-plus {
  cursor: pointer;
}

#app {
  box-sizing: border-box;
  font-family: "consolas";
  margin-top: 60px;
  width: 100%;
  max-width: 460px;
  margin: auto;
  position: relative;
  border-right: 1px solid #eee;
  border-left: 1px solid #eee;
}</style>
