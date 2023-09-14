import {createStore} from 'vuex'

export default createStore({
    state:{
        user:null,
    },  // end state
    mutations:{
        setUser(state,userData){
            state.user = userData;
        }
    }
})

createStore({
    state(){
        return{
            user:{}
        }
    },  // end state
    metations:{
        setUser(state,value){
            state.user = value
        }
    },  // end metation

})// end createStore