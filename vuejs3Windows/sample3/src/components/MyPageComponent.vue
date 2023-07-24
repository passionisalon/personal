<!-- 팔로워 목록을 넣을 예정 -->


<template>
    <div style="padding : 10px">
        <h4>팔로워</h4>
        <input placeholder="?" />
        <div class="post-header" v-for="(a,i) in follower" :key="i">
            <div class="profile" :style="`background-image:url(${a.image})`"></div>
            <div class="profile-name">{{ a.name }}</div>
        </div>
    </div>
</template>

<script>

import axios from 'axios';
import {onMounted,ref} from 'vue';
export default{
    name : 'MyPageComponent',
    setup(){
        // Composition API써서 개발하려면 setup()안에 코드짜셈
        // setup()안에서 데이터도 생성, 조작할 수 있고, methods 만들 수 있고, hook도 걸 수 있음
        // 모든 데이터를 reference data type으로 감싸야 실시간 반영가능
        let follower = ref([]);
        onMounted(()=>{
                axios.get('/follower.json').then((a)=>{
                follower.value = a.data;
            });
        })

        

        

        return {follower}
    },
    data(){
        return {

        }
    },
}
</script>
<style>

</style>