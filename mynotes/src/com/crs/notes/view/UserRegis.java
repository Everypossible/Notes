package com.crs.notes.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;

public class UserRegis extends JFrame {

	private JPanel contentPane;
	private JTextField userNameRegisText;
	private JPasswordField passwordRegisterText;
	private AccountDao accountDao = new AccountDao();
	private UserDetailsDao userDetailsDao = new UserDetailsDao();
	private JTextField userNicknameText;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton manJcb;
	private JRadioButton womanJcb;
	private JComboBox yearJcb;
	private JComboBox monthJcb;
	private JComboBox dayJcb;
	private JTextArea selfIntroductionText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegis frame = new UserRegis();
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
	public UserRegis() {
		setTitle("注册");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 668, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("注册");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1 = new JLabel("用户名");
		
		JLabel lblNewLabel_2 = new JLabel("密码");
		
		userNameRegisText = new JTextField();
		userNameRegisText.setColumns(10);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisActionPerformed(e);
			}
		});
		
		passwordRegisterText = new JPasswordField();
		
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
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(73)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(selfIntroductionText, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(78)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNewLabel_1)
												.addComponent(lblNewLabel_5)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(lblNewLabel_6)
													.addComponent(lblNewLabel_2)))
											.addGap(27))
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(userNicknameText)
											.addComponent(userNameRegisText, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
											.addComponent(passwordRegisterText))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(manJcb, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
													.addGap(43))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(yearJcb, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(monthJcb, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(womanJcb, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
													.addGap(9))
												.addComponent(dayJcb, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(250)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(259)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(25))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(userNameRegisText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNicknameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordRegisterText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(womanJcb)
						.addComponent(manJcb)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(dayJcb, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(monthJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yearJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(selfIntroductionText, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(66))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);//居中显示
		
		this.fillBirthday();
	}
	
	/*
	 * 注册事件的处理
	 */
	protected void RegisActionPerformed(ActionEvent e) {
		String name = this.userNameRegisText.getText();
		String nickname = this.userNicknameText.getText();
		String pwd = new String(this.passwordRegisterText.getPassword());
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
		int accountId = 0;
		int flag = 0;
		
		//获取用户输入的数据
		if (name == null || name.equals("")) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (pwd == null || pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
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
		if ("年".equals(year) || "月".equals(month) || "日".equals(day)) {
			JOptionPane.showMessageDialog(null, "请选择出生日期");
			return;
		}
		if (selfIntroduction == null || "".equals(selfIntroduction)) {
			JOptionPane.showMessageDialog(null, "请输入简单的自我介绍");
			return;
		}
		
		
		Account userAccount = new Account(null, name, pwd, 0);		
		accountId = accountDao.insert(userAccount);
		UserDetails userDetails = new UserDetails(null, nickname, sex, birthday.toString(), selfIntroduction, accountId);
		flag = userDetailsDao.insert(userDetails);
		if (accountId != 0 && flag != 0) {//注册成功
			dispose();
			new LoginHome().setVisible(true);
		}else {//注册失败
			JOptionPane.showMessageDialog(null, "注册失败");
		}
	}
	
	/**
	 * 封装生日下拉框的内容显示(初始化下拉框)
	 */
	private void fillBirthday() {
		//初始化年份下拉表
		this.yearJcb.addItem("年");
		for(int i = 2021; i > 1900; i--) {
			this.yearJcb.addItem(i);
		}
		
		//初始化月份下拉表
		this.monthJcb.addItem("月");
		this.monthJcb.addItem("01");
		this.monthJcb.addItem("02");
		this.monthJcb.addItem("03");
		this.monthJcb.addItem("04");
		this.monthJcb.addItem("05");
		this.monthJcb.addItem("06");
		this.monthJcb.addItem("07");
		this.monthJcb.addItem("08");
		this.monthJcb.addItem("09");
		this.monthJcb.addItem("10");
		this.monthJcb.addItem("11");
		this.monthJcb.addItem("12");
		
		//初始化日期下拉表
		this.dayJcb.addItem("日");
		this.dayJcb.addItem("01");
		this.dayJcb.addItem("02");
		this.dayJcb.addItem("03");
		this.dayJcb.addItem("04");
		this.dayJcb.addItem("05");
		this.dayJcb.addItem("06");
		this.dayJcb.addItem("07");
		this.dayJcb.addItem("08");
		this.dayJcb.addItem("09");
		for (int i = 10; i < 32; i++) {
			this.dayJcb.addItem(i);
		}
		
	}
}
