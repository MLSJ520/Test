package DangAn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

//import java.util.*;
public class Browser extends User {

	private Scanner extracted() {
		return new Scanner(System.in);
	}

	Browser(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}

	private Scanner in;

	public void ShowFileList() throws IllegalStateException, SQLException {
		System.out.println("--文件列表如下：");
		DataProcessing.getAllDocs();
	}

	public void downloadFile() throws IOException, IllegalStateException, SQLException {
		System.out.println("请输入档案的代码：");
		String ID = extracted().next();

		if (DataProcessing.searchDoc(ID) != null) {
			FileInputStream fis1 = new FileInputStream(DataProcessing.searchDoc(ID).getFilename());
			String address = "F:\\";
			System.out.println("请输入下载地址：（默认为   F:\\）");
			address = extracted().next();
			FileOutputStream fos1 = new FileOutputStream(address.trim());
			int s;
			while ((s = fis1.read()) != -1)
				fos1.write(s);
			fis1.close();
			fos1.close();
			System.out.println("文件已下载!");
		}
	}

	@Override
	public void ShowMenu() throws IllegalStateException, SQLException, IOException {
		// TODO Auto-generated method stub
		System.out.println("-- 用户菜单选择：--");
		System.out.println("   1.下载文件");
		System.out.println("   2.显示文件列表");
		System.out.println("   3.修改密码");
		System.out.println("   4.退出");
		System.out.println("请选择：");
		in = new Scanner(System.in);
		int r = in.nextInt();
		while (r != 0) {
			switch (r) {
			case 1:
				downloadFile();
				break;
			case 2:
				ShowFileList();
				break;
			case 3:
				System.out.print("请输入新的密码：");
				String pws = extracted().next();
				System.out.println("");
				Changepwd(pws);
				break;
			case 4:
				System.out.println("退出成功");
				System.exit(0);
				break;
			default:
				System.out.println("选择错误，请重新选择");
				break;
			}
			r = in.nextInt();
		}
	}

	public void Changepwd(String pasword) throws IllegalStateException, SQLException {
		try {
			if (DataProcessing.updateUser(this.getName(), pasword, this.getRole())) {
				this.password = pasword;
				System.out.println("密码修改成功");
			}

		} catch (IllegalStateException e) {
			System.out.println("数据库访问失败");
		}
	}

}