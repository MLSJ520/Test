package DangAn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Bmenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPanel panel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel;
	private JLabel label_8;
	Scanner in = new Scanner(System.in);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bmenu frame = new Bmenu();
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
	public Bmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);

		JMenu menu = new JMenu("\u4E2A\u4EBA\u4FE1\u606F");
		menuBar.add(menu);

		JMenuItem menuItem_1 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
			}
		});
		menu.add(menuItem_1);

		JMenu menu_1 = new JMenu("\u6587\u4EF6");
		menuBar.add(menu_1);

		JMenuItem menuItem_2 = new JMenuItem("\u6587\u4EF6\u5217\u8868");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileJframe filelist;
				try {
					filelist = new FileJframe();
					filelist.setVisible(true);
					filelist.getButton_1().setVisible(false);
				} catch (IllegalStateException | BadLocationException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		menu_1.add(menuItem_2);

		JMenuItem menuItem = new JMenuItem("\u4E0B\u8F7D\u6587\u4EF6");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DownLoad downfile = new DownLoad();
				downfile.setVisible(true);
			}
		});
		menu_1.add(menuItem);

		JButton button = new JButton("\u6CE8\u9500");
		button.setBounds(374, 238, 63, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concel con = new concel();
				con.setVisible(true);
			}
		});
		contentPane.add(button);

		JLabel label = new JLabel("\u5F53\u524D\u767B\u5F55\uFF1A");
		label.setBounds(373, 186, 76, 15);
		contentPane.add(label);

		textField = new JTextField();
		textField.setBounds(371, 207, 63, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(10, 45, 305, 216);
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

		lblNewLabel = new JLabel("       ");
		lblNewLabel.setBounds(142, 21, 87, 15);
		panel.add(lblNewLabel);

		textField_1 = new JTextField();
		/*
		 * textField_1.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { String pwd1 = in.nextLine();
		 * textField_1.setText(pwd1); } });
		 */
		textField_1.setBounds(129, 40, 100, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		textField_2.setBounds(129, 65, 100, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(129, 90, 100, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(117, 159, 54, 15);
		panel.add(lblNewLabel_1);

		JLabel label_5 = new JLabel("\u804C\u79F0\uFF1A");
		label_5.setBounds(34, 121, 54, 15);
		panel.add(label_5);

		JLabel label_6 = new JLabel("\u6D4F\u89C8\u4EBA\u5458");
		label_6.setBounds(152, 121, 77, 15);
		panel.add(label_6);

		label_8 = new JLabel("\u4FEE\u6539\u6210\u529F\uFF01");
		label_8.setBounds(117, 191, 64, 15);
		label_8.setVisible(false);
		panel.add(label_8);

		JButton button_1 = new JButton("\u786E\u5B9A");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd = textField_1.getText();
				String pwd1 = textField_2.getText();
				String pwd2 = textField_3.getText();
				try {
					if (DataProcessing.searchUser(lblNewLabel.getText(), pwd) != null) {
						if (pwd1 == pwd2) {
							label_8.setVisible(true);
						} else
							label_8.setText("ÐÞ¸ÄÊ§°Ü");
						label_8.setVisible(true);
					} else
						label_8.setText("ÐÞ¸ÄÊ§°Ü");
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				label_8.setVisible(true);
			}
		});
		button_1.setBounds(100, 151, 93, 23);
		panel.add(button_1);
	}

	public void SetlblNewLabel(String string) {
		lblNewLabel.setText(string);
	}
}
