package com.crs.notes.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.crs.notes.bean.LoginRecord;
import com.crs.notes.bean.NotesRecord;
import com.crs.notes.dao.NotesDetailsDao;
import com.crs.notes.dao.UserDetailsDao;
import com.crs.notes.entity.NotesDetails;
import com.crs.notes.entity.NotesGroup;

import com.crs.notes.entity.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class MyPublishDetailsFrm extends JFrame {

	private JPanel contentPane;
	private JTextField myNotesTitleText;
	private JTextField myNotesAddTimeText;
	private JTextField myNotesLastTimeText;
	private JTextField myNotesLikesText;
	private JTextArea myNotesDescText;
	public JRadioButton privateJrb;
	public JRadioButton publicJrb;
	public JComboBox notesGroupJcb;
	public final ButtonGroup buttonGroup = new ButtonGroup();
	
	private LoginRecord loginRecord;
	private NotesRecord notesRecord;
	private UserDetailsDao userDetailsDao = new UserDetailsDao();
	private NotesDetailsDao notesDetailsDao = new NotesDetailsDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPublishDetailsFrm frame = new MyPublishDetailsFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * get和set方法
	 */
	public void setMyNotesTitleText(String string) {
		myNotesTitleText.setText(string);
	}
	public String getMyNotesTitleText() {
		return getMyNotesTitleText();
	}
	public void setMyNotesDescText(String string) {
		myNotesDescText.setText(string);
	}
	public String getMyNotesDescText() {
		return getMyNotesDescText();
	}
	public void setMyNotesAddTimeText(String string) {
		myNotesAddTimeText.setText(string);
	}
	public String getMyNotesAddTimeText() {
		return getMyNotesAddTimeText();
	}
	public void setMyNotesLastTimeText(String string) {
		myNotesLastTimeText.setText(string);
	}
	public String getMyNotesLastTimeText() {
		return getMyNotesLastTimeText();
	}
	public void setMyNotesLikesText(String string) {
		myNotesLikesText.setText(string);
	}
	public String getMyNotesLikesText() {
		return getMyNotesLikesText();
	}

	/**
	 * Create the frame.
	 */
	public MyPublishDetailsFrm() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(325, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("笔记标题");
		
		myNotesTitleText = new JTextField();
		myNotesTitleText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("发布时间");
		
		myNotesAddTimeText = new JTextField();
		myNotesAddTimeText.setEditable(false);
		myNotesAddTimeText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("最近更新");
		
		myNotesLastTimeText = new JTextField();
		myNotesLastTimeText.setEditable(false);
		myNotesLastTimeText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("笔记内容");
		
		JLabel lblNewLabel_4 = new JLabel("点赞数");
		
		myNotesLikesText = new JTextField();
		myNotesLikesText.setEditable(false);
		myNotesLikesText.setColumns(10);
		
		JButton btnNewButton = new JButton("确认修改并提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPublishNotesUpdateActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPublishDeleteActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("权限");
		
		privateJrb = new JRadioButton("私密");
		buttonGroup.add(privateJrb);
		
		publicJrb = new JRadioButton("公开");
		buttonGroup.add(publicJrb);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_6 = new JLabel("所属组别");
		
		notesGroupJcb = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(myNotesTitleText, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(privateJrb)
									.addGap(18)
									.addComponent(publicJrb))
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addGap(87)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(myNotesLastTimeText))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(myNotesAddTimeText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(28, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(myNotesLikesText, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(103)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(78))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(notesGroupJcb, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(myNotesTitleText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(myNotesAddTimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(myNotesLastTimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(privateJrb)
						.addComponent(publicJrb, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(notesGroupJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(myNotesLikesText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		
		myNotesDescText = new JTextArea();
		scrollPane.setViewportView(myNotesDescText);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * 删除自己的笔记事件的处理
	 */
	protected void myPublishDeleteActionPerformed(ActionEvent e) {
		int n = JOptionPane.showConfirmDialog(null, "确认要删除该笔记吗?");
		if (n == 0) {
			NotesDetails notesDetails = new NotesDetails();
			notesDetails.setNotesDetailsId(notesRecord.notesIdRecord);
			int line = notesDetailsDao.deleteNotes(notesDetails);
			if (line == 1) {
				JOptionPane.showMessageDialog(null, "删除成功");
			}else {
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		}
	}

	/**
	 * 我的笔记内容修改事件的处理
	 * @param e
	 * @throws 
	 */
	protected void myPublishNotesUpdateActionPerformed(ActionEvent e) {
		//获取文本框内容
		String myNotesTitle = myNotesTitleText.getText();
		String myNotesDesc = myNotesDescText.getText();
		String myNotesAddTime = myNotesAddTimeText.getText();
		String myNotesLastTime = myNotesLastTimeText.getText();
		String myNotesLikes = myNotesLikesText.getText();
		//获取选中的权限
		String jurisdiction = "";
		if (privateJrb.isSelected()) {
			jurisdiction = "私密";
		}else if (publicJrb.isSelected()){
			jurisdiction = "公开";
		}
		//获取选中的分组
		NotesGroup notesGroup = (NotesGroup) notesGroupJcb.getSelectedItem();
		String notesGroupName = notesGroup.getGroupName();
		int notesGroupId = notesGroup.getNotesGroupId();
		//获取当前时间
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		//错误提示
		if (myNotesTitle == null || myNotesTitle.equals("")) {
			JOptionPane.showMessageDialog(null, "请填写笔记标题");
			return;
		}
		if (myNotesDesc == null || myNotesDesc.equals("")) {
			JOptionPane.showMessageDialog(null, "笔记内容不能为空");
			return;
		}
		//获取作者昵称
		String userNickname = null;
		try {
			userNickname = userDetailsDao.selectUserNickname(loginRecord.recordUserId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//创建对象做实参
		NotesDetails notesDetails = new NotesDetails(myNotesTitle, myNotesDesc, userNickname, 
				loginRecord.recordUserId, myNotesAddTime, dateString, jurisdiction, notesGroupId);
		try {
			int line = notesDetailsDao.updateNotesDetails(notesDetails);
			if (line != 0) {
				JOptionPane.showMessageDialog(null, "修改成功");
				
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败");
		}
		
	}

}
