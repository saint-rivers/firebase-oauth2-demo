// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
// import { getAnalytics } from "firebase/analytics";
import { GoogleAuthProvider, getAuth, signInWithPopup } from "firebase/auth";

// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyCsZ8M_XjOjDIF3xl1ZdYuNilNvbzESGwk",
  authDomain: "calm-inkwell-316507.firebaseapp.com",
  projectId: "calm-inkwell-316507",
  storageBucket: "calm-inkwell-316507.appspot.com",
  messagingSenderId: "529281820363",
  appId: "1:529281820363:web:b363798420d83d98945d4e",
  measurementId: "G-ST1V9SJ56Z",
};

// Initialize Firebase
export const app = initializeApp(firebaseConfig);
// const analytics = getAnalytics(app);

export const provider = new GoogleAuthProvider();
provider.addScope("https://www.googleapis.com/auth/contacts.readonly");

export const auth = getAuth(app);
