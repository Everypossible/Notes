package com.crs.notes.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.crs.notes.bean.LoginRecord;
import com.crs.notes.util.JdbcUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ChangePasswordFrm extends JFrame {

	private JPanel contentPane;
	private JPasswordField originPasswordText;
	private JPasswordField newPasswordText;
	
	private LoginRecord loginRecord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePasswordFrm frame = new ChangePasswordFrm();
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
	public ChangePasswordFrm() {
		setTitle("修改密码");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("原密码");
		
		originPasswordText = new JPasswordField();
		
		JLabel lblNewLabel_1 = new JLabel("新密码");
		
		newPasswordText = new JPasswordField();
		
		JButton btnNewButton = new JButton("确认修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePasswordActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(53)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(originPasswordText, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
								.addComponent(newPasswordText, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(159)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(originPasswordText, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(newPasswordText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addComponent(btnNewButton)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * 修改密码事件的处理
	 * @param e
	 */
	protected void updatePasswordActionPerformed(ActionEvent e) {
		String originPassword = new String(this.originPasswordText.getPassword());
		String newPassword = new String(this.newPasswordText.getPassword());
		
		if (originPassword == null || "".equals(originPassword)) {
			JOptionPane.showMessageDialog(null, "请输入原密码");
			return;
		}
		if (newPassword == null || "".equals(newPassword)) {
			JOptionPane.showMessageDialog(null, "新密码不能为空");
			return;
		}
		if (!(originPassword.equals(loginRecord.recordPassword))) {
			JOptionPane.showMessageDialog(null, "原密码输入错误");
			return;
		}
		
		String sql = "update account set account_password=? where account_id=?";
	      JdbcUtil utilupdate = new JdbcUtil();
	      PreparedStatement carupdate = null;
	      int flag = 0;
	
	      try {
	          carupdate = utilupdate.getCar(sql);
	          carupdate.setString(1, newPassword);
	          carupdate.setInt(2, loginRecord.recordUserId);
	          
	          flag = carupdate.executeUpdate();
	          if (flag != 0) {
				JOptionPane.showMessageDialog(null, "修改成功");
				dispose();
	          }else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
	      } catch (SQLException e2) {
	          e2.printStackTrace();
	      } finally {
	          utilupdate.close();
	      }
	}
}
