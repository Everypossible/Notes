package com.crs.notes.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class NotesDetailsFrm extends JFrame {
	public JTextField dNewsTitleText;
	public JTextField dPublisherText;
	public JTextField dPublishTimeText;
	public JTextField dNewsLikeText;
	public JTextArea dCommentPublishText;
	public JTextArea dCommentRecordText;
	public JTextArea dInformationText;
	public JTextField lastTimeText;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotesDetailsFrm frame = new NotesDetailsFrm();
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
	public NotesDetailsFrm() {
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		
		getContentPane().setLayout(groupLayout);
		setTitle("笔记详情");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setBounds(100, 100, 595, 767);
		
		JPanel panel = new JPanel();
//		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("笔记标题");
		
		dNewsTitleText = new JTextField();
		dNewsTitleText.setEditable(false);
		dNewsTitleText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("发布者");
		
		dPublisherText = new JTextField();
		dPublisherText.setEditable(false);
		dPublisherText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("发布时间");
		
		dPublishTimeText = new JTextField();
		dPublishTimeText.setEditable(false);
		dPublishTimeText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("笔记内容");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_4 = new JLabel("评论");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblNewLabel_5 = new JLabel("点赞数");
		
		dNewsLikeText = new JTextField();
		dNewsLikeText.setEditable(false);
		dNewsLikeText.setColumns(10);
		
		JButton btnNewButton = new JButton("我要为其点赞");
		
		JButton btnNewButton_1 = new JButton("发布评论");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblNewLabel_6 = new JLabel("最近更新");
		
		lastTimeText = new JTextField();
		lastTimeText.setEditable(false);
		lastTimeText.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dNewsTitleText, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addGap(78)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dPublisherText, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(dNewsLikeText, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(btnNewButton)
							.addGap(87)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGap(54)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(dPublishTimeText, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblNewLabel_6)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lastTimeText))
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 518, GroupLayout.PREFERRED_SIZE)))
					.addGap(41))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(dNewsTitleText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(dPublisherText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2)
						.addComponent(dPublishTimeText, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(lastTimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(dNewsLikeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		
		dCommentPublishText = new JTextArea();
		scrollPane_2.setViewportView(dCommentPublishText);
		
		dCommentRecordText = new JTextArea();
		dCommentRecordText.setEditable(false);
		scrollPane_1.setViewportView(dCommentRecordText);
		
		dInformationText = new JTextArea();
		dInformationText.setEditable(false);
		scrollPane.setViewportView(dInformationText);
		dInformationText.setLineWrap(true);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
}
