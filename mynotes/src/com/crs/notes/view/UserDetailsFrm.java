package com.crs.notes.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.crs.notes.bean.LoginRecord;
import com.crs.notes.dao.*;
import com.crs.notes.entity.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;

public class UserDetailsFrm extends JFrame {

	private JPanel contentPane;
	private AccountDao accountDao = new AccountDao();
	private UserDetailsDao userDetailsDao = new UserDetailsDao();
	public JTextField userNicknameText;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JRadioButton manJcb;
	public JRadioButton womanJcb;
	public JComboBox yearJcb;
	public JComboBox monthJcb;
	public JComboBox dayJcb;
	public JTextArea selfIntroductionText;
	
	private LoginRecord loginRecord;
	private NotesDetailsDao notesDetailsDao = new NotesDetailsDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDetailsFrm frame = new UserDetailsFrm();
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
	public UserDetailsFrm() {
		setAlwaysOnTop(true);
		setTitle("个人信息");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 668, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("个人信息");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		
		JButton btnNewButton = new JButton("修改并提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("");
		
		JLabel lblNewLabel_4 = new JLabel("性别");
		
		manJcb = new JRadioButton("男");
		buttonGroup.add(manJcb);
		
		womanJcb = new JRadioButton("女");
		buttonGroup.add(womanJcb);
		
		JLabel lblNewLabel_5 = new JLabel("昵称");
		
		userNicknameText = new JTextField();
		userNicknameText.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("生日");
		
		yearJcb = new JComboBox();
		
		monthJcb = new JComboBox();
		
		dayJcb = new JComboBox();
		
		JLabel lblNewLabel_7 = new JLabel("自我介绍");
		
		selfIntroductionText = new JTextArea();
		selfIntroductionText.setLineWrap(true);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6))
							.addGap(49)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(userNicknameText)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(manJcb, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(yearJcb, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(22)
											.addComponent(womanJcb, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(monthJcb, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dayJcb, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(selfIntroductionText, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(89, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(260, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(248))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(250)
					.addComponent(lblNewLabel)
					.addContainerGap(272, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNicknameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(manJcb)
						.addComponent(womanJcb))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_6)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(yearJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(monthJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(dayJcb, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_7, Alignment.LEADING)
						.addComponent(selfIntroductionText, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);//居中显示
		
	}
	
	/*
	 * 修改事件的处理
	 */
	protected void updateActionPerformed(ActionEvent e) {
		String nickname = this.userNicknameText.getText();
		String sex = "";
		String selfIntroduction = this.selfIntroductionText.getText();
		String year = this.yearJcb.getSelectedItem().toString();
		String month = this.monthJcb.getSelectedItem().toString();
		String day = this.dayJcb.getSelectedItem().toString();
		StringBuffer birthday = new StringBuffer(year);
		birthday.append("-");
		birthday.append(month);
		birthday.append("-");
		birthday.append(day);
		int flag = 0;
		
		//获取用户输入的数据
		if (nickname == null || "".equals(nickname)) {
			JOptionPane.showMessageDialog(null, "昵称不能为空");
			return;
		}
		if (manJcb.isSelected()) {
			sex = "男";
		}else if (womanJcb.isSelected()) {
			sex = "女";
		}else {
			JOptionPane.showMessageDialog(null, "请选择性别");
			return;
		}
		if (selfIntroduction == null || "".equals(selfIntroduction)) {
			JOptionPane.showMessageDialog(null, "请输入简单的自我介绍");
			return;
		}
				
		UserDetails userDetails = new UserDetails(null, nickname, sex, birthday.toString(), selfIntroduction, loginRecord.recordUserId);
		flag = userDetailsDao.updateUserDetails(userDetails);
		//修改笔记详情表对应的publisher_nickname
		NotesDetails notesDetails = new NotesDetails(nickname, loginRecord.recordUserId);
		flag = notesDetailsDao.updateNotesPublisherNickname(notesDetails);
				
		if (flag != 0) {//修改成功
			JOptionPane.showMessageDialog(null, "修改成功");
			dispose();
		}else {//修改失败
			JOptionPane.showMessageDialog(null, "修改失败");
		}
	}
	
}
