package DangAn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Client1 {

	public static void main(String[] args) throws Exception {

		String driverName = "com.mysql.jdbc.Driver"; // �������ݿ�������
		String url = "jdbc:mysql://localhost:3306/mysql1"; // �������ݿ��URL
		String user = "root"; // ���ݿ��û�
		String password = "969799";

		try {
			DataProcessing.connectToDatabase(driverName, url, user, password);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "���ݿ����", "���뷴��", JOptionPane.YES_NO_OPTION);
			System.exit(0);
		}
		Class.forName(driverName); // �������ݿ�������

		// connection=DriverManager.getConnection(url, user, password); //
		// �������ݿ�����
		//
		// MySqlConnection.Connection();
		URL baidu = new URL("http://www.baidu.com/");
		URLConnection bd = baidu.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(bd.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
			System.out.println(" ");
		}
		in.close();

	}
}
