package com.crs.notes.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.SystemTray;
import java.awt.TrayIcon;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import com.crs.notes.bean.LoginRecord;
import com.crs.notes.dao.*;
import com.crs.notes.entity.*;
import com.crs.notes.util.JdbcUtil;

import java.util.*;
import javax.swing.JCheckBox;

public class LoginHome extends JFrame {

	private JPanel contentPane;
	private JTextField userNameText;
	private JPasswordField passwordText;
	private JComboBox userBoxText;
	private AccountDao accountDao = new AccountDao();
	private LoginRecord loginRecord = new LoginRecord();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginHome frame = new LoginHome();
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
	
	public LoginHome() {
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("笔记社区");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("用户名");
		
		userNameText = new JTextField();
		userNameText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("密码");
		
		passwordText = new JPasswordField();
		
		JLabel lblNewLabel_3 = new JLabel("权限");
		
		userBoxText = new JComboBox();
		userBoxText.setModel(new DefaultComboBoxModel(new String[] {"用户", "管理员"}));
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoginActionPreformed(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisActionPerformed(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("重置");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(102)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGap(44)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(50))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(passwordText, Alignment.LEADING)
										.addComponent(userNameText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
										.addComponent(lblNewLabel, Alignment.LEADING))
									.addPreferredGap(ComponentPlacement.RELATED, 4, Short.MAX_VALUE)))
							.addGap(1)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(541))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userBoxText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNewLabel)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(userBoxText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_2))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);//居中显示
		
	}
	
	/*
	 * 注册事件的处理
	 */
	protected void RegisActionPerformed(ActionEvent e) {
		String quanxian= (String)this.userBoxText.getSelectedItem();
		if (quanxian.equals("用户")) {
			dispose();//销毁当前窗体
			new UserRegis().setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "管理员请先登录");
		}
		
	}

	/*
	 * 重置事件的处理
	 */
	protected void ResetActionPerformed(ActionEvent e) {
		reset();
		
	}
	
	/*
	 * 重置功能的实现
	 */
	public void reset() {
		this.userNameText.setText("");
		this.passwordText.setText("");
	}

	/*
	 * 对登录事件进行处理
	 */
	protected void LoginActionPreformed(ActionEvent e) throws Exception {
		String name = this.userNameText.getText();
		String pwd = new String(this.passwordText.getPassword());
		Integer identity = null;
		
		if (name == null || name.equals("")) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (pwd == null || pwd.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		String quanxian= (String)this.userBoxText.getSelectedItem();
		if (quanxian.equals("用户")) {
			identity = 0;
			int flag = accountDao.login(name, pwd, identity);
			if (flag != 0) {
				dispose();
				new UserHome().setVisible(true);
				ResultSet resultSet = accountDao.selectUser(new JdbcUtil(), name);
				while (resultSet.next()) {
					loginRecord.recordUserId = resultSet.getInt("account_id");	
				}
				loginRecord.recordUserName = name;
				loginRecord.recordPassword = pwd;
			}else {
				JOptionPane.showMessageDialog(null, "登录失败,账号或密码错误");
			}
		}else {
			identity = 1;
			int flag = accountDao.login(name, pwd, identity);
			if (flag != 0) {
				dispose();
				new AdminHome().setVisible(true);
				ResultSet resultSet = accountDao.selectUser(new JdbcUtil(), name);
				while (resultSet.next()) {
					loginRecord.recordUserId = resultSet.getInt("account_id");	
				}
				loginRecord.recordUserName = name;
			}else {
				JOptionPane.showMessageDialog(null, "登录失败,账号或密码错误");
			}
		}

	}
}

