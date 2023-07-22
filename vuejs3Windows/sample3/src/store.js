import{createStore} from 'vuex'

const store = createStore({
    state(){
        return{
            name : 'kim',
            age : 20,
            likes :30,
            좋아요눌렀니 : false,
        }
    },

// 데이터를 수정하는 방법 정의
// 수정하고 싶으면 store.js에 부탁
    mutations :{
        ChangeName(state){
            state.name = 'park'
        },
        increaseAge(state,payLoad){
            state.age += payLoad;
        },
        inputLikes(state){
            if(state.좋아요눌렀니==false){
                state.likes=state.likes+1;
                state.좋아요눌렀니=true;
            }else{
                state.likes=state.likes-1;
                state.좋아요눌렀니=false
            }
            
        }
    }
})

export default store;