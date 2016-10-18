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
		System.out.println("--�ļ��б����£�");
		DataProcessing.getAllDocs();
	}

	public void downloadFile() throws IOException, IllegalStateException, SQLException {
		System.out.println("�����뵵���Ĵ��룺");
		String ID = extracted().next();

		if (DataProcessing.searchDoc(ID) != null) {
			FileInputStream fis1 = new FileInputStream(DataProcessing.searchDoc(ID).getFilename());
			String address = "F:\\";
			System.out.println("���������ص�ַ����Ĭ��Ϊ   F:\\��");
			address = extracted().next();
			FileOutputStream fos1 = new FileOutputStream(address.trim());
			int s;
			while ((s = fis1.read()) != -1)
				fos1.write(s);
			fis1.close();
			fos1.close();
			System.out.println("�ļ�������!");
		}
	}

	@Override
	public void ShowMenu() throws IllegalStateException, SQLException, IOException {
		// TODO Auto-generated method stub
		System.out.println("-- �û��˵�ѡ��--");
		System.out.println("   1.�����ļ�");
		System.out.println("   2.��ʾ�ļ��б�");
		System.out.println("   3.�޸�����");
		System.out.println("   4.�˳�");
		System.out.println("��ѡ��");
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
				System.out.print("�������µ����룺");
				String pws = extracted().next();
				System.out.println("");
				Changepwd(pws);
				break;
			case 4:
				System.out.println("�˳��ɹ�");
				System.exit(0);
				break;
			default:
				System.out.println("ѡ�����������ѡ��");
				break;
			}
			r = in.nextInt();
		}
	}

	public void Changepwd(String pasword) throws IllegalStateException, SQLException {
		try {
			if (DataProcessing.updateUser(this.getName(), pasword, this.getRole())) {
				this.password = pasword;
				System.out.println("�����޸ĳɹ�");
			}

		} catch (IllegalStateException e) {
			System.out.println("���ݿ����ʧ��");
		}
	}

}