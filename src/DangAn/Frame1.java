package DangAn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Hashtable;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Frame1 extends JFrame {

	private JPanel contentPane; // 面板
	private JTextField textField; // 姓名输入框
	private JButton btnNewButton; // 确定按钮
	private JButton btnNewButton_1; // 注册按钮
	private JLabel label_3; // 登录提示文本
	private JPasswordField passwordField; // 密码框
	/**
	 * Launch the application.
	 */

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Frame1 frame = new Frame1();
	 * frame.setVisible(true);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public Frame1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("登录");

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name1 = textField.getText();
				String paw = passwordField.getText();
				try {
					User temp;
					temp = DataProcessing.searchUser(name1);
					if (DataProcessing.searchUser(name1, paw) != null) {
						dispose();
						LonIn su = new LonIn();
						su.setVisible(true);
						su.setAlwaysOnTop(true);

						String role = temp.getRole();
						switch (role) {
						case "administrator":
							menu Adm = new menu();
							/*
							 * UpdateF upF = new UpdateF();
							 * upF.setTextField_1(name1);
							 */
							Adm.setVisible(true);
							// Adm.setAlwaysOnTop(true);
							Adm.setLabel_7(name1);
							Adm.setlblNewLabel(name1);
							break;
						case "broswer":
							Bmenu Bro = new Bmenu();
							Bro.setVisible(true);
							Bro.SetlblNewLabel("浏览员" + name1);
							break;
						case "operator":
							break;
						default:
							break;
						}
					} else if (temp == null)
						label_3.setText("查无此人，请注册！");
					else
						label_3.setText("密码错误，请重新输入！");
				} catch (IllegalStateException | SecurityException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnNewButton.setBounds(79, 170, 102, 38);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.setBounds(274, 170, 102, 38);
		contentPane.add(btnNewButton_1);

		JLabel label = new JLabel("****\u6B22\u8FCE\u8FDB\u5165\u6863\u6848\u7BA1\u7406\u7CFB\u7EDF****");
		label.setFont(new Font("楷体", Font.BOLD, 17));
		label.setBounds(79, 10, 297, 36);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 13));
		label_1.setBounds(128, 64, 42, 21);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u5BC6\u7801");
		label_2.setFont(new Font("幼圆", Font.PLAIN, 13));
		label_2.setBounds(128, 95, 54, 15);
		contentPane.add(label_2);

		textField = new JTextField();
		textField.setBounds(180, 64, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		label_3 = new JLabel(" ");
		label_3.setFont(new Font("幼圆", Font.BOLD, 12));
		label_3.setBounds(138, 129, 179, 21);
		contentPane.add(label_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(180, 92, 116, 21);
		contentPane.add(passwordField);
	}

	public String getTextField() {
		return textField.getText();
	}

	public void setlabel_3(String string) {
		label_3.setText(string);
	}
}
