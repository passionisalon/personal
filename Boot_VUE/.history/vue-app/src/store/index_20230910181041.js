import {createStore} from 'vuex'

export default createStore({

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