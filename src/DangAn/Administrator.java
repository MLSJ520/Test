package DangAn;

import java.util.Scanner;
import java.util.*;
import java.sql.*;

public class Administrator extends User {

	private String password;
	private Scanner in;

	Administrator(String name, String password, String role) {
		super(name, password, role);
		// TODO Auto-generated constructor stub
	}

	private Scanner extracted() {
		return new Scanner(System.in);
	}

	public void ShowMenu() throws IllegalStateException, SQLException {
		menu Amenu = new menu();
		Amenu.setVisible(true);

		/*
		 * System.out.println("--- ����Ա�˵�ѡ��---"); System.out.println(
		 * "    1.�޸��û���Ϣ"); System.out.println("    2.�����û�");
		 * System.out.println("    3.ɾ���û�"); System.out.println("    4.��ʾ��Ա�б�");
		 * System.out.println("    5.�˳�"); System.out.println("��ѡ��"); in = new
		 * Scanner(System.in); int i=in.nextInt(); while(i!=0){ switch(i){ case
		 * 1: System.out.println("��������µ���Ϣ��"); String name=extracted().next();
		 * String pws=extracted().next(); String role=extracted().next();
		 * ChangUserInf(name,pws,role); break; case 2: adduser(); break; case 3:
		 * Deluser(); break; case 4: ListUser(); break; case 5:
		 * System.out.println("�˳��ɹ�"); System.exit(0); break; default:
		 * System.out.println("ѡ�����������ѡ��"); break; } i=in.nextInt(); } }
		 * public void ListUser() throws IllegalStateException, SQLException{
		 * System.out.println("---��Ա��Ϣ��ʾ���£�"); try{ DataProcessing.getAllUser();
		 * }
		 * 
		 * catch(SQLException e){ System.out.println("�������ݿ��쳣");
		 * }catch(IllegalStateException e){ System.out.println("���ݿ����ʧ��"); } }
		 * public void adduser() throws IllegalStateException, SQLException{
		 * System.out.println("----������Ա----"); System.out.println("��������Ϣ��");
		 * String r=extracted().next(); String s=extracted().next(); String
		 * t=extracted().next(); try{ if(DataProcessing.insertUser(r, s, t))
		 * System.out.println("������Ա�ɹ�"); else System.out.println("������Աʧ��");
		 * }catch(SQLException e){ System.out.println("�������ݿ��쳣");
		 * }catch(IllegalStateException e){ System.out.println("���ݿ����ʧ��"); } }
		 * public void Deluser() throws IllegalStateException, SQLException{
		 * System.out.println("----ɾ����Ա----"); System.out.println("������������");
		 * String r=extracted().next(); try{ if(DataProcessing.deleteUser(r))
		 * System.out.println("ɾ���ɹ�"); else System.out.println("ɾ��ʧ��");
		 * }catch(SQLException e){ System.out.println("���ݿ�����쳣");
		 * }catch(IllegalStateException e){ System.out.println("���ݿ����ʧ��"); } }
		 * public void ChangUserInf(String name,String password,String role)
		 * throws IllegalStateException, SQLException{
		 * try{if(DataProcessing.updateUser(name,password,role)){
		 * this.password=password; System.out.println("��Ϣ�޸ĳɹ�");}
		 * }catch(SQLException e){ System.out.println("���ݿ�����쳣");
		 * }catch(IllegalStateException e){ System.out.println("���ݿ����ʧ��"); }
		 */
	}

}