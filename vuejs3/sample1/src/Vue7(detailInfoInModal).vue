<template>
    <div class="black-bg" v-if="모달창열렸니==true">
        <div class="white-bg">
            <h4>{{ 원룸들[누른거].title }}</h4>
            <p>{{ 원룸들[누른거].price }}원</p>
            <button @click="modals">닫기</button>
        </div>
    </div>

    <div class="menu">
        <a v-for="(pross) in menus" :key="pross">{{ pross }}</a>
    </div>

    <div v-for="(pros,index) in 원룸들" :key="pros.id">
        <img @click="모달창열렸니=true;누른거=index" :src="pros.image" class="room-ing" alt="'pros.title'+index">
        <h4 @click="모달창열렸니=true;누른거=index">{{ pros.title }}</h4>
        <p @click="모달창열럈니=true;누른거=index">{{ pros.price }}원</p>
    </div>
</template>
<script>
    import data from './assets/oneroom.js';
    export default{
        name:'Vue7(detailInfoInModal)',
        data(){
            return{
                누른거 : 0,
        모달창열렸니 : false,
        menus:['Home','Shop','About'],
        원룸들 : data,
        스타일 : 'font-style : bold'
            }
        },
       
    
        methods:{
           modals(){
               if(this.모달창열렸니==true) {
                  this.모달창열렸니 = false;
               }
           }
        },
        components:{

        }
    }; // end export default
</script>
<!-- 
동적 UI만드는법 :<style>
0. HTML CSS로 디자인해두기(기본)
1. UI의 현재 상태를 데이터로 저장해둠
2. 데이ㅓ에 따라 UI가 어떻게 보일지 작성
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
        background:rgba(0,0,0,0.5);
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
        margin-top:40px
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
        background:darkslateblue;
        padding:15px;
        border-radius:10px;
        }
        .menu a{
            color:white;
            padding:10px;
        }

</style>