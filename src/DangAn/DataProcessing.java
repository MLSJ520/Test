package DangAn;

import java.util.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.io.IOException;
//import javax.print.Doc;
import java.sql.*;
import java.util.Enumeration;
import java.util.Hashtable;

public class DataProcessing {
	// private static Connection con;
	// private Statement st;
	// private ResultSet rs;
	// private int numberofRows;
	private static boolean connectToDB = false;

	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static ResultSetMetaData metaData;
	private static int numberOfRows;
	private static boolean connectedToDatabase = false;

	// static Hashtable<String, User> users;
	// static Hashtable<String, Doc> docs;
	private static Scanner in;

	/*
	 * static { users = new Hashtable<String, User>(); users.put("jack", new
	 * Operater("jack","123","operator")); users.put("rose", new
	 * Browser("rose","123","browser")); users.put("kate", new
	 * Administrator("kate","123","administrator")); Init();
	 * 
	 * Timestamp timestamp = new Timestamp(System.currentTimeMillis()); docs =
	 * new Hashtable<String, Doc>(); docs.put("0001",new
	 * Doc("0001","jack",timestamp,"Age Source Java","Age.java"));
	 * docs.put("0002",new Doc("0002","jack",timestamp,"Txt File"
	 * ,"F:\\abc.txt"));
	 * 
	 * }
	 * 
	 * public static void Init(){ // connect to database //con =
	 * DriverManager.getConnection( "url", "username", "password" );
	 * 
	 * // create Statement to query database //st =
	 * con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.
	 * CONCUR_READ_ONLY );
	 * 
	 * // update database connection status // if (Math.random()>0.3) //
	 * connectToDB = true; // else // connectToDB = false; }
	 * 
	 * public static Doc searchDoc(String ID){ if (docs.containsKey(ID)) { Doc
	 * temp =docs.get(ID); return temp; } return null; }
	 * 
	 * public static Enumeration<Doc> getAllDocs() throws IllegalStateException{
	 * Enumeration<Doc> e = docs.elements(); System.out.println(
	 * "档案编号         档案名称                 档案管理人员                    档案创建时间                                                           档案简介 "
	 * ); while(e.hasMoreElements()){ Doc docs=e.nextElement();
	 * System.out.println(docs.getID()+"    " +docs.getFilename()+"    "
	 * +docs.getCreator() +"      " +docs.getTimestamp()+"    "
	 * +docs.getDescription()); } return e; }
	 * 
	 * public static boolean insertDoc(String ID, String creator, Timestamp
	 * timestamp, String description, String filename) throws
	 * IllegalStateException{ Doc doc;
	 * 
	 * if (docs.containsKey(ID)) return false; else{ doc = new
	 * Doc(ID,creator,timestamp,description,filename); docs.put(ID, doc); return
	 * true; } }
	 * 
	 * 
	 * public static User searchUser(String name, String password) { if
	 * (users.containsKey(name)) { User temp =users.get(name); if
	 * ((temp.getPassword()).equals(password)) return temp; } return null; }
	 * 
	 * public static boolean searchUser_2(String name) { if
	 * (users.containsKey(name)) return true; else return false; } public static
	 * Enumeration<User> getAllUser() throws IllegalStateException{ // if (
	 * !connectToDB ) // throw new IllegalStateException(
	 * "Not Connected to Database" ); // // if (Math.random()>0.7) // throw new
	 * SQLException( "Error in excecuting Query" );
	 * 
	 * Enumeration<User> e = users.elements(); while(e.hasMoreElements()){ User
	 * user=e.nextElement(); System.out.println(user.getName()+"  "
	 * +user.getPassword()+"  "+user.getRole()); } return e; }
	 * 
	 * 
	 * public static boolean updateUser(String name, String password, String
	 * role) throws IllegalStateException{ User user; // if ( !connectToDB ) //
	 * throw new IllegalStateException( "Not Connected to Database" ); // // if
	 * (Math.random()>0.7) // throw new SQLException(
	 * "Error in excecuting Update" );
	 * 
	 * if (users.containsKey(name)) { if
	 * (role.equalsIgnoreCase("administrator")) user = new
	 * Administrator(name,password, role); else if
	 * (role.equalsIgnoreCase("operator")) user = new Operater(name,password,
	 * role); else user = new Browser(name,password, role); users.put(name,
	 * user); return true; }else return false; }
	 * 
	 * public static boolean insertUser(String name, String password, String
	 * role) throws IllegalStateException{ User user;
	 * 
	 * // if ( !connectToDB ) // throw new IllegalStateException(
	 * "Not Connected to Database" ); // // if (Math.random()>0.7) // throw new
	 * SQLException( "Error in excecuting Insert" );
	 * 
	 * if (users.containsKey(name)) return false; else{ if
	 * (role.equalsIgnoreCase("administrator")) user = new
	 * Administrator(name,password, role); else if
	 * (role.equalsIgnoreCase("operator")) user = new Operater(name,password,
	 * role); else user = new Browser(name,password, role); users.put(name,
	 * user); return true; } }
	 * 
	 * public static boolean deleteUser(String name) throws
	 * IllegalStateException{ // if ( !connectToDB ) // throw new
	 * IllegalStateException( "Not Connected to Database" ); // // if
	 * (Math.random()>0.7) // throw new SQLException(
	 * "Error in excecuting Delete" );
	 * 
	 * if (users.containsKey(name)){ users.remove(name); return true; }else
	 * return false; }
	 * 
	 * public void disconnectFromDB() { if ( connectToDB ){ // close Statement
	 * and Connection try{ rs.close(); st.close(); con.close(); }catch (
	 * SQLException sqlException ){ sqlException.printStackTrace(); }finally{
	 * connectToDB = false; } } }
	 */

	public static void connectToDatabase(String driverName, String url, String user, String password) throws Exception {
		Class.forName(driverName); // 加载数据库驱动类

		connection = DriverManager.getConnection(url, user, password); // 建立数据库连接
		connectedToDatabase = true;
	}

	public static void disconnectFromDatabase() {
		if (connectedToDatabase) {
			// close Statement and Connection
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			} finally {
				connectedToDatabase = false;
			}
		}
	}

	private static void setQuery(String query) throws SQLException, IllegalStateException {

		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		// specify query and execute it
		resultSet = statement.executeQuery(query);

		// obtain meta data for ResultSet
		metaData = resultSet.getMetaData();

		// determine number of rows in ResultSet
		resultSet.last(); // move to last row
		numberOfRows = resultSet.getRow(); // get row number
	}

	public static Doc searchDoc(String DocID) throws SQLException, IllegalStateException {
		Doc temp = null;
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql = "select * from doc where Id='" + DocID + "'";
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {
			String ID = resultSet.getString("Id");
			String creator = resultSet.getString("creator");
			Timestamp timestamp = resultSet.getTimestamp("timestamp");
			String description = resultSet.getString("description");
			String filename = resultSet.getString("filename");
			temp = new Doc(ID, creator, timestamp, description, filename);
		}

		return temp;
	}

	public static Enumeration<Doc> getAllDocs() throws SQLException, IllegalStateException {
		Vector<Doc> docs = new Vector<Doc>();
		Doc temp = null;
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql = "select * from doc";
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			String ID = resultSet.getString("Id");
			String creator = resultSet.getString("creator");
			Timestamp timestamp = resultSet.getTimestamp("timestamp");
			String description = resultSet.getString("description");
			String filename = resultSet.getString("filename");
			temp = new Doc(ID, creator, timestamp, description, filename);
			docs.addElement(temp);
		}

		return docs.elements();

	}

	public static boolean insertDoc(String ID, String creator, String timestamp, String description, String filename)
			throws SQLException, IllegalStateException {
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		String sql = "INSERT INTO doc (creator,timestamp,description,filename) VALUES(?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, creator);
		preparedStatement.setString(2, timestamp);
		preparedStatement.setString(3, description);
		preparedStatement.setString(4, filename);

		int temp = preparedStatement.executeUpdate();

		if (temp != 0)
			return true;
		else
			return false;

	}

	public static User searchUser(String name) throws SQLException, IllegalStateException {
		User temp = null;
		if (!connectedToDatabase) {

			throw new IllegalStateException("Not Connected to Database");
		}
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql = "select * from person1 where username='" + name + "'";
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {
			String username = resultSet.getString("username");
			String password = resultSet.getString("password");
			String role = resultSet.getString("role");

			if (role.equals("Administrator")) {
				temp = new Administrator(username, password, role);
			} else if (role.equals("Operator")) {
				temp = new Operater(username, password, role);
			} else
				temp = new Browser(username, password, role);

		}

		return temp;
	}

	public static User searchUser(String name, String pwd) throws SQLException, IllegalStateException {
		User temp = null;
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql = "select * from person1 where username='" + name + "' and password='" + pwd + "'";
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {
			String username = resultSet.getString("username");
			String password = resultSet.getString("password");
			String role = resultSet.getString("role");

			if (role.equals("Administrator")) {
				temp = new Administrator(username, password, role);
			} else if (role.equals("Operator")) {
				temp = new Operater(username, password, role);
			} else
				temp = new Browser(username, password, role);

		}

		return temp;
	}

	public static Enumeration<User> getAllUser() throws SQLException, IllegalStateException {
		Vector<User> users = new Vector<User>();
		User temp = null;
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String sql = "select * from person1";
		resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			String username = resultSet.getString("username");
			String password = resultSet.getString("password");
			String role = resultSet.getString("role");

			if (role.equals("Administrator")) {
				temp = new Administrator(username, password, role);
			} else if (role.equals("Operator")) {
				temp = new Operater(username, password, role);
			} else
				temp = new Browser(username, password, role);

			users.addElement(temp);
		}

		return users.elements();

	}

	public static boolean updateUser(String name, String password, String role)
			throws SQLException, IllegalStateException {
		// if ( !connectToDB )
		// throw new IllegalStateException( "Not Connected to Database" );
		//
		// if (Math.random()>0.7)
		// throw new SQLException( "Error in excecuting Update" );

		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		String sql = "UPDATE person1 SET password=?, role=? where username=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, password);
		preparedStatement.setString(2, role);
		preparedStatement.setString(3, name);

		int temp = preparedStatement.executeUpdate();

		if (temp != 0)
			return true;
		else
			return false;
	}

	public static boolean insertUser(String name, String password, String role)
			throws SQLException, IllegalStateException {
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		String sql = "INSERT INTO person1 (username,password,role) VALUES(?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, password);
		preparedStatement.setString(3, role);

		int temp = preparedStatement.executeUpdate();

		if (temp != 0)
			return true;
		else
			return false;

	}

	public static boolean deleteUser(String name) throws SQLException, IllegalStateException {
		if (!connectedToDatabase)
			throw new IllegalStateException("Not Connected to Database");

		String sql = "DELETE FROM  person1 where username=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);

		int temp = preparedStatement.executeUpdate();

		if (temp != 0)
			return true;
		else
			return false;

	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IllegalStateException, IOException {
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

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 Lon = new Frame1();
					Lon.setVisible(true);
					// CreateServerThread thread = new CreateServerThread(null);
					// thread.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/*
		 * String name = Lon.getBtnNewButton().getName(); String pwd =
		 * Lon.getBtnNewButton_1().getName();
		 */

		/*
		 * System.out.println("*******欢迎进入档案管理系统*******");
		 * System.out.println("-----请登录-----"); in = new Scanner(System.in);
		 * System.out.print("姓名:"); String name=in.nextLine();
		 * System.out.print("密码:"); String paw=in.nextLine(); try{
		 * if(searchUser(name,paw)!=null){ System.out.println("登录成功！"); if
		 * (users.containsKey(name)) users.get(name).ShowMenu(); } else
		 * System.out.println("登录失败！"); } catch(SQLException e){
		 * System.out.println("数据库操作异常"); }catch(IllegalStateException e){
		 * System.out.println("数据库访问失败"); }
		 */

	}

}
