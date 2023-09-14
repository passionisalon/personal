<template>
  <div class="home">
    <!-- yarn serve --port 8800 -->
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <a href="/user">사용자목록</a>
    <button @click="getData">데이터 호출</button>
  </div>
</template>

<script>
// @ is an alias to /src

// cors(Cross Origin Resource Sharing)
// 특정 교차 도메인 간(cross-domain) 요청,
// 특히 Ajax 요청은 동일-출처 보안 정책에 의해 기본적으로 금지

// 해결방법 특정 교차 도메인 간(cross-domain) 허용 요청 방법
// 리소스 서비스 서버에서 특정 교차 도메인 등록
// 요청하는 도메인 서버쪽 Proxy 설정으로 우회 접속

import axios from 'axios'

const uForm = {
  no : 1 , 
  name : '테스트',
  email : 'test@gmail.com', 
  pwd : '1234', gender:true
};

const params = {
  'params' : {no : 1}
}

export default{
  name: 'HomeView',
  methods:{
    getData(){
      // axios.get('http://localhost:8080/')
      // axios.get('/api')
      // axios.get('/')  // 자기 자신의 주소를 부르게됨
      // axios.post("http://localhost:8080/findAll")
      // axios.post("http://localhost:8080/editById",uForm)
      axios.delete("http://localhost:8080/delete",params)
        .then((response)=>{
          // console.log("response Data : ",response);
          console.log(response);
        })
        .catch((error)=>{
          // console.log("error : ",error);
          console.log(error);
        })  // end axios
    }// end getData
  },
}

</script>
<style scoped>
a{
  color:black;
  text-decoration: none;
  font-weight:bold;
  font-size:1.5rem;
}
</style>