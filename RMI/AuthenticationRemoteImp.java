package com.mph;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AuthenticationRemoteImp extends UnicastRemoteObject implements AuthenticationRemote {

    protected AuthenticationRemoteImp() throws RemoteException {
    }

    @Override
    public Person loginValidation(String username, String password) throws RemoteException {
       if(username!=null && password !=null){
           if(username.equals("Priya")&& password.equals("pwd")){
               return new Person("Priyadarshini","P");
           }
       }
       return null;
    }
}
