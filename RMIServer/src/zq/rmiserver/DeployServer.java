package zq.rmiserver;

import zq.rmiserver.impl.DataServiceImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by zq on 2017/3/26.
 */
public class DeployServer {
    public DeployServer() {
    }

    public static void main(String[] args) {
        if(System.getSecurityManager()==null){
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            DataService ds = new DataServiceImpl();

            LocateRegistry.createRegistry(2666);

            Naming.rebind("//localhost:2666/ds",ds);
            System.out.println("运行...");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
