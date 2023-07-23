import{createStore} from 'vuex'
import axios from 'axios'

const store = createStore({
    state(){
        return{
            name : 'kim',
            age : 20,
            likes :30,
            좋아요눌렀니 : false,
            more : {},
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
            
        },
        setMore(state,data){
            state.more=data;
        },
    },
    actions:{
        // ajax하는 곳 또는 오래 걸리는 작업들
        getData(context){
            axios.get('https://codingapple1.github.io/vue/more0.json').then((a)=>{
                console.log(a.data);
                context.commit('setMore',a.data);

            });
        },
    },
})

export default store;