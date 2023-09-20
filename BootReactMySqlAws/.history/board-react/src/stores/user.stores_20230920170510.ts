import {create} from 'zustand';

interface UserStore{
    user:any;
    setUser: (user: any)=>void;
    removeUser:()=>void;
}