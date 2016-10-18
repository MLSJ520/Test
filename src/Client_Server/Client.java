package Client_Server;

import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import java.io.*;

public class Client {

	public static void main(String[] args) throws Exception {

		URL baidu = new URL("http://www.baidu.com/");
		URLConnection bd = baidu.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(bd.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();

	}

}
