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

		String driverName = "com.mysql.jdbc.Driver"; // 加载数据库驱动类
		String url = "jdbc:mysql://localhost:3306/mysql1"; // 声明数据库的URL
		String user = "root"; // 数据库用户
		String password = "969799";

		try {
			DataProcessing.connectToDatabase(driverName, url, user, password);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库错误！", "输入反馈", JOptionPane.YES_NO_OPTION);
			System.exit(0);
		}
		Class.forName(driverName); // 加载数据库驱动类

		// connection=DriverManager.getConnection(url, user, password); //
		// 建立数据库连接
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
