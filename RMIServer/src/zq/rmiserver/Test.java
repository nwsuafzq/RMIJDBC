package zq.rmiserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by zq on 2017/3/26.
 */
public class Test {

    public static void main(String args[]) {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");     //加载MYSQL JDBC驱动程序
            System.out.println("Success loading Mysql Driver!");
        } catch (Exception e) {
            System.out.print("Error loading Mysql Driver!");
            e.printStackTrace();
        }

        try {
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ceahi", "root", "");
//连接URL为   jdbc:mysql//服务器地址/数据库名
//后面的2个参数分别是登陆用户名和密码
            System.out.println("Success connect Mysql server!");

            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pet");
            while (rs.next()) {
                System.out.println(rs.getString("name"));

            }
        } catch (Exception e) {
            System.out.print("get data error!");
            e.printStackTrace();
        }
    }
}

