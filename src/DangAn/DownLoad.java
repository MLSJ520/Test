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
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DownLoad extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label_2;
	private JLabel label_1;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { DownLoad frame = new DownLoad();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 */

	/**
	 * Create the frame.
	 */
	public DownLoad() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u6587\u4EF6\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(62, 46, 66, 15);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(154, 43, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("\u4E0B\u8F7D\u5730\u5740\uFF1A");
		label.setBounds(62, 89, 66, 15);
		contentPane.add(label);

		textField_1 = new JTextField();
		textField_1.setBounds(154, 86, 175, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText();
				String Path = textField_1.getText();
				try {
					if (Operater.downloadFile(num, Path)) {
						label_1.setText("文件下载成功！");
					} else
						label_1.setText("文件下载失败！");
				} catch (IOException | IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(120, 149, 93, 23);
		contentPane.add(button);

		label_1 = new JLabel("");
		label_1.setBounds(90, 201, 141, 15);
		contentPane.add(label_1);

		label_2 = new JLabel(" ");
		label_2.setBounds(368, 214, 66, 15);
		contentPane.add(label_2);

		JButton button_1 = new JButton("\u6CE8\u9500");
		button_1.setBounds(368, 238, 66, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				concel adm = new concel();
				adm.setVisible(true);
			}
		});
		contentPane.add(button_1);
	}

	public void setlabel_2(String string) {
		label_2.setText(string);
	}
}
