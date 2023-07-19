<!-- slot으로 부모-> 자식 데이터 전송 가능 -->

<template>
    <!-- <div @click="meth" :class="필터 + ' filter-item'" :style="`background-image:url(${UploadImage})`"></div>  -->
    <div :class="필터" class="filter-item" :style="`background-image:url(${UploadImage})`">
        <slot></slot>
        <!-- <slot name="a"></slot> -->
        <!-- <slot name="b"></slot> -->
        <!-- <slot :msg="msg"></slot> -->
    </div>
</template>

<script>
export default{
    name : 'FilterBoxComponent',
    date(){
        return{
            // 임시데이터
            msg:'hello',
        }   // end return
    },
    props:{
        UploadImage:String,
        필터:String,
    },
    methods:{
      
    },
}
</script>

<style>
.filter-item {
  width: 100px;
  height: 100px;
  margin: 10px 10px 10px auto;
  padding: 8px;
  display: inline-block;
  color : white;
  background-size: cover;
  background-position : center;
}
</style>