<!-- 팔로워 목록을 넣을 예정 -->


<template>
    <div style="padding : 10px">
        <h4>팔로워</h4>
        <input placeholder="?" @input="search($event.target.value)" />
        <div class="post-header" v-for="(a,i) in follower" :key="i">
            <div class="profile" :style="`background-image:url(${a.image})`"></div>
            <div class="profile-name">{{ a.name }}</div>
        </div>
    </div>
</template>

<script>

import axios from 'axios';
import {onMounted,ref} from 'vue';

// import {watch} from 'vue';
// import {computed} from 'vue';
// import {toRefs} from 'vue';
// import {useStore} from 'vuex';
// import { reactive } from 'vue';
export default{
    name : 'MyPageComponent',
    props : {
        one : Number,
    },
    setup(props){
        // Composition API써서 개발하려면 setup()안에 코드짜셈
        // setup()안에서 데이터도 생성, 조작할 수 있고, methods 만들 수 있고, hook도 걸 수 있음
        // 모든 데이터를 reference data type으로 감싸야 실시간 반영가능
        props;
        let follower = ref([]);
        let followerOriginal = ref([]);
        onMounted(()=>{
                axios.get('/follower.json').then((a)=>{
                follower.value = a.data;
                followerOriginal.value = a.data;
            })
        });

        function search(검색어){
            let newFollower = followerOriginal.value.filter((a)=>{
                return a.name.indexOf(검색어) != -1
            });
            follower.value = [...newFollower]
        }
        return {follower, search}


        // let test = reactive({name:'kim'});
        // test;
        // let {one} =  toRefs(props);
        // console.log(one.value);
        
        // let store = useStore();
        // console.log("store");
        // console.log(store.state.name);

        // watch(one,()=>{
            
        //     console.log(one.value);
        // });

        // let 결과 = computed(()=>{
        //     return follower.value.length;
        //     // Composition API에서 computed 사용법
        //     // computed(()=>{return 연산결과})
        // });
        // console.log("computed");
        // console.log(결과.value);
      


    },
    data(){
        return {

        }
    },
}
</script>
<!-- style scoped라고 되어져있으면 해당 vue에만 적용할 수 있다. -->
<style scoped>

</style>