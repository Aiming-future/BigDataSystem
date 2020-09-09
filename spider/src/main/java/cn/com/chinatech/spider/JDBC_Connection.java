package cn.com.chinatech.spider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connection {

    //加载驱动，链接数据库
    public static Connection getConnection () throws SQLException,
            ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://127.0.0.1:3306/market?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false";
        String username="root";
        String password="root";
        Connection conn=DriverManager.getConnection(url, username, password);
        return conn;
    }
    //关闭数据库连接，释放资源
    public static void release(PreparedStatement stmt,Connection conn){
        if(stmt!=null){
            try{
                stmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            stmt=null;
        }
        if(conn!=null){
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            conn=null;
        }
    }
    public static void release(ResultSet rs,PreparedStatement stmt,Connection conn){
        if(rs!=null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            rs=null;
        }
        release(stmt,conn);
    }
}
