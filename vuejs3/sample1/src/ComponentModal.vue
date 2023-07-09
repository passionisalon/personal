<template>
    <div class="black-bg" v-if="모달창열렸니 == true">
        <div class="white-bg">
          <h4>{{원룸들[누른거].title}}</h4>
          <p>{{ 원룸들[누른거].price }}원</p>
          <button @click="modals">닫기</button>
          
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
                
            }
        },
        methods:{
        //     modals(){
        //         if(this.모달창열렸니==true){
        //         this.모달창열렸니 =false;
        //     }
        },
    }
</script>
<style>

</style>