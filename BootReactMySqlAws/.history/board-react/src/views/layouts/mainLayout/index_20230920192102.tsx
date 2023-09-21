import React from 'react'
import Navigation from '../../navigation'
import { Box } from '@mui/material'
import Authentication from '../../Authentication'

export default function MainLayout() {
  return (
    <>
        <Navigation />
        <Authentication />
    </>
  )
}
