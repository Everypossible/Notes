package com.crs.notes.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.crs.notes.bean.LoginRecord;
import com.crs.notes.dao.NotesDetailsDao;
import com.crs.notes.dao.NotesGroupDao;
import com.crs.notes.entity.NotesDetails;
import com.crs.notes.entity.NotesGroup;
import com.crs.notes.util.JdbcUtil;
import com.crs.notes.dao.*;
import com.crs.notes.entity.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class NotesInsertFrm extends JFrame {
	private JTextField notesTitleText;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox notesGroupJcb;
	private JRadioButton privateJrb;
	private JRadioButton publicJrb;
	private JTextArea notesDescText;
	private LoginRecord loginRecord;
	
	private NotesGroupDao notesGroupDao = new NotesGroupDao();
	private NotesDetailsDao notesDetailsDao = new NotesDetailsDao();
	public  UserDetailsDao userDetailsDao = new UserDetailsDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotesInsertFrm frame = new NotesInsertFrm();
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
	public NotesInsertFrm() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setTitle("编写笔记");
		setBounds(100, 100, 600, 648);
		
		JLabel lblNewLabel = new JLabel("笔记标题");
		
		notesTitleText = new JTextField();
		notesTitleText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("笔记内容");
		
		privateJrb = new JRadioButton("私密");
		buttonGroup.add(privateJrb);
		
		publicJrb = new JRadioButton("公开");
		buttonGroup.add(publicJrb);
		publicJrb.setSelected(true);
		
		JLabel lblNewLabel_2 = new JLabel("选择分组");
		
		notesGroupJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("发布");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notesInsertActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
								.addComponent(notesGroupJcb, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addComponent(notesTitleText, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(privateJrb, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(publicJrb, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(95)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(notesTitleText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(privateJrb)
						.addComponent(publicJrb))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(notesGroupJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(385))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
							.addGap(12)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(15))
		);
		
		notesDescText = new JTextArea();
		notesDescText.setLineWrap(true);
		scrollPane.setViewportView(notesDescText);
		getContentPane().setLayout(groupLayout);
		
		fillNotesGroup();

	}
	
	/**
	 * 重置事件的处理
	 * @param e
	 */
	protected void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();		
	}

	/**
	 * 事件发布事件的处理
	 * @param e
	 */
	protected void notesInsertActionPerformed(ActionEvent e) {
		String notesTitle = this.notesTitleText.getText();
		String notesDesc = this.notesDescText.getText();
		
		if (notesTitle == null || notesTitle.equals("")) {
			JOptionPane.showMessageDialog(null, "笔记标题不能为空");
			return;
		}
		if (notesDesc == null || notesDesc.equals("")) {
			JOptionPane.showMessageDialog(null, "笔记内容不能为空");
			return;
		}
		//私密还是公开按钮的选择处理
		String jurisdiction = "";
		if (privateJrb.isSelected()) {
			jurisdiction = "私密";
		}else if (publicJrb.isSelected()){
			jurisdiction = "公开";
		}
		
		//对发布事件选择所属分组的处理
		NotesGroup notesGroup = (NotesGroup) notesGroupJcb.getSelectedItem();
		String notesGroupName = notesGroup.getGroupName();
		int notesGroupId = notesGroup.getNotesGroupId();
		
		//获取当前时间
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		//根据用户id找到其nickname
		JdbcUtil jdbcUtil = new JdbcUtil();
		String author = "";
		try {
			author = userDetailsDao.selectUserNickname(loginRecord.recordUserId);
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		
		NotesDetails notesDetails = new NotesDetails(notesTitle, notesDesc, author, loginRecord.recordUserId, dateString, dateString, jurisdiction, notesGroupId);
		
		try {
			int line = notesDetailsDao.insert(notesDetails);
			if (line == 1) {
				JOptionPane.showMessageDialog(null, "发布成功");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "发布失败");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "发布失败");
		}
	}
	
	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.notesTitleText.setText("");
		this.notesDescText.setText("");
		//设置默认权限为公开
		this.publicJrb.setSelected(true);
		if (this.notesGroupJcb.getItemCount() > 0) {
			this.notesGroupJcb.setSelectedIndex(0);
		}
	}

	/**
	 * 初始化所属瓜圈类别下拉框
	 */
	private void fillNotesGroup() {
		NotesGroup notesGroup = null;
		try {
			ResultSet rs = notesGroupDao.selectNotesGroup(new NotesGroup());
			while (rs.next()) {
				notesGroup = new NotesGroup();
				notesGroup.setNotesGroupId(rs.getInt("notes_group_id"));
				notesGroup.setGroupName(rs.getString("group_name"));
				this.notesGroupJcb.addItem(notesGroup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
