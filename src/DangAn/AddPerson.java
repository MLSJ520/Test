package DangAn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AddPerson extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { try { AddPerson frame = new
	 * AddPerson(); frame.setVisible(true);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public AddPerson() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setBounds(66, 41, 70, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(66, 69, 70, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u518D\u6B21\u8F93\u5165\uFF1A");
		label_2.setBounds(66, 97, 70, 15);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u804C\u79F0\uFF1A");
		label_3.setBounds(66, 126, 70, 15);
		contentPane.add(label_3);

		textField = new JTextField();
		textField.setBounds(156, 38, 108, 18);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(156, 123, 108, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton button = new JButton("\u4FEE\u6539\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd = passwordField.getText();
				String pwd1 = passwordField_1.getText();
				String name = textField.getText();
				String role1 = textField_3.getText();
				try {
					if (DataProcessing.searchUser(name) != null && pwd1.equals(pwd)) {
						if (DataProcessing.updateUser(name, pwd, role1))
							lblNewLabel_1.setText("修改成功");
						else
							lblNewLabel_1.setText("修改失败");
					} else
						lblNewLabel_1.setText("修改失败");
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// JDBCText.

			}
		});
		button.setBounds(45, 176, 93, 23);
		contentPane.add(button);

		JLabel label_4 = new JLabel("\u7BA1\u7406\u5458\uFF1A");
		label_4.setBounds(370, 196, 54, 15);
		contentPane.add(label_4);

		lblNewLabel = new JLabel("         ");
		lblNewLabel.setBounds(370, 213, 54, 15);
		contentPane.add(lblNewLabel);

		JButton button_1 = new JButton("\u6CE8\u9500");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concel adm = new concel();
				adm.setVisible(true);
			}
		});
		button_1.setBounds(370, 238, 64, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("\u65B0\u589E\u6210\u5458");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd = passwordField.getText();
				String pwd1 = passwordField_1.getText();
				String name = textField.getText();
				String role1 = textField_3.getText();
				try {
					if ((name != "") && DataProcessing.insertUser(name, pwd, role1) && pwd1.equals(pwd)) {
						lblNewLabel_1.setText("新增成功");
					} else
						lblNewLabel_1.setText("新增失败");
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		button_2.setBounds(205, 176, 93, 23);
		contentPane.add(button_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(156, 66, 108, 21);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(156, 94, 108, 21);
		contentPane.add(passwordField_1);

		lblNewLabel_1 = new JLabel("              ");
		lblNewLabel_1.setBounds(134, 213, 93, 15);
		contentPane.add(lblNewLabel_1);

	}

	public void setLblNewLabel(String lblNewLabel1) {
		this.lblNewLabel.setText(lblNewLabel1);
	}
}
