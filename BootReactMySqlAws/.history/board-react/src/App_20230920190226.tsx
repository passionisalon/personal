import React,{useState,useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from "axios";
import SignUp from './views/Authentication/SignUp';
import Authentication from './views/Authentication';

export default function App() {

  return(
    <mainLayout />
    // <Authentication />
  );

  // const [connection, setConnection] = useState<string>('');
  // const connectionTest = ()=>{
  //   axios.get('http://localhost:4000/').then((response)=>{
  //     setConnection(response.data);
  //   }).catch((error)=>{
  //     setConnection(error.message);
  //     console.log(error);
  //   })
  // } // end connectionTest

  // useEffect(()=>{
  //   connectionTest();
  // },[]);

  // return (
  //   <div className="App">
  //     <header className="App-header">
  //       <img src={logo} className="App-logo" alt="logo" />
  //       {/* <p>{connection}</p> */}
  //     </header>
  //     <SignUp/>
  //   </div>
  // );
}


