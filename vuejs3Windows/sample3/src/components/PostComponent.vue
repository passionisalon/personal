<template>
    <div class="post">
        <div class="post-header">
            
            <div class="profile" :style="{backgroundImage : `url(${pros.userImage})`}"></div>
            <!-- <span class="profile-name">{{ pros.name }}</span> -->
            <span class="profile-name"><slot></slot></span>
        </div>
        <div  @click="$store.commit('inputLikes')" class="post-body" :style="{backgroundImage : `url(${pros.postImage})`}"></div>
        <div class="post-content">
            <p>{{$store.state.likes}}</p>
            <p><strong>{{ pros.name }}</strong> {{ pros.content }}</p>
            <p class="date">{{ pros.date }}</p>
        </div>
    </div>
</template>

<script>
export default {
    props:{
        pros:Object,
    },
    data(){
        return{
           
        }
    },
    

}
</script>

<style>
.post {
    width: 100%;
}

.profile {
    background-image: url("https://picsum.photos/100?random=0");
    width: 30px;
    height: 30px;
    background-size: 100%;
    border-radius: 50%;
    float: left;
}

.profile-name {
    display: block;
    float: left;
    padding-left: 10px;
    padding-top: 7px;
    font-size: 14px;
}

.post-header {
    height: 30px;
    padding: 10px;
}

.post-body {
    background-image: url("https://picsum.photos/600?random=0");
    height: 450px;
    background-position: center;
    background-size: cover;
}

.post-content {
    padding-left: 15px;
    padding-right: 15px;
    font-size: 14px;
}

.date {
    font-size: 11px;
    color: grey;
    margin-top: -8px;
}</style>