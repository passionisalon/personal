import React, { useEffect } from 'react'
import Navigation from '../../navigation'
import { Box } from '@mui/material'
import Authentication from '../../Authentication'
import BoardMain from '../../boardMain'

export default function MainLayout() {

  useEffect(
    ()=>{

    },[]
  );


  return (
    <>
        <Navigation />
        <Authentication />
        <BoardMain />
    </>
  )
}
