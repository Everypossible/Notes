package com.crs.notes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Description: 基于功能去封装JDBC工具类
 * @outhor RS
 * @create 2021-03-30 15:20
 */
public class JdbcUtil {
    Connection con = null;
    PreparedStatement car =null;
    //简化获得连接通道的难度
    public Connection getCon(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/yanfazhongxin",
                    "root", "chen1755");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    //简化获得交通工具的难度
    public PreparedStatement getCar(String sql){
        try {
            car = getCon().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    //简化PreparedStatement和Connection的销毁难度
    public void close(){
        if (car != null){
            try {
                car.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

