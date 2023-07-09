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
        name:'ModalCon'
    }
</script>
<style>

</style>