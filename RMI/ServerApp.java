package com.mph;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerApp {

    public static void main(String[] args) throws RemoteException {
        AuthenticationRemoteImp authenticationService =null;

        try {
            authenticationService = new AuthenticationRemoteImp();
            Naming.rebind("rmi:///RemoteAuthentication",authenticationService);

            System.out.println("remote object registered");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch(RemoteException e){
            e.printStackTrace();
        }

    }
}
