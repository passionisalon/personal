<template>
    <div @click="meth" :class="필터 + ' filter-item'" :style="`background-image:url(${UploadImage})`"></div> 
</template>

<script>
export default{
    name : 'FilterBoxComponent',

    props:{
        UploadImage:String,
        필터:String,
    },
    methods:{
        meth(){
            console.log(this.필터);
        }
    }
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