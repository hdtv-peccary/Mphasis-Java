package com.mph;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AuthenticationRemote extends Remote
{
    //interface should extend Remote
    //loginValidation is the remote method , so it has to throw the remote exception
    public Person loginValidation(String username, String password)throws RemoteException;
}
