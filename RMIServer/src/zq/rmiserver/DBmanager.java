package zq.rmiserver;

import java.sql.*;

public class DBmanager {

    private static final String username = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/rmi?useUnicode=true&characterEncoding=utf8";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static Connection conn = null;
    private static ResultSet rs = null;
    private static Statement stmt = null;

    private static Connection getCon() {    //数据库连接
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;

    }

    public static void creatTable() {       /* 创建表 */
        String sql = "create table stutable(sid int(10),sname varchar(10),score float)";
        conn = getCon();
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void insert(Student student) {        /* 插入 */
        String sql = "insert into stutable values('" + student.getSid() + "' , '" + student.getSname() + "' , " + student.getScore() + ")";
        conn = getCon();
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }
    public static Student getStu(int sid){       /* 获取信息 */
        String sql="select * from stutable where sid = "+sid;
        conn=getCon();
        Student student=new Student();
        try{
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            if(rs.next()){
                student.setSid(rs.getInt(1));
                student.setSname(rs.getString(2));
                student.setScore(rs.getFloat(3));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

}