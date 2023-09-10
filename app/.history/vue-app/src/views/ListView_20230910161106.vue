<template>
<div class="container mt-3">
    <h1 class="display-1 text-center">사용자 목록</h1>
    <div class="btn-group">
        <a href="/user/save" class="btn btn-primary">사용자 추가</a>
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
                onclick="location.href = '/user/findById';"
                v-on:click="href()"
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
        this.getData();
    },  // end created
    methods: {
        getData(){
            axios.post('http://localhost:8080/findAll')
                .then((response)=>{
                    console.log(response)
                    this.result = response.data.result
                }).catch((error)=>{
                    console.log(error)
                })
        }   // end getDate
    }   // end methods

}   // export default
</script>

<style scoped>
    .cursor-pointer{
        cursor:pointer;
    }
</style>