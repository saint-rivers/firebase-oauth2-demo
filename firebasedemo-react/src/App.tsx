import { useState } from 'react'
import './App.css'
import { signInWithEmailAndPassword } from 'firebase/auth'
// @ts-ignore
import { auth } from '../firebase'
import axios from 'axios';

function App() {

  function onSubmit(e: any) {
    e.preventDefault();
    signInWithEmailAndPassword(auth, "eam.dayan@gmail.com", "there were two cats")
      .then((result: any) => {
        return axios.get(`http://localhost:8989/api/private`, {
          headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${result.user.accessToken}`
          }
        })
      })
      .then(res => console.log(res.data))
      .catch((error) => {
        console.log(error);
      });

  }

  return (
    <div>
      <form onSubmit={onSubmit}>
        <input type="submit" value="login" />
      </form>
    </div>
  )
}

export default App


