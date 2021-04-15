package com.crs.notes.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.notes.bean.LoginRecord;
import com.crs.notes.entity.*;
import com.crs.notes.util.*;

public class UserDetailsDao {
	private LoginRecord loginRecord;
	/**
	 * 推送insert命令实现用户详细信息存储到数据库
	 */
	public int insert(UserDetails userDetails) {
		String sql = "insert into user_details (user_nickname,user_sex,user_birthday,user_desc,user_id) values(?,?,?,?,?)";
        JdbcUtil util = new JdbcUtil();
        PreparedStatement car = util.getCar(sql);
        int flag = 0;

        try {
            car.setString(1, userDetails.getUserNickName());
            car.setString(2, userDetails.getUserSex());
            car.setString(3, userDetails.getUserBirthday());
            car.setString(4, userDetails.getUserDesc());
            car.setInt(5, userDetails.getUserId());
            flag = car.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return flag;
	}
	
	//根据用户id查询用户昵称
	public String selectUserNickname(int userId) throws Exception {
		String userNickName = null;
		String sql = "select * from user_details where user_id=?";
		JdbcUtil jdbcUtil = new JdbcUtil();

        PreparedStatement car = jdbcUtil.getCar(sql);
        car.setInt(1, userId);

        ResultSet table = car.executeQuery();
        
        while(table.next()) {
        	userNickName = table.getString("user_nickname");
        }
        
        if (table != null) {
			table.close();
		}
        jdbcUtil.close();
        return userNickName;
	}
	
	/**
	 * 根据用户id查询对应user_details表的对应他的所有信息
	 */
	public ResultSet selectUserDetails(JdbcUtil jdbcUtil, int userId) throws Exception {
		String sql = "select * from user_details where user_id=?";

        PreparedStatement car = jdbcUtil.getCar(sql);
        car.setInt(1, userId);

        ResultSet table = car.executeQuery();
        
        return table;
	}
	
	/**
	 * 匹配用户id返回每个用户的account表和user_details表的联合信息
	 */
	public ResultSet selectAllUser(JdbcUtil jdbcUtil) throws Exception {
		String sql = "select * from account join user_details on account.account_id=user_details.user_id"
				+ " where account.identity=?";
        PreparedStatement car = jdbcUtil.getCar(sql);
        car.setInt(1, 0);
        ResultSet table = car.executeQuery();        
        return table;
	}
	
	/**
	   *封装更新操作的流程
	  */
	  public int updateUserDetails(UserDetails userDetails){
	      String sql = "update user_details set user_nickname=?, user_sex=?, user_birthday=?, user_desc=? where user_id=?";
	      JdbcUtil utilupdate = new JdbcUtil();
	      PreparedStatement carupdate = null;
	      int flag = 0;
	
	      try {
	          carupdate = utilupdate.getCar(sql);
	          carupdate.setString(1, userDetails.getUserNickName());
	          carupdate.setString(2, userDetails.getUserSex());
	          carupdate.setString(3, userDetails.getUserBirthday());
	          carupdate.setString(4, userDetails.getUserDesc());
	          carupdate.setInt(5, userDetails.getUserId());
	          flag = carupdate.executeUpdate();
	      } catch (SQLException e) {
	          e.printStackTrace();
	      } finally {
	          utilupdate.close();
	      }
	      return flag;
	  }

}
