package DangAn;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class UpdateF extends JFrame {

	private JPanel contentPane;
	private JTextField textField; // 代码
	private JTextField textField_1; // 创建者
	// private JTextField textField_2;
	private JTextField textField_3; // 简述
	private JTextField textField_4; // 上传文件
	private JTextField textField_5; // 上传地址
	private JLabel lblNewLabel;
	private JLabel label_5;
	private JTextField TimeBox;
	private SimpleDateFormat df;
	private Client client;
	private Sever server;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { UpdateF frame = new UpdateF();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 */

	/**
	 * Create the frame.
	 */
	public UpdateF() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u4EE3\u7801\uFF1A");
		label.setBounds(80, 36, 54, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u521B\u5EFA\u8005\uFF1A");
		label_1.setBounds(80, 63, 54, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u65F6\u95F4\uFF1A");
		label_2.setBounds(80, 88, 54, 15);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u7B80\u8FF0\uFF1A");
		label_3.setBounds(80, 114, 54, 15);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("\u6587\u4EF6\u540D\uFF1A");
		label_4.setBounds(80, 139, 54, 15);
		contentPane.add(label_4);

		textField = new JTextField();
		textField.setBounds(148, 33, 133, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		Frame1 frame = new Frame1();
		final String create = frame.getTextField();
		textField_1 = new JTextField(" ");
		textField_1.setText(create);
		textField_1.setBounds(148, 60, 133, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		TimeBox = new JTextField();
		TimeBox.setBounds(148, 85, 133, 21);
		// textField_2.setInputMap(condition, map);
		contentPane.add(TimeBox);
		TimeBox.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(148, 111, 133, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(148, 136, 133, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		final long longtime = date.getTime();
		TimeBox.setText(df.format(new Date(longtime)));

		JButton button = new JButton("\u4E0A\u4F20");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = textField.getText();

				String create = textField_1.getText();
				String timetamp = TimeBox.getText();
				String des = textField_3.getText();
				String filename = textField_4.getText();
				String filepath = textField_5.getText();

				// client = new Client();
				// client.Clint_Update(filename);

				try {
					// server = new Sever();
					/// server.SeverL(filename);
					// client = new Client();
					// client.Clint_Update(filepath);
					if (Operater.uploadFile(ID, create, des, timetamp, filename, filepath)) {
						lblNewLabel.setText("上传成功！");
					} else
						lblNewLabel.setText("上传失败！");
				} catch (IllegalStateException | IOException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(117, 206, 93, 23);

		contentPane.add(button);

		label_5 = new JLabel("");
		label_5.setBounds(370, 214, 54, 15);
		contentPane.add(label_5);

		JButton btnNewButton = new JButton("\u6CE8\u9500");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concel adm = new concel();
				adm.setVisible(true);
			}
		});
		btnNewButton.setBounds(370, 239, 64, 23);
		contentPane.add(btnNewButton);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(99, 236, 144, 15);
		contentPane.add(lblNewLabel);

		JLabel label_6 = new JLabel("\u5730\u5740\uFF1A");
		label_6.setBounds(80, 164, 54, 15);
		contentPane.add(label_6);

		textField_5 = new JTextField();
		textField_5.setBounds(148, 161, 133, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(String string) {
		textField_1.setText(string);
	}

	public void setlabel_5(String string) {
		label_5.setText(string);
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

}
