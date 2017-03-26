package zq.rmiclient;

import zq.rmiserver.DataService;
import zq.rmiserver.Student;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/**
 * Created by zq on 2017/3/26.
 */
public class RmiClient {
    public static void main(String[] args) {
        if(System.getSecurityManager()==null){
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            DataService ds =(DataService) Naming.lookup("//localhost:2666/ds");
            ds.createTable();
            Student student=new Student();
            student.setSid(1);
            student.setSname("zq");
            student.setScore(100.0f);
            ds.insert(student);

            Student student1=ds.getStu(1);
            System.out.println("ID: "+student1.getSid()+",Name: "+student1.getSname()+",Score: "+student1.getScore());

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
