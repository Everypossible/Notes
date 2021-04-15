package com.crs.notes.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.crs.notes.bean.LoginRecord;
import com.crs.notes.dao.NotesGroupDao;
import com.crs.notes.entity.NotesDetails;
import com.crs.notes.entity.NotesGroup;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class InsertNotesGroupFrm extends JFrame {

	private JPanel contentPane;
	private JTextField insertNotesGroupNameText;
	
	private NotesGroupDao notesGroupDao = new NotesGroupDao();
	private LoginRecord loginRecord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertNotesGroupFrm frame = new InsertNotesGroupFrm();
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
	public InsertNotesGroupFrm() {
		setAlwaysOnTop(true);
		setTitle("创建分组");
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
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("分组名称");
		
		insertNotesGroupNameText = new JTextField();
		insertNotesGroupNameText.setColumns(10);
		
		JButton btnNewButton = new JButton("确认创建");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertNotesGroupActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(76)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(insertNotesGroupNameText, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(159)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(insertNotesGroupNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addComponent(btnNewButton)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * 对创建分组事件的处理
	 */
	protected void insertNotesGroupActionPerformed(ActionEvent e) {
		String newGroupName = insertNotesGroupNameText.getText();
		
		if (newGroupName == null || newGroupName.equals("")) {
			JOptionPane.showMessageDialog(null, "分组名不能为空");
			return;
		}
		
		//获取当前时间
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		
		NotesGroup notesGroup = new NotesGroup(newGroupName, dateString, dateString, loginRecord.recordUserId);
		
		try {
			int line = notesGroupDao.insert(notesGroup);
			if (line == 1) {
				JOptionPane.showMessageDialog(null, "创建成功");
				dispose();
//				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "创建失败");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "创建失败");
		}
	}
}
