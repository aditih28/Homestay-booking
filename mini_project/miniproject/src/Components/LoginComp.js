import React from "react";
//import { useDispatch, useSelector } from "react-redux";
import {Link, Navigate, useNavigate } from "react-router-dom"
import { useReducer,useState,useEffect } from "react";
import background from "./img/img2.jpg";
export let ownerid =0;
export let custid =0;

    export const dynamic = () => {
        // Compute or generate the dynamic value here
        return custid;
      }; 
//import { login } from "../loggedSlice";
// module1.js
export const dynamicValue = () => {
    // Compute or generate the dynamic value here
    return ownerid;
  };  

export default function LoginComp() {
   
    let navigate = useNavigate();
    const init={
        username:"",
        password:""
    }
    const reducer = (state,action) => {
        switch(action.type)
        {
            case 'update':
                //partial updation
                //get the current state and modify only the mentioned field
                return {...state,[action.fld]:action.val}
            case 'reset':
                    return init;
                default:
                    return state;  
        }
    }
    const[User, dispatch] = useReducer(reducer,init);
    const[respo,saveRes] = useState("");
    
    const submitData = (e) => {
        //default behavior submit - cancelling
        e.preventDefault();
        
        console.log(JSON.stringify(User));
        const reqOptions = {
            method:"POST",
            headers: {'content-type':'application/json'},
            body: JSON.stringify({
                username:User.username,
                password:User.password
            })
        }

        fetch("http://localhost:8080/login", reqOptions)
        .then(resp => resp.text())
        .then(text => text.length ? JSON.parse(text):{})
        .then(obj => {
            if(Object.keys(obj).length===0){
                console.log("Wrong ID and password")
            }else{
                localStorage.setItem("loggedstatus", 1)
                localStorage.setItem("loggedInfo",JSON.stringify(obj))
                console.log(JSON.stringify(obj))
                if(obj.status === "OK"){
                    
                if(obj.role.roleid === 1){
                    navigate('/admin')
                    console.log("True")
                }else if(obj.role.roleid === 2 && obj.owner.propertytype=="homestay"){
                    navigate('/homestayowner')
                     ownerid = obj.owner.ownerid;
                    console.log("True")
                }else if(obj.role.roleid === 2 && obj.owner.propertytype=="hotel"){
                    navigate('/hotelowner')
                      ownerid = obj.owner.ownerid;
                    console.log("True")
                }else if(obj.role.roleid === 3 && obj.customer){
                    navigate('/customer')
                    custid = obj.customer.custid;
                    
                    console.log("True")
                }
            }else{
                alert("Please Enter valid credentials")
                dispatch({ type: 'reset' }); // Reset the form after successful registration
            }
            }})
        .then(data => saveRes(data) )
        console.log("respo="+respo);
        
    }

    return (
        
        <div className="row" > 
         <div className="nav navbar">
    
    <div className="nav-item">New user?
     <Link to="/custreg" className="nav-link">Register new customer</Link>
    </div>
    <div className="nav-item">Extend your business!
     <Link to="/ownerregistration" className="nav-link">Register owner</Link>
    </div>
    </div>
        <div className="form-outline w-25 col-md-6 mx-auto h-100 d-flex align-items-center justify-content-center" width="w-50" align="center">

            <form className="form-control-sm" align="center">
            <div className="Auth-form-content">
                <h3 className="Auth-form-title">Login</h3>
                <div className="mb-3">
               <label className="form-label"> Enter uid :</label>
                <input type="text" required className="form-control" placeholder="Enter username" value={User.username}
                onChange={(e)=>{
                    dispatch({type:'update',fld:'username',val:e.target.value})
                }} />
                </div>
                </div>

                <div className="mb-3">
                    
               <label className="form-label"> Enter Password :</label>
                <input required type="password" className="form-control" placeholder="Enter Password" value={User.password}
                onChange={(e)=>{
                    dispatch({type:'update',fld:'password',val:e.target.value})
                }} />
                </div>
                <div className="mb-3">
                <button type="submit" className="btn btn-primary"
                onClick={(e)=>{submitData(e)}}>Login</button>

                
                </div>

                
            </form>
           <br /><br />
           <div><p>{respo}</p></div>
        </div>
        </div>
        
    )
}