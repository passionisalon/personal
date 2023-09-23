import React, { useEffect, useState } from 'react'
import Navigation from '../../navigation'
import { Box } from '@mui/material'
import Authentication from '../../Authentication'
import BoardMain from '../../boardMain'
import { useCookies } from 'react-cookie'
import axios from 'axios'
import { useUserStore } from '../../../stores'

export default function MainLayout() {

  const [boardresponse,setBoardResponse] = useState<string>('');

  const [cookies] =useCookies();

  const {user} = useUserStore();

  const getBoard = async ()=>{
    await axios
      .get("http://localhost/api/board/")
      .catch((error)=>'');
      setBoardResponse(response.data);
  }

  useEffect(
    ()=>{
      const token = cookies.token;
      if(token){
        
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
