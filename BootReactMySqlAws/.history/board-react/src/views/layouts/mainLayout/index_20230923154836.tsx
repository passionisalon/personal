import React, { useEffect } from 'react'
import Navigation from '../../navigation'
import { Box } from '@mui/material'
import Authentication from '../../Authentication'
import BoardMain from '../../boardMain'
import { useCookies } from 'react-cookie'
import axios from 'axios'
import { useUserStore } from '../../../stores'

export default function MainLayout() {

  const [cookies] =useCookies();

  const {user} = useUserStore();

  useEffect(
    ()=>{
      const token = cookies.token;
      if(token){
        axios
          .get("http://localhost/api/board/")
          .catch((error)=>null);
      }
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
