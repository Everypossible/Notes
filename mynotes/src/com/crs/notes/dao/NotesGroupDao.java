package com.crs.notes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.notes.entity.*;
import com.crs.notes.util.JdbcUtil;

public class NotesGroupDao {
	
		//查询笔记分组
		public ResultSet selectNotesGroup(NotesGroup notesGroup) throws Exception {
		        //货物
				StringBuffer sb = new StringBuffer("select * from notes_group");
				if ((notesGroup.getGroupName() != null) && (!(notesGroup.getGroupName().equals("")))) {
					sb.append(" and groupName like '%" + notesGroup.getGroupName() + "%'");
				}
				JdbcUtil jdbcUtil = new JdbcUtil();
		        //JDBC步骤2：建立交通工具
		        PreparedStatement car = jdbcUtil.getCar(sb.toString().replaceFirst("and", "where"));
		        //JDBC步骤3：通信：把命令发出去，把结果带回来
		        //executeQuery()返回的是一张临时表
		        ResultSet table = car.executeQuery();
		        return table;
		}
		
		//根据笔记分组的id查询笔记分组的name
		public ResultSet selectNotesGroupName(int notesGroupId) throws Exception {
			String sql = "select * from notes_group where notes_group_id=?";
			JdbcUtil jdbcUtil = new JdbcUtil();

	        PreparedStatement car = jdbcUtil.getCar(sql);
	        car.setInt(1, notesGroupId);

	        ResultSet table = car.executeQuery();
	        return table;
		}
		
		/**
		 * 创建笔记分组
		 */
		public int insert(NotesGroup notesGroup) {
			String sql = "insert into notes_group (group_name,add_time,last_time,admin_id) values(?,?,?,?)";
	        JdbcUtil util = new JdbcUtil();
	        PreparedStatement car = util.getCar(sql);
	        int flag = 0;

	        try {
	            car.setString(1, notesGroup.getGroupName());
	            car.setString(2, notesGroup.getAddTime());
	            car.setString(3, notesGroup.getLastTime());
	            car.setInt(4, notesGroup.getAdminId());
	            flag = car.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            util.close();
	        }
	        return flag;
		}

}
