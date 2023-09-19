import axios from 'axios'
import React, { useState } from 'react'


import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Button } from '@mui/material';

export default function SignUp() {

    const [requestResult, setRequestResult] = useState<string>('');

    const [userEmail, setUserEmail] = useState<string>('');

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
    <Card sx={{ minWidth: 275, maxWidth : "50vw" }}>
        <CardContent>
            <Box>
                <TextField fullWidth label="이메일 주소" type="email" variant="standard" />
                <TextField fullWidth label="비밀번호" type="password" variant="standard" />
                <TextField fullWidth label="비밀번호 확인" type="password" variant="standard" />
                <TextField fullWidth label="닉네임" variant="standard" />
                <TextField fullWidth label="휴대폰 번호" variant="standard" />
                <TextField fullWidth label="주소" variant="standard" />
                <TextField fullWidth label="상세주소" variant="standard" />
            </Box>
        </CardContent>
        <CardActions>
        <Button fullWidth onClick={()=>signUpHandler()} variant="contained">회원가입</Button>
            
        </CardActions>
    </Card>
   
  )
}
