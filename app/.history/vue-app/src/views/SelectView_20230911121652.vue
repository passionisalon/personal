<template>
    <div class="container mt-3">
        <h1 class="display-1 text-center">사용자 정보</h1>
          <form>
            <div class="mb-3 mt-3">
              <label for="name" class="form-label">이름:</label>
              <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name" readonly="readonly" v-model="result.name">
            </div>
            <div class="mb-3 mt-3">
              <label for="email" class="form-label">이메일:</label>
              <input type="email" class="form-control" id="email" placeholder="이메일를 입력하세요." name="email" readonly="readonly" v-model="result.email">
            </div>
            <div class="mb-3">
              <label for="pwd" class="form-label">비밀번호:</label>
              <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요." name="pwd" readonly="readonly" v-model="result.pwd">
            </div>
              <div class="d-flex">
                <div class="p-2 flex-fill" v-if="result.gender">
                    <div class="form-check">
                      <input type="radio" class="form-check-input" id="radio1" name="optradio" v-bind:value="true" checked v-model="result.gender"/>남성
                      <label class="form-check-label" for="radio1"></label>
                  </div>
                </div>
                <div class="p-2 flex-fill" v-else>
                    <div class="form-check">
                      <input type="radio" class="form-check-input" id="radio2" name="optradio" v-bind:value="false" checked v-model="result.gender"/>>여성
                      <label class="form-check-label" for="radio2"></label>
                  </div>
                </div>
              </div>
          </form>
          <div class="d-flex">
            <div class="p-2 flex-fill d-grid">
                <button type="button" class="btn btn-primary" @click="edit">수정</button>
            </div>
            <div class="p-2 flex-fill d-grid">
              <button type="button" class="btn btn-primary" @click="del">삭제</button>
            </div>
            <div class="p-2 flex-fill d-grid">
              <button type="button" class="btn btn-primary" @click="cancel">취소</button>
            </div>cancel
          </div>
      </div>
</template>
<script>
  import axios from 'axios'
  export default{
    name: 'SelectView',
    data(){
      return{
        result:{}
      }
    },
    created(){
      console.log("this.$route : ",this.$route);
      console.log("this.$store : ",this.$store.state.user);
      this.result = this.$store.state.user;
    }, // end created()
    methods:{
      edit(){
          this.$router.push({name : 'UpdateView'})
      },
      del(){
        const params = {params : { no: this.result.no}};
        axios
          .delete('http://localhost:8080/delete',params)
          .then((response)=>{
            if(response.data.state){
              this.cancel();
            }else{
              alert(response.data.message);
            } // end if-else
          }) 
          .catch((error)=>console.log(error))
      },
      cancel(){
        this.$store.commit('setUser',{});
        this.$router.push({name:'ListView'})
      },
    },
  } // end export default
</script>