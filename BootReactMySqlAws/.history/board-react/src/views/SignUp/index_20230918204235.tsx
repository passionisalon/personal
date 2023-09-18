import axios from 'axios'
import React from 'react'

export default function SignUp() {

    const signUpHandler = ()=>{
        axios.post('http://localhost:4000/api/auth/signUp',data)
    }

  return (
    <div>
        <button onClick={()=>{}}>회원가입</button>
    </div>
  )
}
