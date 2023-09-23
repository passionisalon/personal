import React, { useEffect, useState } from 'react'
import Navigation from '../../navigation'
import { Box } from '@mui/material'
import Authentication from '../../Authentication'
import BoardMain from '../../boardMain'
import { useCookies } from 'react-cookie'
import axios from 'axios'
import { useUserStore } from '../../../stores'

export default function MainLayout() {

  const [boardResponse,setBoardResponse] = useState<string>('');

  const [cookies] =useCookies();

  const {user} = useUserStore();

  const getBoard = async ()=>{
    await axios
      .get("http://localhost/api/board/")
      .then((response)=>{
        setBoardResponse(response.data);
      })
      .catch((error)=>'');
      
  }

  useEffect(
    ()=>{
      const token = cookies.token;
      if(token){
        getBoard(token);
      }
    },[user]
  );


  return (
    <>
        <Navigation />
        {boardResponse ? (<BoardMain />) : (<Authentication />)}
        
        
    </>
  )
}
