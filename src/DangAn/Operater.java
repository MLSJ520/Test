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
		 * System.out.println("---������Ա�˵�ѡ��---"); System.out.println("   1.�����ļ�"
		 * ); System.out.println("   2.�ϴ��ļ�"); System.out.println("   3.��ʾ�ļ��б�"
		 * ); System.out.println("   4.�޸�����"); System.out.println("   5.�˳�");
		 * System.out.println("��ѡ��"); in = new Scanner(System.in); int
		 * r=in.nextInt(); while(r!=0){ switch(r){ case 1: // downloadFile();
		 * break; case 2: // uploadFile(); break; case 3: ShowFileList(); break;
		 * case 4: System.out.print("�������µ����룺"); String pws=extracted().next();
		 * System.out.println(""); Changepwd(pws); break; case 5:
		 * System.out.println("�˳��ɹ�"); System.exit(0); break; default:
		 * System.out.println("ѡ�����������ѡ��"); break; }
		 * System.out.println("��ѡ��"); r=in.nextInt();
		 * 
		 * }
		 */
	}

	public void ShowFileList() throws IllegalStateException, SQLException {
		System.out.println("--�ļ��˵����£�");
		DataProcessing.getAllDocs();
	}

	public static boolean downloadFile(String ID, String address)
			throws IOException, IllegalStateException, SQLException {
		// System.out.println("�����뵵���Ĵ��룺");
		// String ID=extracted().next();

		if (DataProcessing.searchDoc(ID) != null) {
			FileInputStream fis1 = new FileInputStream(DataProcessing.searchDoc(ID).getFilename());

			// System.out.println("���������ص�ַ����Ĭ��Ϊ F:\\��");
			// address=extracted().next();
			FileOutputStream fos1 = new FileOutputStream(address.trim());// ������ӳ����ж�������
			int s;
			while ((s = fis1.read()) != -1)// ���ļ��ж���
				fos1.write(s);// �������ݴ���fos1��
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
		// System.out.println("������Ҫ�ϴ����ļ���(�ļ���ַ)");
		// String address=extracted().next();
		// BufferedInputStream file=new BufferedInputStream(file);
		String Path = "D:/" + address.trim();
		//
		FileInputStream fis1 = new FileInputStream(Path);

		// System.out.println("�ļ��ϴ���ַΪ��");
		// String address2=extracted().next();*/
		String Path2 = "F:/" + filename.trim();
		FileOutputStream fos1 = new FileOutputStream(Path2);
		int s;
		while ((s = fis1.read()) != -1)// ���ļ��ж���
			fos1.write(s);// �������ݴ���fos1��
		fis1.close();
		fos1.close();

		if (DataProcessing.insertDoc(ID, creator, timetamp, des, filename)) {
			// System.out.println("�ļ����ϴ�!");
			return true;
		} else
			return false;

	}
	/*
	 * public void Changepwd (String pasword)throws IllegalStateException,
	 * SQLException{
	 * try{if(DataProcessing.updateUser(this.getName(),pasword,this.getRole())){
	 * this.password=pasword; System.out.println("�����޸ĳɹ�"); }
	 * 
	 * }catch(IllegalStateException e){ System.out.println("���ݿ����ʧ��"); } }
	 */
}