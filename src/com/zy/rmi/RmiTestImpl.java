package com.zy.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiTestImpl implements RmiTestInterface {
    public RmiTestImpl() throws RemoteException {
    }

    @Override
    public String getTest() throws RemoteException {
        return "Hello, Test";
    }

    public static void main(String[] args) throws AlreadyBoundException, RemoteException {
        RmiTestImpl t = new RmiTestImpl();
        RmiTestInterface tt = (RmiTestInterface) UnicastRemoteObject.exportObject(t, 0);
        // Bind the remote object's stub in the registry
        Registry registry = LocateRegistry.createRegistry(2001);
        registry.rebind("test", tt);
        System.out.println("server is start");
    }
}
