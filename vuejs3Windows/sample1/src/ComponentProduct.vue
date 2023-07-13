<template>
   <div>
        <img :src="oneRoom.image" class="room-img">
        <h4 @click="openModal">{{ oneRoom.title }}</h4>
        <p>{{ oneRoom.price }}원</p>
    </div>
  </template>
  
  <script>
  export default {
    name: 'productCon',
    props: {
      oneRoom: Object,
    },
    data() {
      return {};
    },
    methods: {
      openModal() {
        this.$emit('openModal', this.oneRoom.id);
      },
    },
  };
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