<template>
    <div class="container mt-3">
        <h1 class="display-1 text-center">사용자 수정</h1>
          <form>
            <div class="mb-3 mt-3">
              <label for="name" class="form-label">이름:</label>
              <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name" autocomplete="off" v-model="result.name">
            </div>
            <div class="mb-3 mt-3">
              <label for="email" class="form-label">이메일:</label>
              <input type="email" class="form-control" id="email" placeholder="이메일를 입력하세요." name="email" autocomplete="off" readonly  v-model="result.email">
            </div>
            <div class="mb-3">
              <label for="pwd" class="form-label">비밀번호:</label>
              <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요." name="pwd" autocomplete="off" v-model="result.pwd">
            </div>
              <div class="d-flex">
                <div class="p-2 flex-fill">
                    <div class="form-check">
                      <input type="radio" class="form-check-input" id="radio1" name="gender" v-bind:value="true" v-model="result.gender"/>남성
                      <label class="form-check-label" for="radio1"></label>
                  </div>
                </div>
                <div class="p-2 flex-fill">
                    <div class="form-check">
                      <input type="radio" class="form-check-input" id="radio2" name="gender" v-bind:value="false" v-model="result.gender">여성
                      <label class="form-check-label" for="radio2"></label>
                  </div>
                </div>
              </div>
          </form>
          <div class="d-flex">
            <div class="p-2 flex-fill d-grid">
              <button type="button" class="btn btn-primary" @click="save">저장</button>
            </div>
            <div class="p-2 flex-fill d-grid">
              <button type="button" class="btn btn-primary" @click="cancel">취소</button>
            </div>
          </div>
      </div>
</template>

<script>
import axios from 'axios'
export default{
  name : 'UpdateView',
  data(){
    return{
      result:{}
    }
  },
  created(){
    if(this.$store.state.user){
      this.result = this.$store.state.user
    }
    
  },
  methods:{
    save(){
      axios
        .post('http://localhost:8080/editById',this.result)
        .then((response)=>{
          console.log('response : ',response);
          if(response.data.state){
              this.$store.commit('setUser',this.result);
              sessionStorage.setItem('setUser',JSON.stringify(this.result));
              this.cancel();
            }else{
              alert(response.data.message);
            } // end if-else
        })
        .catch((error)=>console.log(error))
    },  //end save
    cancel(){
      this.$router.push({name:'SelectView'})
    }, // end cancel
  }

}

</script>
