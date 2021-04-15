package com.crs.notes.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.crs.notes.dao.UserDetailsDao;
import com.crs.notes.util.JdbcUtil;

public class AdminHome extends JFrame {

	private JPanel jpanel;
	private JTable adminHomeTable;
	
	private UserDetailsDao userDetailsDao = new UserDetailsDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		setTitle("管理员");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 735);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("基本数据维护");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("管理用户");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("笔记分组");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("创建分组");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertNotesGroupFrm insertNotesGroupFrm = new InsertNotesGroupFrm();
				insertNotesGroupFrm.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("管理分组");
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("管理笔记");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("关于我们");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("关于笔记社区");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		jpanel = new JPanel();
		jpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(jpanel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_jpanel = new GroupLayout(jpanel);
		gl_jpanel.setHorizontalGroup(
			gl_jpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpanel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 883, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_jpanel.setVerticalGroup(
			gl_jpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpanel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		adminHomeTable = new JTable();
		adminHomeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7528\u6237ID", "\u7528\u6237\u8D26\u53F7", "\u7528\u6237\u6635\u79F0", "\u7528\u6237\u6027\u522B", "\u7528\u6237\u751F\u65E5", "\u81EA\u6211\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		adminHomeTable.getColumnModel().getColumn(5).setPreferredWidth(91);
		scrollPane.setViewportView(adminHomeTable);
		jpanel.setLayout(gl_jpanel);
		this.setLocationRelativeTo(null);//居中显示
		
		this.fillAdminHomeTable();
	}
	
	/**
	 * 初始化管理员主页的表格
	 */
	private void fillAdminHomeTable() {
		DefaultTableModel dtm = (DefaultTableModel) adminHomeTable.getModel();
		dtm.setRowCount(0);//设置成0行（即清空表格）
		ResultSet rs = null;
		JdbcUtil utilSearch = new JdbcUtil();
		try {
			rs = userDetailsDao.selectAllUser(utilSearch);
			while(rs.next()) {
		        Vector v = new Vector();//线程安全
				//id只能getString而不能getInt，因为后面读取这个数据时用到的setText(String)只能传入String
		     	v.add(rs.getString("account_id"));
				v.add(rs.getString("account_name"));
				v.add(rs.getString("user_nickname"));
				v.add(rs.getString("user_sex"));
				v.add(rs.getString("user_birthday"));
				v.add(rs.getString("user_desc"));
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
