<!-- watcher -->
<!-- 
    input에 문자를 입력하면 경고문을 띄우고 싶다.-> watcher를 쓰라. data를 감시하는 함수
 -->

<template>
    <div class="black-bg" v-if="모달창열렸니 == true">
        <div class="white-bg">
          <img :src="원룸들[누른거].image" class="room-img">
          <h4>{{원룸들[누른거].title}}</h4>
          <p>{{ 원룸들[누른거].content }}</p>
          <!-- <input @input="month=$event.target.value"> -->
          <!-- v-model은 위에것과 같다. 데이터값을 받는다. -->
          <input v-model="month">
          <!-- 이 친구는 조금더 큰 인풋이다. textarea -->
          <!-- <textarea v-model="month"></textarea> -->
          <!-- <select v-model="month"></select> -->
          <p>{{ month }}개월 선택함 : {{ 원룸들[누른거].price *month}}원</p>
        
          <button @click="closeModal">닫기</button>
          
        </div>
      </div>
</template>
<script>
    export default{
        name:'ModalCon',
        props:{
        // step2 받아온데이터 props로 설정하고 등록하기
        // 받아온 데이터명 : 데이터의 자료형
        // props받아온건 read-only
            원룸들 : Array,
            누른거 : Number,
            모달창열렸니 : Boolean,
        },
        // 애초에 Modal.vue에 데이터 만들면 되지 않는가?
        // 되긴하는데, 부모도 쓰는 데이터라면 부모컴포넌트에 데이터를 만들어 넣어라
        // 자식컴포넌트에서 부모컴포넌트에 데이터를 전송하는게 귀찮다.
        // 데이터를 만들 때엔 데이터사용하는 곳들 중 최상위 컴포넌트에 만들어라.
        data(){
            return{
                month:1,

            }
        },
        watch:{
            // watch는 안에 있는 데이터가 변할 때 마다 여기 있는 코드가 실행된다.
            // month 데이터가 변할 때마다 watcher도 실행된다.
            month(a){
                if(a>13){
                    alert("13이상 입력하지 마셈");
                }
            },


        },
        methods:{
          closeModal(){
            this.$emit('closeModal');
          }
            
        }
    }
</script>
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