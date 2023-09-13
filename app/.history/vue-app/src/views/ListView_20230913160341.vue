<template>
<div class="container mt-3">
    <h1 class="display-1 text-center">사용자 목록</h1>
    <div class="btn-group">
        <router-link to="/user/save" class="btn btn-primary">사용자 추가</router-link>
    </div>
    <table class="table table-hover mt-3">
        <thead class="table-dark">
            <tr>
                <th>이름</th>
                <th>이메일</th>
                <th>가입날짜</th>
            </tr>
        </thead>
        <tbody>
            <tr 
                class="cursor-pointer" 
                v-for="row in result" 
                v-bind:key="row.no" 
                v-on:click="$event => href(row)"
            >
                <td>{{ row.name }}</td>
                <td>{{ row.email }}</td>
                <td>{{ row.regDate }}</td>
            </tr>
            <!-- <tr class="cursor-pointer" onclick="location.href = '/user/findById';">
                <td>에브릴</td>
                <td>lavigne@shellfolder.com</td>
                <td>2023-02-27</td>
            </tr> -->
        </tbody>
    </table>
</div>
</template>

<script>
import axios from 'axios'
// import store from '@/store/index.js'
import store from '@/store/index.js'

export default{
    name : 'ListView',
    data(){
        return {
            result : [
                // {
                //     no : 1,
                //     name:'사용자',
                //     email:'user@email.com',
                //     regDate:'2023-03-24'
                // }
            ]
        }   // end return 
    },   // end data

    created(){
        console.log(store);
        this.getData();
    },  // end created
    methods: {
        getData(){
            axios
                // .post(process.env.VUE_APP_BASEURL + '/findAll')
                .post('http://localhost:8080/findAll')
                .then((response)=>{
                    console.log(response)
                    this.result = response.data.result
                }).catch((error)=>{
                    console.log(error)
                })
        },   // end getDate

        href(row){
            console.log('userInfo : ',row);
            // query를 통해서 데이터를 전송할 수 있지만 데이터가 노출될 수 있기 때문에 사용하지 않는다.
            // query > http://localhost:8080/user/findById/name=사용자&pwd=1 ....
            // this.$router.push({name:'SelectView', query: row})
            // params > http://localhost:8080/user/findById/사용자/1
            // index.js > path: '/user/findById/:name/:pwd'
            // this.$router.push({name:'SelectView',params:row})
            
            // store기능을 사용할 수 있다.
            // store를 사용하려면 vuex를 설치하여 사용하여야한다.
            // yan add vuex terminal에 명령
            // store 등록 store dir index.js 그리고 main.js
            store.commit('setUser',row)
            sessionStorage.setItem('setUser',this.base64(row));
            // console.log("aaa : ",this.base64(row));
            this.$router.push({name:'SelectView'})
        },
        base64(user){
            return window.btoa(encodeURIComponent(JSON.stringify(user)));
        },  // end base64
    },   // end methods

}   // export default
</script>

<style scoped>
    .cursor-pointer{
        cursor:pointer;
    }
</style>