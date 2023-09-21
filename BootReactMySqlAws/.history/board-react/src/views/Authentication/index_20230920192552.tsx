import React, { useState } from 'react'
import SignUp from './SignUp'
import SignIn from './SignIn'
import { Box } from '@mui/material';

export default function Authentication() {
  const [authView,setAuthView] = useState<string>('signIn')
  return (
    <>
      <Box display='flex' height="100vh">
        <Box 
          flex={1} 
          display='flex' 
          justifyContent='center' 
          alignItems='center'>

        </Box>
        <Box 
          flex={1} 
          display='flex' 
          justifyContent='center' 
          alignItems='center'
          >
            {authView ? () : ()}
          <SignUp />
          <SignIn />
        </Box>
      </Box>
    </>

  );
}
