import React from 'react'
import Navigation from '../../navigation'
import { Box } from '@mui/material'

export default function MainLayout() {
  return (
    <>
        <Navigation />
        <Box display='flex'> 
            <Box flex={1} display='flex' justifyContent='center' alignItems='center'>

            </Box>
            <Box flex={1} display='flex' justifyContent='center' alignItems='center'>

            </Box>
        </Box>
    </>
  )
}
