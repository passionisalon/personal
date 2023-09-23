import React, { useEffect } from 'react'
import Navigation from '../../navigation'
import { Box } from '@mui/material'
import Authentication from '../../Authentication'
import BoardMain from '../../boardMain'
import { useCookies } from 'react-cookie'

export default function MainLayout() {

  const [cookies] =useCookies();

  const {user} = useUserStore();

  useEffect(
    ()=>{
      if
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
