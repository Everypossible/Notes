package com.crs.notes.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.crs.notes.bean.LoginRecord;
import com.crs.notes.bean.NotesRecord;
import com.crs.notes.dao.NotesDetailsDao;
import com.crs.notes.dao.NotesGroupDao;
import com.crs.notes.util.JdbcUtil;

import com.crs.notes.entity.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyPublishFrm extends JFrame {

	private JPanel contentPane;
	private JTable myPublishTable;
	private NotesDetailsDao notesDetailsDao = new NotesDetailsDao();
	private NotesGroupDao notesGroupDao = new NotesGroupDao();
	LoginRecord loginRecord = new LoginRecord();
	private NotesRecord notesRecord = new NotesRecord();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPublishFrm frame = new MyPublishFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyPublishFrm() {
		setAlwaysOnTop(true);
		setTitle("我的笔记");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 894, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 869, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 615, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("刷新");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillMyPublishTable(new NotesDetails());
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		myPublishTable = new JTable();
		myPublishTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myPublishTableMouseClicked(e);
			}
		});
		myPublishTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7B14\u8BB0\u7F16\u53F7", "\u7B14\u8BB0\u6807\u9898", "\u6700\u8FD1\u66F4\u65B0", "\u70B9\u8D5E\u6570"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		myPublishTable.getColumnModel().getColumn(1).setPreferredWidth(303);
		myPublishTable.getColumnModel().getColumn(2).setPreferredWidth(137);
		scrollPane.setViewportView(myPublishTable);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		fillMyPublishTable(new NotesDetails());
	}
	
	/**
	 * 我的笔记点开显示详情事件的处理
	 * @param e
	 */
	protected void myPublishTableMouseClicked(MouseEvent e) {
		MyPublishDetailsFrm myPublishDetailsFrm = new MyPublishDetailsFrm();
		myPublishDetailsFrm.setVisible(true);
		int row =  this.myPublishTable.getSelectedRow();
		int notesId = Integer.parseInt(myPublishTable.getValueAt(row, 0).toString());
		//锁定点击选中的笔记
		notesRecord.notesIdRecord = notesId;
		int notesGroupId = 0;
		String originalNotesGroupName = null;
		NotesGroup notesGroup = null;
		
		ResultSet rs = null;
		JdbcUtil utilSearch = new JdbcUtil();
		try {
			rs = notesDetailsDao.selectNotes(utilSearch, notesId);
			while(rs.next()) {
				//填充文本框
				myPublishDetailsFrm.setMyNotesTitleText(rs.getString("notes_title"));
		        myPublishDetailsFrm.setMyNotesDescText(rs.getString("notes_desc"));
		        myPublishDetailsFrm.setMyNotesAddTimeText(rs.getString("add_time"));
		        myPublishDetailsFrm.setMyNotesLastTimeText(rs.getString("last_time"));
		        myPublishDetailsFrm.setMyNotesLikesText(String.valueOf(rs.getInt("notes_likes")));
		        //填充私密还是公开
		        if ("公开".equals(rs.getString("jurisdiction"))) {
					myPublishDetailsFrm.publicJrb.setSelected(true);
				}else {
					myPublishDetailsFrm.privateJrb.setSelected(true);
				}
		        notesGroupId = rs.getInt("notes_group_id");
			}
			//填充笔记组别
	        //设置笔记原本分组为首选项
	        rs = notesGroupDao.selectNotesGroupName(notesGroupId);
	        while (rs.next()) {
	        	notesGroup = new NotesGroup();
        		originalNotesGroupName = rs.getString("group_name");
			    notesGroup.setGroupName(originalNotesGroupName);
			    notesGroup.setNotesGroupId(notesGroupId);
			    //必须是addItem(notesGroup)而不能是addItem(originalNotesGroupName),
			    //因为放入notesGroup的话，读取它时能读取notesGroup的id和name
		        myPublishDetailsFrm.notesGroupJcb.addItem(notesGroup);
			}
	       
	        //补充其余选项进下拉框
			rs =  notesGroupDao.selectNotesGroup(new NotesGroup());
			while (rs.next()) {
				if ( ! (rs.getString("group_name").equals(originalNotesGroupName)) ) {
					notesGroup = new NotesGroup();
					notesGroup.setGroupName(rs.getString("group_name"));
				    notesGroup.setNotesGroupId(rs.getInt("notes_group_id"));
					myPublishDetailsFrm.notesGroupJcb.addItem(notesGroup);
				}				
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			if (rs != null){
		        try {
		            rs.close();
		        } catch (Exception e3) {
		              e3.printStackTrace();
		        }
		    }
		    utilSearch.close();
		}
		
	}

	/**
	 * 初始化我的笔记的页面的表格
	 */
	private void fillMyPublishTable (NotesDetails notesDetails) {
		DefaultTableModel dtm = (DefaultTableModel) myPublishTable.getModel();
		dtm.setRowCount(0);//设置成0行（即清空表格）
		ResultSet rs = null;
		Integer id = loginRecord.recordUserId;
		
		JdbcUtil utilSearch = new JdbcUtil();
		try {
			rs = notesDetailsDao.selectNotes(utilSearch, id);
			while(rs.next()) {
		        Vector v = new Vector();//线程安全
				//id只能getString而不能getInt，因为后面读取这个数据时用到的setText(String)只能传入String
		     	v.add(rs.getString("notes_details_id"));
				v.add(rs.getString("notes_title"));
				v.add(rs.getString("last_time"));
				v.add(rs.getString("notes_likes"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null){
		        try {
		            rs.close();
		        } catch (Exception e) {
		              e.printStackTrace();
		        }
		    }
		    utilSearch.close();
		}
	}
}
