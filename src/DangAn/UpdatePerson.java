package DangAn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdatePerson extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePerson frame = new UpdatePerson();
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
	public UpdatePerson() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setBounds(79, 49, 54, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(79, 74, 54, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("\u518D\u6B21\u8F93\u5165\uFF1A");
		label_2.setBounds(79, 99, 67, 15);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("\u804C\u79F0\uFF1A");
		label_3.setBounds(79, 125, 54, 15);
		contentPane.add(label_3);

		textField = new JTextField();
		textField.setBounds(164, 46, 102, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(164, 71, 102, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(164, 96, 102, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(164, 122, 102, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(120, 172, 93, 23);
		contentPane.add(button);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(108, 214, 134, 15);
		contentPane.add(lblNewLabel);

		JLabel label_4 = new JLabel("\u7BA1\u7406\u5458\uFF1A");
		label_4.setBounds(370, 196, 54, 15);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(370, 214, 54, 15);
		contentPane.add(label_5);

		JButton button_1 = new JButton("\u6CE8\u9500");
		button_1.setBounds(370, 238, 64, 23);
		contentPane.add(button_1);
	}

}
