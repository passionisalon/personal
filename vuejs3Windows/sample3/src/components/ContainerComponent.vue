<template>
    <div v-for="(pros,index) in infodata" :key="index">
        <PostComponent v-bind:pros="pros"/>
    </div>
    <hr>
    <!-- <div>
        <PostComponent v-bind:pros="infodata[0]"/>
        <PostComponent v-bind:pros="infodata[1]"/>
        <PostComponent v-bind:pros="infodata[2]"/>
    </div> -->
</template>

<script>
import PostComponent from './PostComponent.vue';
export default {
    props:{
        infodata:Object,
    },
    components:{
        PostComponent : PostComponent,
    }
}
</script>

<style>

</style>