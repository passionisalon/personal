import { Box, Button, Card, CardActions, CardContent, CardHeader, TextField, Typography } from '@mui/material'
import axios from 'axios';
import React, { useState } from 'react'
import { useCookies } from "react-cookie";
import { useUserStore } from '../../../stores';
import { signInApi } from '../../../apis';

interface Props{
    setAuthView : (authView : boolean)=>void,
}

export default function SignIn(props: Props) {
    const [userEmail, setUserEmail] = useState<string>('');
    const [userPassword, setUserPassword] = useState<string>('');

    const [cookies, setCookies] = useCookies();

    const { user, setUser } = useUserStore();

    const { setAuthView } = props;

    const signInHandler = async () => {
        if (userEmail.length === 0 || userPassword.length === 0) {
            alert('이메일과 비밀번호를 입력하세요.');
            return;
        }

        const data = {
            userEmail,
            userPassword,
        };

        const signInResponse = await signInApi(data)

        if(!signInResponse){
            alert("로그인에 실패했습니다.");
        }

        axios
            .post("http://localhost:4000/api/auth/signIn", data)
            .then((response) => {
                console.log("response : ", response.data);
                const responseData = response.data;
                console.log("checkResult : ", responseData.result);
                if (!responseData.result) {
                    console.log('로그인에 실패했습니다.');
                    return;
                }
                const { token, exprTime, user } = responseData.data;
                const expires = new Date();
                expires.setMilliseconds(expires.getMilliseconds() + exprTime);

                setCookies('token', token, { expires });
                // alert("cookies.token : "+cookies.token);
                setUser(user);
            })
            .catch((error) => {
                alert('로그인에 실패했습니다.');
                console.log(error);
                console.log("로그인에 실패했습니다.!!!!");
            });
    };
    return (
        <Card sx={{ minWidth: 275, maxWidth: "50vw" , padding: 5 }}>
            {/* {user!=null && (<>{user.userNickname}</>)} */}
            <Box>
                <Typography variant='h5'>로그인</Typography>
            </Box>
            <Box height={'50vh'}>

                <TextField
                    fullWidth
                    label="이메일"
                    type="email"
                    variant="standard"
                    onChange={(e) => { setUserEmail(e.target.value) }}
                />
                <TextField
                    fullWidth
                    label="비밀번호"
                    type="password"
                    variant="standard"
                    onChange={(e) => { setUserPassword(e.target.value) }}
                />
            </Box>

            <Box component='div'>
                <Button fullWidth onClick={() => signInHandler()} variant="contained">
                    로그인
                </Button>
            </Box>
            <Box component='div' display='flex' mt={2}>
                <Typography >신규 사용자이신가요?</Typography>
                <Typography fontWeight={800} ml={1} onClick={()=>setAuthView(true)}>회원가입</Typography>
            </Box>


        </Card>
    )
}
