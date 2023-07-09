<template>
 <div v-for="(pros,index) in 원룸들" :key="pros.id">
  <img @click="모달창열렸니=true; 누른거 = index"  :src="pros.image" class="room-img" alt="룸">
  <h4 @click="모달창열렸니=true; 누른거 = index">{{pros.title}}</h4>
  <p @click="모달창열렸니=true; 누른거 = index">{{pros.price}}원</p>
</div>
</template>
<script>
    export default{
        name:'productCon',
        props:{
            원룸들 : Object,
        },
        data(){
            return{
            
            }
        },
        medhotds:{
        
        }
    }   // end export default
</script>
<style>

</style>