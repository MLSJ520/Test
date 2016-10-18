package DangAn;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class FileJframe extends JFrame {

	private JPanel contentPane;
	private JButton button_1;
	// private static ResultSet rs4;
	// private static Statement stmt = null;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 * try { FileJframe frame = new FileJframe(); frame.setVisible(true);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws IllegalStateException
	 * @throws BadLocationException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public FileJframe() throws IllegalStateException, BadLocationException, SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("\u4E0B\u8F7D\u6587\u4EF6");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DownLoad Ufile = new DownLoad();
				Ufile.setVisible(true);
			}
		});
		button.setBounds(253, 206, 93, 23);
		contentPane.add(button);

		button_1 = new JButton("\u4E0A\u4F20\u6587\u4EF6");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateF Ufile = new UpdateF();
				Ufile.setVisible(true);
			}
		});
		button_1.setBounds(79, 206, 93, 23);
		contentPane.add(button_1);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(0, 22, 434, 141);
		contentPane.add(textPane);
		textPane.setEditable(false);
		Document doc = textPane.getStyledDocument();
		Enumeration<Doc> e = DataProcessing.getAllDocs();
		String text_1 = ("编号         名称        管理人员               创建时间                 简介 " + "\n");
		doc.insertString(doc.getLength(), text_1, null);
		while (e.hasMoreElements()) {
			Doc docs = e.nextElement();
			String text = (docs.getID() + "    " + docs.getFilename() + "    " + docs.getCreator() + "        "
					+ docs.getTimestamp() + "    " + docs.getDescription() + "\n");
			doc.insertString(doc.getLength(), text, null);
		}

	}

	public JButton getButton_1() {
		return button_1;
	}

}
