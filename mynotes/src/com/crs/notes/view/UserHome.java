package com.crs.notes.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Table;

import com.crs.notes.entity.*;
import com.crs.notes.util.*;
import com.crs.notes.bean.LoginRecord;
import com.crs.notes.dao.*;
import com.crs.notes.entity.*;
import com.crs.notes.util.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;

public class UserHome extends JFrame {

	private JPanel userHomePage;
	private final Action action = new SwingAction();
	private JTable userHomeTable;
	private JTextField userHomeSelectText;
	private JMenu userNickname;
	private NotesDetailsDao notesDetailsDao = new NotesDetailsDao();
	private UserDetailsDao userDetailsDao = new UserDetailsDao();
	private LoginRecord loginRecord;
	private int currPage = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHome frame = new UserHome();
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
	public UserHome() {
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 717, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 469, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		setTitle("?????????");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 771);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		userNickname = new JMenu("???");
		menuBar.add(userNickname);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("????????????");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userDetailsActionPerformed(e);				
			}
		});
		userNickname.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("????????????");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePasswordFrm changePasswordFrm = new ChangePasswordFrm();
				changePasswordFrm.setVisible(true);
			}
		});
		userNickname.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("????????????");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//?????????0????????????1
				int isExit = JOptionPane.showConfirmDialog(null, "??????????????????");
				if(isExit == 0) {
					dispose();
					LoginHome loginHome = new LoginHome();
					loginHome.setVisible(true);
				}
			}
		});
		userNickname.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("????????????");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("????????????");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NotesInsertFrm notesInsertFrm = new NotesInsertFrm();
				notesInsertFrm.setVisible(true);
//				userHomePage.add(notesInsertFrm);
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("????????????");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyPublishFrm myPublish = new MyPublishFrm();
				myPublish.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("?????????");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("????????????");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JButton btnNewButton = new JButton("????????????");
		menuBar.add(btnNewButton);
		userHomePage = new JPanel();
		userHomePage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(userHomePage);
		
		userHomeSelectText = new JTextField();
		userHomeSelectText.setColumns(10);
		
		JButton userHomeSelectButton = new JButton("??????");
		userHomeSelectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userHomeSelectActionPerformed(e);
			}
		});
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnNewButton_1 = new JButton("?????????");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previousPageActionPerformed(e);
			}
		});
		
		JButton btnNewButton_2 = new JButton("?????????");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextPageActionPerformed(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton_3 = new JButton("??????");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshNotesTableActionPerformed(e);
			}
		});
		
		GroupLayout gl_userHomePage = new GroupLayout(userHomePage);
		gl_userHomePage.setHorizontalGroup(
			gl_userHomePage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_userHomePage.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_userHomePage.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_userHomePage.createSequentialGroup()
							.addComponent(userHomeSelectText, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(userHomeSelectButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_userHomePage.createSequentialGroup()
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(576)
							.addComponent(btnNewButton_1)
							.addGap(28)
							.addComponent(btnNewButton_2)
							.addGap(10))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 819, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_userHomePage.setVerticalGroup(
			gl_userHomePage.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_userHomePage.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_userHomePage.createParallelGroup(Alignment.BASELINE)
						.addComponent(userHomeSelectText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(userHomeSelectButton)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
					.addGroup(gl_userHomePage.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addContainerGap())
		);
		
		userHomeTable = new JTable();
		userHomeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				userHomeTableMousePressed(e);
			}
		});
		userHomeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7B14\u8BB0\u7F16\u53F7", "\u7B14\u8BB0\u6807\u9898", "\u66F4\u65B0\u65F6\u95F4", "\u4F5C\u8005", "\u70B9\u8D5E\u6570"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		userHomeTable.getColumnModel().getColumn(0).setPreferredWidth(60);
		userHomeTable.getColumnModel().getColumn(1).setPreferredWidth(240);
		userHomeTable.getColumnModel().getColumn(2).setPreferredWidth(116);
		userHomeTable.getColumnModel().getColumn(3).setPreferredWidth(104);
		scrollPane.setViewportView(userHomeTable);
		userHomePage.setLayout(gl_userHomePage);
		this.setLocationRelativeTo(null);//????????????
		
		this.fillNotesTable(new NotesDetails(), 0);
	}

	/**
	 * ?????????????????????
	 * @param e
	 */
	protected void refreshNotesTableActionPerformed(ActionEvent e) {
		this.fillNotesTable(new NotesDetails(), 0);
		
	}

	/**
	 * ???????????????????????????
	 * @param e
	 */
	protected void userDetailsActionPerformed(ActionEvent e) {
		UserDetailsFrm userDetailsFrm = new UserDetailsFrm();
		userDetailsFrm.setVisible(true);
		
		JdbcUtil jdbcUtil = new JdbcUtil();
		ResultSet rs = null;
		try {
			int userId = loginRecord.recordUserId;
			rs = userDetailsDao.selectUserDetails(jdbcUtil, userId);
			
			while (rs.next()) {
				userDetailsFrm.userNicknameText.setText(rs.getString("user_nickname"));
				userDetailsFrm.selfIntroductionText.setText(rs.getString("user_desc"));
				if ("???".equals(rs.getString("user_sex"))) {
					userDetailsFrm.manJcb.setSelected(true);
				} else if ("???".equals(rs.getString("user_sex"))) {
					userDetailsFrm.womanJcb.setSelected(true);
				}
				String birthday = rs.getString("user_birthday");
				String year = birthday.substring(0, 4);
				String month = birthday.substring(5, 7);
				String day = birthday.substring(8, 10);
				userDetailsFrm.yearJcb.addItem(year);
				userDetailsFrm.monthJcb.addItem(month);
				userDetailsFrm.dayJcb.addItem(day);
			}
			this.fillBirthday(userDetailsFrm.yearJcb, userDetailsFrm.monthJcb, userDetailsFrm.dayJcb);
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			jdbcUtil.close();
		}
		
		
	}

	/**
	 * ?????????????????????????????????????????????
	 * @param e
	 */
	protected void userHomeSelectActionPerformed(ActionEvent e) {
		String notesTitle = this.userHomeSelectText.getText();
		String userNickname = this.userHomeSelectText.getText();	
		
		NotesDetails notesDetails = new NotesDetails(notesTitle, userNickname);
		this.fillNotesTable(notesDetails, 0);		
	}

	/**
	 * ??????????????????????????????????????????
	 * @param e
	 */
	protected void userHomeTableMousePressed(MouseEvent e) {
		NotesDetailsFrm notesDetailsFrm = new NotesDetailsFrm();
		notesDetailsFrm.setVisible(true);		
		int row =  this.userHomeTable.getSelectedRow();
		int notesId = Integer.parseInt(userHomeTable.getValueAt(row, 0).toString());
		
			ResultSet rs = null;
			JdbcUtil utilSearch = new JdbcUtil();
			try {
				rs = notesDetailsDao.selectNotes(utilSearch, notesId);
				while(rs.next()) {
			        notesDetailsFrm.dNewsTitleText.setText(rs.getString("notes_title"));
			        notesDetailsFrm.dPublisherText.setText(rs.getString("publisher_nickname"));
			        notesDetailsFrm.dInformationText.setText(rs.getString("notes_desc"));
			        notesDetailsFrm.dPublishTimeText.setText(rs.getString("add_time"));
			        notesDetailsFrm.lastTimeText.setText(rs.getString("last_time"));
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
	 * ?????????????????????
	 * @param e
	 */
	protected void nextPageActionPerformed(ActionEvent e) {
		currPage++;
		int totalCount = notesDetailsDao.getTotalCount();
		int totalPage = (totalCount + 10 -1) / 10;
		if (currPage > totalPage) {
			JOptionPane.showMessageDialog(null, "??????????????????");
			return;
		}else {
			this.fillNotesTable( new NotesDetails(), (currPage-1) * 10 );
		}		
	}

	/**
	 * ?????????????????????
	 * @param e
	 * @throws Exception 
	 */
	protected void previousPageActionPerformed(ActionEvent e) {
		currPage--;
		if (currPage < 1) {
			JOptionPane.showMessageDialog(null, "???????????????");
			return;
		}else {
			this.fillNotesTable( new NotesDetails(), (currPage-1) * 10 );
		}		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	/**
	 * ?????????????????????
	 */
	private void fillNotesTable (NotesDetails notesDetails, int startIndex) {
		DefaultTableModel dtm = (DefaultTableModel) userHomeTable.getModel();
		dtm.setRowCount(0);//?????????0????????????????????????
		ResultSet rs = null;
		JdbcUtil utilSearch = new JdbcUtil();
		try {
			rs = notesDetailsDao.selectNotes(utilSearch, notesDetails, startIndex);
			while(rs.next()) {
		        Vector v = new Vector();//????????????
				//id??????getString?????????getInt?????????????????????????????????????????????setText(String)????????????String
		     	v.add(rs.getString("notes_details_id"));
				v.add(rs.getString("notes_title"));
				v.add(rs.getString("last_time"));
				v.add(rs.getString("publisher_nickname"));
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
	
	/**
	 * ????????????????????????????????????(??????????????????)
	 */
	private void fillBirthday(JComboBox yearJcb, JComboBox monthJcb, JComboBox dayJcb) {
		//????????????????????????
		for(int i = 2021; i > 1900; i--) {
			yearJcb.addItem(i);
		}
		
		//????????????????????????
		//???????????????????????????????????????????????????for?????????????????????
		monthJcb.addItem("01");
		monthJcb.addItem("02");
		monthJcb.addItem("03");
		monthJcb.addItem("04");
		monthJcb.addItem("05");
		monthJcb.addItem("06");
		monthJcb.addItem("07");
		monthJcb.addItem("08");
		monthJcb.addItem("09");
		monthJcb.addItem("10");
		monthJcb.addItem("11");
		monthJcb.addItem("12");
		
		
		//????????????????????????
//		this.dayJcb.addItem("???");
		dayJcb.addItem("01");
		dayJcb.addItem("02");
		dayJcb.addItem("03");
		dayJcb.addItem("04");
		dayJcb.addItem("05");
		dayJcb.addItem("06");
		dayJcb.addItem("07");
		dayJcb.addItem("08");
		dayJcb.addItem("09");
		for (int i = 10; i < 32; i++) {
			dayJcb.addItem(i);
		}
		
	}
}



