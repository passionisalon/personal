import { Box, Card, CardContent, TextField } from '@mui/material'
import React from 'react'

export default function SignIn() {
  return (
    <Card>
        <CardContent>
            <Box>
                <TextField
                    fullWidth
                    label="이메일"
                    type="email"
                    variant="standard"
                    onChange={()=>{}}
                />
                <TextField
                    fullWidth
                    label="비밀번호"
                    type="password"
                    variant="standard"
                    onChange={()=>{}}
                />
            </Box>

        </CardContent>
    </Card>
  )
}
