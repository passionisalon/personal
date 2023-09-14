import {createStore} from 'vuex'

export default createStore({
    state:{
        user:{}
    },  // end state
    mutations:{
        setUser(state,userData){
            state.user = userData;
        },
    },  // end mutations
    actions:{},
    getters:{},
})

// createStore({
//     state(){
//         return{
//             user:{}
//         }
//     },  // end state
//     metations:{
//         setUser(state,value){
//             state.user = value
//         }
//     },  // end metation

// })// end createStore