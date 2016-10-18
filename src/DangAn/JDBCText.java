package DangAn;

import java.sql.*;

public class JDBCText {
	private static Statement stmt = null;

	public JDBCText() throws Exception {
		String kongge = new String("");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql1", "root", "969799");
		stmt = conn.createStatement();
		/*
		 * String createTablePerson1 = "CREATE TABLE person1"+
		 * "(userName Varchar(10),Password varchar(10),Role varchar(20))";//新建表格
		 */
		/*
		 * String createTableDoc = "CREATE TABLE doc"+
		 * "(ID int(4) primary key auto_Increment, creator varchar(10)," +
		 * "timestamp timestamp(6), description varchar(100),filename varchar(10))"
		 * ;
		 */
		// create table user_info(username varchar(10) primary key, password ,
		// role );

		/// create table user_info(username varchar(10) primary key, password
		/// varchar(10) , role varchar(20));
		// create table doc_info();
		// stmt.executeUpdate(createTableDoc);
		// stmt.executeUpdate(createTablePerson1);
		stmt.executeUpdate("Insert Into Person1 Values" + "('kate','123','administrator')");// 在表格中插入数据
		stmt.executeUpdate("Insert Into Person1 Values" + "('jack','123','operator')");
		stmt.executeUpdate("Insert Into Person1 Values" + "('rose','123','browser')");

		// stmt.executeUpdate("Insert Into Doc
		// Values"+"('0002','jack',timestamp,'Txt File','F:\\abc2.txt')");

		ResultSet rs = stmt.executeQuery("SELECT * FROM person1");
		while (rs.next()) {
			System.out.println(rs.getString("userName") + kongge);
			System.out.println(rs.getString("Password") + kongge);
			System.out.println(rs.getString("Role") + kongge);
		}
		// stmt.executeUpdate("DROP TABLE person1");
		// rs.close();
		stmt.close();
		conn.close();
	}

	public static boolean InsertDoc(String Id, String creator, Timestamp timestamp, String description, String filename)
			throws SQLException {

		ResultSet rs1 = stmt.executeQuery("SELECT * FROM doc WHERE ID = Id");
		if (rs1 != null) {
			return false;
		} else {
			stmt.executeUpdate("Insert Into doc Values" + "(Id,creator,timestamp,description,filename)");
			if (rs1 != null)
				return true;
		}
		return false;

	}

	public static boolean InsertPerson(String name, String pwd, String role) throws SQLException {
		ResultSet rs1 = stmt.executeQuery("SELECT * FROM doc WHERE ID = Id");
		if (rs1 != null) {
			return false;
		} else {
			stmt.executeUpdate("Insert Into person Values" + "(name,pwd,role)");
			if (rs1 != null)
				return true;
		}
		return false;
	}

	public static boolean SearchDoc(String Id) throws SQLException {
		ResultSet rs2 = stmt.executeQuery("SELECT * FROM doc WHERE ID = Id");
		if (rs2 != null)
			return true;
		else
			return false;
	}

	public boolean SearchPerson(String name, String pwd) throws SQLException {
		ResultSet rs2 = stmt.executeQuery("SELECT * FROM person1 WHERE userName = name");
		if (rs2 != null && rs2.getString("Password") == pwd)
			return true;
		else
			return false;
	}

	public static boolean DeleteDoc(String Id) throws SQLException {
		if (stmt.executeQuery("SELECT * FROM doc WHERE ID = Id") != null) {
			stmt.executeUpdate("DELETE * FEOM doc WHERE ID = Id");
			return true;
		} else
			return false;
	}

	public static ResultSet GetAlluser() {
		ResultSet rs3 = null;
		try {
			rs3 = stmt.executeQuery("SELECT * FROM person1");
			while (rs3.next()) {
				System.out.print(rs3.getString("userName") + " ");
				System.out.print(rs3.getString("Password") + " ");
				System.out.print(rs3.getString("Role") + " ");
				System.out.println("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库异常！");
		}

		return rs3;
	}

	public static ResultSet GetAlldoc() {
		ResultSet rs4 = null;
		try {
			rs4 = stmt.executeQuery("SELECT * FROM doc");
			while (rs4.next()) {
				System.out.print(rs4.getString("ID") + " ");
				System.out.print(rs4.getString("creator") + " ");
				System.out.print(rs4.getString("timestamp") + " ");
				System.out.print(rs4.getString("description") + " ");
				System.out.print(rs4.getString("filename") + " ");
				System.out.println("");
			}
			return rs4;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库异常！");
		}
		// return rs4;
		return rs4;

	}

	public static void main(String args[]) {
		try {
			JDBCText jdbc = new JDBCText();
			jdbc.GetAlluser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// System.out.println("数据库异常！");
		}

	}

}
