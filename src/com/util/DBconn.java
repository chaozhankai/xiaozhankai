package com.util;

import java.sql.*;

/**
 * 连接数据库
 */

public class DBconn {
    private static String url = "jdbc:mysql://localhost:3306/eleme?useunicuee=true& characterEncoding=utf8";
    private static String username = "xiaozhankai_com";
    private static String password = "lmy360080501";
    private static Connection  conn = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps =null;
    // 连接数据库
    public static void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            System.out.println("init [SQL驱动程序初始化失败！]");
            e.printStackTrace();
        }
    }
    public static int addUpdDel(String sql){
        int i = 0;
        try {
            PreparedStatement ps =  conn.prepareStatement(sql);
            i =  ps.executeUpdate(); // executeUpdate()返回的是受影响的行数，所以是int
        } catch (SQLException e) {
            System.out.println("sql数据库增删改异常");
            e.printStackTrace();
        }

        return i;
    }
    public static ResultSet selectSql(String sql){
        try {
            ps =  conn.prepareStatement(sql);
            rs =  ps.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("sql数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }
    public static void closeConn(){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("sql数据库关闭异常");
            e.printStackTrace();
        }
    }
}
