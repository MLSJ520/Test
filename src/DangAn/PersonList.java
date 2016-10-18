package DangAn;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PersonList extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JDBCText jdbc;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { PersonList frame = new
	 * PersonList(); frame.setVisible(true);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws BadLocationException
	 * @throws SQLException
	 * @throws IllegalStateException
	 */
	public PersonList() throws BadLocationException, IllegalStateException, SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("\u5220\u9664\u6210\u5458");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				try {
					if (DataProcessing.deleteUser(name))
						lblNewLabel.setText("É¾³ý³É¹¦£¡");
					else
						lblNewLabel.setText("É¾³ýÊ§°Ü£¡");
				} catch (IllegalStateException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(170, 208, 93, 23);
		contentPane.add(button);

		textField = new JTextField();
		textField.setBounds(246, 177, 93, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("\u8BF7\u5728\u8F93\u5165\u6846\u4E2D\u8F93\u5165\u59D3\u540D");
		label.setBounds(69, 180, 139, 15);
		contentPane.add(label);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(0, 23, 434, 142);
		contentPane.add(textPane);
		textPane.setEditable(false);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(158, 241, 120, 15);
		contentPane.add(lblNewLabel);
		Document doc = textPane.getStyledDocument();

		Enumeration<User> e = DataProcessing.getAllUser();
		/*
		 * try { ResultSet rs4 = jdbc.GetAlluser(); while(rs4.next()){ String
		 * text=("Name:"+rs4.getString("userName")+"    password:"+
		 * rs4.getString("Password")+"       role:"+rs4.getString("Role")+"\n");
		 * doc.insertString(doc.getLength(), text, null); } } catch
		 * (SQLException e1) { // TODO Auto-generated catch block
		 * //System.out.println("Êý¾Ý¿âÒì³££¡"); }
		 */

		while (e.hasMoreElements()) {
			User user = e.nextElement();
			String text = ("Name:" + user.getName() + "    password:" + user.getPassword() + "       role:"
					+ user.getRole() + "\n");
			doc.insertString(doc.getLength(), text, null);
		}
	}
}
