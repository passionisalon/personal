import { Box, Button, Card, CardActions, CardContent, CardHeader, TextField, Typography } from '@mui/material'
import axios from 'axios';
import React, { useState } from 'react'
import {useCookies} from "react-cookie";
import { useUserStore } from '../../../stores';

export default function SignIn() {
    const [userEmail,setUserEmail] = useState<string>('');
    const [userPassword,setUserPassword] = useState<string>('');

    const [cookies, setCookies] = useCookies();

    const {user,setUser} = useUserStore();

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
                const expires = new Date();
                expires.setMilliseconds(expires.getMilliseconds()+exprTime);

                setCookies('token',token, { expires } );
                // alert("cookies.token : "+cookies.token);
                setUser(user);
            })
            .catch((error)=>{
                alert('로그인에 실패했습니다.');
                console.log(error);
                console.log("로그인에 실패했습니다.!!!!");
            });

    };
  return (
    <Card sx={{minWidth:275,maxWidth:"50vw"}}>
        {/* {user!=null && (<>{user.userNickname}</>)} */}
        <CardHeader title={'로그인'} />
        <CardContent>
            <Box height={'50vh'}>
                
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
            <Box>
                <Button fullWidth onClick={()=>signInHandler()} variant="contained">
                    로그인
                </Button>
            </Box>
            <Box>
                
            </Box>
            <Typography>신규 사용자이신가요?</Typography>
        </CardActions>
    </Card>
  )
}
