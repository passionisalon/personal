import { Box, Button, Card, CardActions, CardContent, TextField } from '@mui/material'
import React, { useState } from 'react'

export default function SignIn() {
    const [email,setEmail] = useState<string>('');
    const [password,setPassword] = useState<string>('');

    const signInHandler = ()=>{
        if(email.length === 0 || password.length ===0){
            alert('이메일과 비밀번호를 입력하세요.');
        }
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
