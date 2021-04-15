package com.crs.notes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.notes.bean.LoginRecord;
import com.crs.notes.entity.*;
import com.crs.notes.util.*;

/**
 * @Description: 对数据库的账户信息进行操作
 * @outhor RS
 * @create 2021-03-30 9:47
 */

public class AccountDao {

	    //推送insert试实现注册功能
	    public int insert(Account account){
	        String sql = "insert into account (account_name,account_password,identity) values(?,?,?)";
	        JdbcUtil util = new JdbcUtil();
	        PreparedStatement car = util.getCar(sql);
	        ResultSet rs = null;
	        int flag = 0;

	        try {
	            car.setString(1, account.getUserName());
	            car.setString(2, account.getUserPassword());
	            car.setInt(3, account.getIdentify());
	            flag = car.executeUpdate();
	            //返回最后一个注册账户的主键id
	            rs = car.executeQuery("select last_insert_id()");
	            if(rs.next()){
	                System.out.println(rs.getLong(1));
	                return rs.getInt(1);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	try {
	        		if (rs != null) {
			            rs.close();
			        }
				} catch (Exception e2) {
					e2.printStackTrace();
				}
	            util.close();
	        }
	        return 0;
	    }
	    
	    //登录功能
	    public static int login(String name, String pwd, Integer identity) throws Exception {
	    	int flag = 0;
	    	ResultSet table = null;
	        //预编译SQL命令
	        String sql = "select count(*) from account where account_name=? and account_password=? and identity=?";
	        JdbcUtil util = new JdbcUtil();
	        PreparedStatement car = util.getCar(sql);
	        //对占位符进行赋值
	        try {
	        	car.setString(1, name);
		        car.setString(2, pwd);
		        car.setInt(3, identity);
		        //发车
		        table = car.executeQuery();
		        table.next();
		        flag = table.getInt(1);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
	        		if (table != null) {
			            table.close();
			        }
				} catch (Exception e2) {
					e2.printStackTrace();
				}
	            util.close();
			}
	        return flag;
		}
	    
	    /**
	     * 根据用户名查询用户account
	     */
	    public ResultSet selectUser(JdbcUtil jdbcUtil, String userName) throws Exception {

	    	String sql = "select * from account where account_name=?";
	    	PreparedStatement carsearch = null;
	    	ResultSet table = null;
	    	
	    	carsearch = jdbcUtil.getCar(sql);
	    	carsearch.setString(1, userName);
			table = carsearch.executeQuery();
	    	return table;
	    }
	 
}
