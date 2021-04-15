package com.crs.notes.dao;

import java.rmi.NoSuchObjectException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crs.notes.bean.NotesRecord;
import com.crs.notes.entity.NotesDetails;
import com.crs.notes.util.JdbcUtil;

/**
 * 笔记细节的Dao类
 * @author RS
 *
 */
public class NotesDetailsDao {
	NotesRecord notesRecord = new NotesRecord();

		/**
		 * 封装插入操作实现细节
		 * @param notesDetails
		 * @return
		 */
	    public int insert(NotesDetails notesDetails){
	        String sql = "insert into notes_details values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        JdbcUtil utilinsert = new JdbcUtil();
	        PreparedStatement carinsert = null;
	        int flag = 0;

	        try {
	            carinsert = utilinsert.getCar(sql);
	            carinsert.setInt(1, notesDetails.getNotesDetailsId());
	            carinsert.setString(2, notesDetails.getNotesTitle());
	            carinsert.setString(3, notesDetails.getNotesDesc());
	            carinsert.setString(4, notesDetails.getPublisherNickName());
	            carinsert.setInt(5, notesDetails.getPublisherId());
	            carinsert.setString(6, notesDetails.getAddTime());
	            carinsert.setString(7, notesDetails.getLastTime());
	            carinsert.setString(8, notesDetails.getJurisdiction());
	            carinsert.setInt(9, notesDetails.getNotesLikes());
	            carinsert.setInt(10, notesDetails.getNotesGroupId());	       
	            flag = carinsert.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            utilinsert.close();
	        }
	        return flag;
	    }

	    /**
	     * 用户主页的事件查询功能
	     * @param utilSearch
	     * @param news
	     * @param startIndex
	     * @return
	     * @throws Exception
	     */
	    public ResultSet selectNotes(JdbcUtil utilSearch, NotesDetails notesDetails, int startIndex) throws Exception{
			//分页搜索，一页只展示10条记录
	    	StringBuffer sb = new StringBuffer("select * from notes_details where jurisdiction=?");
	    	/**
	    	 * 模糊搜索
	    	 */
	    	//按照文章标题搜索
			if ( (notesDetails.getNotesTitle() != null) && (!("".equals(notesDetails.getNotesTitle())))) {
				sb.append(" or notes_title like '%" + notesDetails.getNotesTitle() + "%'");
			}
			//按照作者昵称搜索
			if (! (notesDetails.getPublisherNickName() == null || notesDetails.getPublisherNickName().equals(""))) {
				sb.append(" or publisher_nickname like '%" + notesDetails.getPublisherNickName() + "%'");
			}
			//根据用户登录后的id号搜索他的个人笔记
	        sb.append(" limit ?,10");
	        PreparedStatement carsearch = null;
	        ResultSet table = null;
			
	        carsearch = utilSearch.getCar(sb.toString().replaceFirst("or", "and"));
	        carsearch.setString(1, "公开");
			carsearch.setInt(2, startIndex);
			table = carsearch.executeQuery();
			
			return table;
	    }
	    
	    /**
	     * 根据用户登录后的id号搜索他的个人笔记
	     */
	    public ResultSet selectNotes(JdbcUtil jdbcUtil, Integer publisherId) throws Exception{
	    	String sql = "select * from notes_details where publisher_id=?";
	    	PreparedStatement carsearch = null;
	    	ResultSet table = null;
	    	
	    	carsearch = jdbcUtil.getCar(sql);
	    	carsearch.setInt(1, publisherId);
			table = carsearch.executeQuery();
	    	return table;
	    }
	    
	    /**
	     * 用户主页的点击可查看详情功能（根据笔记编号（唯一）检索出文章）
	     * @throws Exception 
	     */
	    public ResultSet selectNotes(JdbcUtil jdbcUtil, int notesId) throws Exception {

	    	String sql = "select * from notes_details where notes_details_id=?";
	    	PreparedStatement carsearch = null;
	    	ResultSet table = null;
	    	
	    	carsearch = jdbcUtil.getCar(sql);
	    	carsearch.setInt(1, notesId);
			table = carsearch.executeQuery();
	    	return table;
	    }
	    
	    /**
	     * 删除笔记
	     */
	    public int deleteNotes(NotesDetails notesDetails) {
	    	String sql = "delete from notes_details where notes_details_id=?";
	        JdbcUtil utildelete = new JdbcUtil();
	        PreparedStatement cardelete = null;
	        int flag = 0;

	        try {
	            cardelete = utildelete.getCar(sql);
	            cardelete.setInt(1, notesDetails.getNotesDetailsId());	
	            flag = cardelete.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            utildelete.close();
	        }
	        return flag;
	    }
	    
		  /**
		   *封装更新操作的流程
		  */
		  public int updateNotesDetails(NotesDetails notesDetails){
		      String sql = "update notes_details set notes_title=?, notes_desc=?, publisher_nickname=?, publisher_id=?, "
		      		+ "add_time=?, last_time=?, jurisdiction=?, notes_group_id=? where notes_details_id=?";
		      JdbcUtil utilupdate = new JdbcUtil();
		      PreparedStatement carupdate = null;
		      int flag = 0;
		
		      try {
		          carupdate = utilupdate.getCar(sql);
		          carupdate.setString(1, notesDetails.getNotesTitle());
		          carupdate.setString(2, notesDetails.getNotesDesc());
		          carupdate.setString(3, notesDetails.getPublisherNickName());
		          carupdate.setInt(4, notesDetails.getPublisherId());
		          carupdate.setString(5, notesDetails.getAddTime());
		          carupdate.setString(6, notesDetails.getLastTime());
		          carupdate.setString(7, notesDetails.getJurisdiction());
		          carupdate.setInt(8, notesDetails.getNotesGroupId());
		          carupdate.setInt(9, notesRecord.notesIdRecord);
		          flag = carupdate.executeUpdate();
		      } catch (SQLException e) {
		          e.printStackTrace();
		      } finally {
		          utilupdate.close();
		      }
		      return flag;
		  }
		  /**
		   * 更新昵称
		   */
		  public int updateNotesPublisherNickname(NotesDetails notesDetails){
		      String sql = "update notes_details set publisher_nickname=? where publisher_id=?";
		      JdbcUtil utilupdate = new JdbcUtil();
		      PreparedStatement carupdate = null;
		      int flag = 0;
		
		      try {
		          carupdate = utilupdate.getCar(sql);
		          carupdate.setString(1, notesDetails.getPublisherNickName());
		          carupdate.setInt(2, notesDetails.getPublisherId());
		          
		          flag = carupdate.executeUpdate();
		      } catch (SQLException e) {
		          e.printStackTrace();
		      } finally {
		          utilupdate.close();
		      }
		      return flag;
		  }
			
			/**
			 * 计算总的数据条数
			 */
			public int getTotalCount() {
				int totalCount = 0;
				ResultSet rs = null;
				String sql = "select count(*) from notes_details";
		        JdbcUtil utilGetTotalCount = new JdbcUtil();
		        PreparedStatement carGetTotalCount = null;
		        
		        try {
		            carGetTotalCount = utilGetTotalCount.getCar(sql);
		            rs = carGetTotalCount.executeQuery();
		            if (rs.next()) {
						totalCount = rs.getInt(1);
					}
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            utilGetTotalCount.close();
		        }
		        return totalCount;				
			}
}
