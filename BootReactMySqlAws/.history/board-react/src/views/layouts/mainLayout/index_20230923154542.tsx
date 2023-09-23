import React, { useEffect } from 'react'
import Navigation from '../../navigation'
import { Box } from '@mui/material'
import Authentication from '../../Authentication'
import BoardMain from '../../boardMain'

export default function MainLayout() {

  const {user} = useUserStore();

  useEffect(
    ()=>{

    },[user]
  );


  return (
    <>
        <Navigation />
        <Authentication />
        <BoardMain />
    </>
  )
}
