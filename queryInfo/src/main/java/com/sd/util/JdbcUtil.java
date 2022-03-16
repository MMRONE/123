package com.sd.util;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

// JdbcUtil obj = new JdbcUtil();  obj.getCon()
// JdbcUtil obj = new JdbcUtil();  obj.createStatement();
// JdbcUtil.getCon();
public class JdbcUtil {
     final String URL="jdbc:mysql://localhost:3306/mis";
     final String USERNAME="root";
     final String PASSWORD="123456";
     PreparedStatement ps= null;
     Connection con = null;

    //将jar包中driver实现类加载到JVM中
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public  Connection   getCon(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        Map map=(Map)application.getAttribute("key1");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Connection con=(Connection)iterator.next();
            Boolean flag=(Boolean)map.get(con);

            if(flag==true){
                System.out.println("sddddddddddddddddddddddddddddd==========");
                System.out.println(con);
                System.out.println("==============================");
                map.put(con,false);
                return con;
//                break;
            }
        }
        if(con==null){
            Connection con = getCon();
        }
        System.out.println(con);
        System.out.println("=============wowo============");
        return con;
    }
    public  PreparedStatement createStatement(String sql,HttpServletRequest request){

        try {
            ps =  getCon(request).prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    //封装连接通道创建细节
    public  Connection   getCon(){

        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //封装交通工具创建细节
    public  PreparedStatement createStatement(String sql){

        try {
            ps =  getCon().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    // ps与con销毁细节 insert,update,delete
    public  void close(){
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public  void close(HttpServletRequest request){
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        ServletContext application = request.getServletContext();
        Map map=(Map)application.getAttribute("key1");
        map.put(con,true);
    }
     //select ps,con,rs
    public  void close(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }
}
