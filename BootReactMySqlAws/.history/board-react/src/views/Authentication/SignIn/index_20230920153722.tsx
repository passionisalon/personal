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
                    onChange={(e)=>setUserEmail(e.target.value)}
                />
            </Box>

        </CardContent>
    </Card>
  )
}
