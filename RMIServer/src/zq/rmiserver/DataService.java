package zq.rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by zq on 2017/3/26.
 */
public interface DataService extends Remote{

    public void createTable()throws RemoteException;
    public void insert(Student student)throws RemoteException;
    public Student getStu(int sid)throws RemoteException;
}
