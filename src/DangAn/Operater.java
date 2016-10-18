package DangAn;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.io.*;
import java.util.Scanner;

public class Operater extends User {
	private Scanner in;

	Operater(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}

	private Scanner extracted() {
		return new Scanner(System.in);
	}

	public void ShowMenu() throws IllegalStateException, SQLException, IOException {
		/*
		 * System.out.println("---操作人员菜单选择：---"); System.out.println("   1.下载文件"
		 * ); System.out.println("   2.上传文件"); System.out.println("   3.显示文件列表"
		 * ); System.out.println("   4.修改密码"); System.out.println("   5.退出");
		 * System.out.println("请选择："); in = new Scanner(System.in); int
		 * r=in.nextInt(); while(r!=0){ switch(r){ case 1: // downloadFile();
		 * break; case 2: // uploadFile(); break; case 3: ShowFileList(); break;
		 * case 4: System.out.print("请输入新的密码："); String pws=extracted().next();
		 * System.out.println(""); Changepwd(pws); break; case 5:
		 * System.out.println("退出成功"); System.exit(0); break; default:
		 * System.out.println("选择错误，请重新选择"); break; }
		 * System.out.println("请选择："); r=in.nextInt();
		 * 
		 * }
		 */
	}

	public void ShowFileList() throws IllegalStateException, SQLException {
		System.out.println("--文件菜单如下：");
		DataProcessing.getAllDocs();
	}

	public static boolean downloadFile(String ID, String address)
			throws IOException, IllegalStateException, SQLException {
		// System.out.println("请输入档案的代码：");
		// String ID=extracted().next();

		if (DataProcessing.searchDoc(ID) != null) {
			FileInputStream fis1 = new FileInputStream(DataProcessing.searchDoc(ID).getFilename());

			// System.out.println("请输入下载地址：（默认为 F:\\）");
			// address=extracted().next();
			FileOutputStream fos1 = new FileOutputStream(address.trim());// 输出，从程序中读出内容
			int s;
			while ((s = fis1.read()) != -1)// 从文件中读出
				fos1.write(s);// 读出内容存入fos1中
			fis1.close();
			fos1.close();
			return true;
		}
		// FileOutputStream fos1 = new FileOutputStream("abc.txt");
		else

			return false;

	}

	public static boolean uploadFile(String ID, String creator, String des, String timetamp, String filename,
			String address) throws IOException, IllegalStateException, SQLException {
		// System.out.println("请输入要上传的文件：(文件地址)");
		// String address=extracted().next();
		// BufferedInputStream file=new BufferedInputStream(file);
		String Path = "D:/" + address.trim();
		//
		FileInputStream fis1 = new FileInputStream(Path);

		// System.out.println("文件上传地址为：");
		// String address2=extracted().next();*/
		String Path2 = "F:/" + filename.trim();
		FileOutputStream fos1 = new FileOutputStream(Path2);
		int s;
		while ((s = fis1.read()) != -1)// 从文件中读出
			fos1.write(s);// 读出内容存入fos1中
		fis1.close();
		fos1.close();

		if (DataProcessing.insertDoc(ID, creator, timetamp, des, filename)) {
			// System.out.println("文件已上传!");
			return true;
		} else
			return false;

	}
	/*
	 * public void Changepwd (String pasword)throws IllegalStateException,
	 * SQLException{
	 * try{if(DataProcessing.updateUser(this.getName(),pasword,this.getRole())){
	 * this.password=pasword; System.out.println("密码修改成功"); }
	 * 
	 * }catch(IllegalStateException e){ System.out.println("数据库访问失败"); } }
	 */
}