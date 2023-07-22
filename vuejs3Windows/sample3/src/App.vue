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
      <li v-if="steps==1" @click="steps++">Next</li>
      <li v-if="steps==2" @click="PostPublish">Publish</li>
    </ul>
    <img src="./assets/logo.png" class="logo" />
  </div>

  <ContainerComponent @write="writePha = $event" v-bind:UploadImage="UploadImage" v-bind:steps="steps" v-bind:infodata="infodata"/>
  <button @click="moreHomework">더보기</button>
  <!-- 서버에서 추가 게시물을 가져옴 그걸 <post>로 보여줄것 -->

  <!-- <div class="sample-box">임시 박스</div> -->

  <!-- 이미지 업로드한 걸 HTML에 보여주려면? -->
  <!-- FileReader() 쓰거나 -->
  <!-- URL.createObjectURL() -->
  <div class="footer">
    <ul class="footer-button-plus">
      <!-- multiple = 복수의 파일들 선택 -->
      <!-- accept="image/*" 이미지 파일만 보겠다-->
      <input @change="upload" accept="image/*" type="file" id="file" class="inputfile" />
      <label for="file" class="input-plus">+</label>
    </ul>
  </div>

  <!-- 
  동적인 UI만드는 법
  1. UI현재 상태를 데이터로 만들기
  2. 상태에 따라 HTML이 어떻게 보일지
  -->

  <!-- <div v-if="step == 0">내용0</div>
  <div v-if="step == 1">내용1</div>
  <div v-if="step == 2">내용2</div>
  <button @click="step = 0">버튼0</button>
  <button @click="step = 1">버튼1</button>
  <button @click="step = 2">버튼2</button>
  <div style="margin-top : 500px;"></div> -->


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

// App.vue <- Conainer.Vue <- FilterBox.vue 로 이동을 custom event를 연단으로 사용해서 상위 컴포넌트로 옮길 수 있다.
// 하지만 mitt라는 라이브러리를 쓰면 단번에 가능해진다.

// 필터박스를 클릭 시 App.vue에 클릭한 필터명을 전달해보자
export default {
  name: 'App',
  data(){
    return{

      steps : 0,
      infodata : datas,
      moreCount:0,
      UploadImage:'',
      writePha:"",
      선택한필터 : '',
    }
  },
  // this.emitter을 수신하는 장소는 관례적으로 mounted이다.
  // 많이 사용하면 힘들다. 관리가 힘들어진다. 대체품으로 Vuex라는 것이 있다.
  mounted(){
    this.emitter.on('박스클릭함',(a)=>{
      this.선택한필터 = a;
    }); // end emitter
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
    // (방법1)FileReader()
    // 파일을 글자로 변환해줌
    // (방법2) URL.createObjectURL()
    // 이미지의 가상 URL을 생성해줌
    upload(e){
      let getFile = e.target.files;
      console.log("type : ",getFile[0].type);
      console.log(getFile[0]);
      let url = URL.createObjectURL(getFile[0]);
      console.log(url);
      this.UploadImage = url;
      this.steps++;
    },  // end upload()  
    PostPublish(){
      var myPost = {
        name: "Kim Hyun",
        userImage: "https://placeimg.com/100/100/arch",
        postImage:  this.UploadImage,
        likes:  36,
        date: "May 15",
        liked:  false,
        content: this.writePha,
        filter: this.선택한필터,
      };
      this.infodata.unshift(myPost);
      // 왼쪽의 Array에 자료를 넣어주는 기능 unshift
      this.steps = 0;
    },  // end PostPublish

  },
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
