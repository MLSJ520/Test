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
		 * System.out.println("--- 管理员菜单选择：---"); System.out.println(
		 * "    1.修改用户信息"); System.out.println("    2.增加用户");
		 * System.out.println("    3.删除用户"); System.out.println("    4.显示成员列表");
		 * System.out.println("    5.退出"); System.out.println("请选择："); in = new
		 * Scanner(System.in); int i=in.nextInt(); while(i!=0){ switch(i){ case
		 * 1: System.out.println("请输入更新的信息："); String name=extracted().next();
		 * String pws=extracted().next(); String role=extracted().next();
		 * ChangUserInf(name,pws,role); break; case 2: adduser(); break; case 3:
		 * Deluser(); break; case 4: ListUser(); break; case 5:
		 * System.out.println("退出成功"); System.exit(0); break; default:
		 * System.out.println("选择错误，请重新选择！"); break; } i=in.nextInt(); } }
		 * public void ListUser() throws IllegalStateException, SQLException{
		 * System.out.println("---成员信息显示如下："); try{ DataProcessing.getAllUser();
		 * }
		 * 
		 * catch(SQLException e){ System.out.println("操作数据库异常");
		 * }catch(IllegalStateException e){ System.out.println("数据库访问失败"); } }
		 * public void adduser() throws IllegalStateException, SQLException{
		 * System.out.println("----新增成员----"); System.out.println("请输入信息：");
		 * String r=extracted().next(); String s=extracted().next(); String
		 * t=extracted().next(); try{ if(DataProcessing.insertUser(r, s, t))
		 * System.out.println("新增成员成功"); else System.out.println("新增成员失败");
		 * }catch(SQLException e){ System.out.println("操作数据库异常");
		 * }catch(IllegalStateException e){ System.out.println("数据库访问失败"); } }
		 * public void Deluser() throws IllegalStateException, SQLException{
		 * System.out.println("----删除成员----"); System.out.println("请输入姓名：");
		 * String r=extracted().next(); try{ if(DataProcessing.deleteUser(r))
		 * System.out.println("删除成功"); else System.out.println("删除失败");
		 * }catch(SQLException e){ System.out.println("数据库操作异常");
		 * }catch(IllegalStateException e){ System.out.println("数据库访问失败"); } }
		 * public void ChangUserInf(String name,String password,String role)
		 * throws IllegalStateException, SQLException{
		 * try{if(DataProcessing.updateUser(name,password,role)){
		 * this.password=password; System.out.println("信息修改成功");}
		 * }catch(SQLException e){ System.out.println("数据库操作异常");
		 * }catch(IllegalStateException e){ System.out.println("数据库访问失败"); }
		 */
	}

}