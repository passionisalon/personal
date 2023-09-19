import axios from 'axios'
import React, { useState } from 'react'

import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';

export default function SignUp() {

    const [requestResult, setRequestResult] = useState<string>('');

    const signUpHandler = ()=>{
        const data = {
            userEmail : "power1234@gmail.com",
            userPassword : "qwer1234",
            userPasswordCheck : "qwer1234",
            userNickname : "john",
            userPhoneNumber : "010-1111-1111",
            userAddress : "한국 서울시",
            userAddressDetail : "강남구"
        }
        axios.post('http://localhost:4000/api/auth/signUp',data)
        .then((response)=>{
            setRequestResult('Success!!');
        })
        .catch((error)=>{
            setRequestResult('Failed!!');
        })
    }

  return (
    <div>
        <TextField id="standard-basic" label="Standard" variant="standard" />
        <h3>{requestResult}</h3>
        <button onClick={()=>signUpHandler()}>회원가입</button>
    </div>
  )
}
