import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import Guest from './Guest';
import User from './User';




function App() {

  const[islogin,setIslogin]=useState(false);

  const handlelogin=()=>setIslogin(true);
  const handlelogout=()=>setIslogin(false);


  return (
    <div style={{textAlign:'center'}}>
       {islogin? (
        <>
        <h1>Welcome back</h1>
        <button onClick={handlelogout}>Logout</button>
        <User/>
        </>
       ):(
        <>
        <h1>Please Sign up</h1>
        <button onClick={handlelogin}>Login</button>
        <Guest/>
        </>
       )}
    </div>
  );
}

export default App;
