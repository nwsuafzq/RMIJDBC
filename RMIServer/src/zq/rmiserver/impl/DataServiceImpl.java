package zq.rmiserver.impl;

import zq.rmiserver.DBmanager;
import zq.rmiserver.DataService;
import zq.rmiserver.Student;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by zq on 2017/3/26.
 */
public class DataServiceImpl extends UnicastRemoteObject implements DataService {


    public DataServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public void createTable() throws RemoteException {
        DBmanager.creatTable();
    }

    @Override
    public void insert(Student student) throws RemoteException {
        DBmanager.insert(student);
    }

    @Override
    public Student getStu(int sid) throws RemoteException {
        return DBmanager.getStu(sid);
    }
}
