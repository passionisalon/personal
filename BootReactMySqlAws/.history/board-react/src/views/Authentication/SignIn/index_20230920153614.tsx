import { Card, CardContent } from '@mui/material'
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
                />
            </Box>

        </CardContent>
    </Card>
  )
}
