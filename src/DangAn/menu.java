package DangAn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class menu extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel lblNewLabel; // 修改密码时的姓名
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { menu frame = new menu();
	 * frame.setVisible(true);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public menu() {
		getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(92, 83, 54, 15);
		getContentPane().add(lblNewLabel_1);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 27);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("\u4E2A\u4EBA\u4FE1\u606F");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenu mnNewMenu_1 = new JMenu("\u6210\u5458\u4FE1\u606F");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u6210\u5458\u5217\u8868");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonList person;
				try {
					person = new PersonList();
					person.setVisible(true);
				} catch (BadLocationException | IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u65B0\u589E\u6210\u5458");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPerson addP = new AddPerson();
				addP.setVisible(true);
				addP.setLblNewLabel(lblNewLabel.getText());
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u4FEE\u6539\u4FE1\u606F");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPerson addP = new AddPerson();
				addP.setVisible(true);
				addP.setLblNewLabel(lblNewLabel.getText());
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_2 = new JMenu("\u6587\u4EF6\u4FE1\u606F");
		menuBar.add(mnNewMenu_2);

		JMenuItem menuItem = new JMenuItem("\u6587\u4EF6\u5217\u8868");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileJframe file;
				try {
					file = new FileJframe();
					file.setVisible(true);
				} catch (IllegalStateException | BadLocationException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		mnNewMenu_2.add(menuItem);

		JButton btnNewButton = new JButton("\u6CE8\u9500");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concel adm = new concel();
				adm.setVisible(true);
			}
		});
		btnNewButton.setBounds(367, 238, 67, 23);
		contentPane.add(btnNewButton);

		JLabel label = new JLabel("\u5F53\u524D\u767B\u5F55\u4EBA\u5458\uFF1A");
		label.setBounds(341, 37, 93, 15);
		contentPane.add(label);

		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(10, 40, 321, 221);
		contentPane.add(panel);
		panel.setVisible(false);
		panel.setLayout(null);

		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(34, 21, 54, 15);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\u539F\u59CB\u5BC6\u7801\uFF1A");
		label_2.setBounds(34, 43, 85, 15);
		panel.add(label_2);

		JLabel label_3 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_3.setBounds(34, 68, 85, 15);
		panel.add(label_3);

		JLabel label_4 = new JLabel("\u518D\u6B21\u8F93\u5165\uFF1A");
		label_4.setBounds(34, 93, 85, 15);
		panel.add(label_4);

		lblNewLabel = new JLabel("      ");
		lblNewLabel.setBounds(142, 21, 87, 15);
		panel.add(lblNewLabel);

		JLabel label_5 = new JLabel("\u804C\u79F0\uFF1A");
		label_5.setBounds(34, 121, 54, 15);
		panel.add(label_5);

		final JLabel lblAdministrator = new JLabel("administrator");
		lblAdministrator.setBounds(139, 121, 90, 15);
		panel.add(lblAdministrator);

		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd = passwordField.getText();
				String pwd1 = passwordField_1.getText();
				String pwd2 = passwordField_2.getText();
				try {
					if (DataProcessing.updateUser(lblNewLabel.getText(), pwd1, lblAdministrator.getText())
							&& pwd1.equals(pwd2))
						label_8.setText("修改成功！");
					else
						label_8.setText("修改失败！");
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		button.setBounds(103, 146, 93, 23);
		panel.add(button);

		label_8 = new JLabel("    ");
		label_8.setBounds(117, 185, 79, 15);
		panel.add(label_8);

		passwordField = new JPasswordField();
		passwordField.setBounds(129, 40, 100, 21);
		panel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(129, 65, 100, 21);
		panel.add(passwordField_1);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(129, 90, 100, 21);
		panel.add(passwordField_2);

		label_7 = new JLabel("                  ");
		label_7.setBounds(341, 62, 93, 15);
		contentPane.add(label_7);

		/*
		 * UpdateF upF = new UpdateF(); upF.setTextField_1(label_7.getText());
		 */

	}

	public JLabel getLabel_7() {
		return label_7;
	}

	public void setlblNewLabel(String string) {
		this.lblNewLabel.setText(string);
	}

	public void setLabel_7(String label_7) {
		this.label_7.setText(label_7);
	}
}
