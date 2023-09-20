import { Box, Button, Card, CardActions, CardContent, TextField } from '@mui/material'
import axios from 'axios';
import React, { useState } from 'react'

export default function SignIn() {
    const [email,setEmail] = useState<string>('');
    const [password,setPassword] = useState<string>('');

    const signInHandler = ()=>{
        if(email.length === 0 || password.length ===0){
            alert('이메일과 비밀번호를 입력하세요.');
            return;
        }

        const data = {
            email,
            password
        };

        axios
            .post("http://localhost:4000/api/auth/signIn",data)
            .then((response)=>{
                console.log("response : ",response.data);
                const responseData = response.data;
                if(responseData.result === false){
                    alert('로그인에 실패했습니다.');
                    return;
                }
                
            })
            .catch((error)=>{
                alert('로그인에 실패했습니다.');
            });

    };
  return (
    <Card>
        <CardContent>
            <Box>
                <TextField
                    fullWidth
                    label="이메일"
                    type="email"
                    variant="standard"
                    onChange={(e)=>{setEmail(e.target.value)}}
                />
                <TextField
                    fullWidth
                    label="비밀번호"
                    type="password"
                    variant="standard"
                    onChange={(e)=>{setPassword(e.target.value)}}
                />
            </Box>

        </CardContent>
        <CardActions>
            <Button fullWidth onClick={()=>signInHandler()} variant="contained">
                로그인
            </Button>
        </CardActions>
    </Card>
  )
}
