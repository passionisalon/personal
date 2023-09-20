import { Box, Button, Card, CardActions, CardContent, TextField } from '@mui/material'
import axios from 'axios';
import React, { useState } from 'react'

export default function SignIn() {
    const [userEmail,setUserEmail] = useState<string>('');
    const [userPassword,setUserPassword] = useState<string>('');

    const signInHandler = ()=>{
        if(userEmail.length === 0 || userPassword.length ===0){
            alert('이메일과 비밀번호를 입력하세요.');
            return;
        }

        const data = {
            userEmail,
            userPassword,
        };

        axios
            .post("http://localhost:4000/api/auth/signIn",data)
            .then((response)=>{
                console.log("response : ",response.data);
                const responseData = response.data;
                console.log("checkResult : ",responseData.result);
                if(!responseData.result){
                    console.log('로그인에 실패했습니다.');
                    return;
                }
                const {token,exprTime,user} = responseData.data;
            })
            .catch((error)=>{
                // alert('로그인에 실패했습니다.');
                console.log(error);
                console.log("로그인에 실패했습니다.!!!!");
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
                    onChange={(e)=>{setUserEmail(e.target.value)}}
                />
                <TextField
                    fullWidth
                    label="비밀번호"
                    type="password"
                    variant="standard"
                    onChange={(e)=>{setUserPassword(e.target.value)}}
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
