import java.util.regex.*;

public class TTest {
	public static void main(String[] args) {
		String info = "<td class>Ӫҵִ��ע���</br>ͳһ������ô���</td><td class= width=>" + "<br/>91120222MA05J8UR9W</td>"
				+ "<td class= >����</td>" + "<td classwidth=>������Ĺ�����޹�˾</td></tr>";
		Pattern pattern1 = Pattern.compile("<");
		/*
		 * Pattern pattern = Pattern.compile("[,   |]+"); String[] strs =
		 * pattern.split("Java Hello World Java,Hello,,World|Sun"); String
		 * str="123��45��67��8"; String strs2[]=str.split("[^0-9]");
		 * 
		 * Pattern pattern2 = Pattern.compile("������ʽ"); Matcher matcher =
		 * pattern2.matcher("hhhh ������ʽ hello world,Java hello world");
		 * StringBuffer buf = new StringBuffer();
		 * System.out.println(matcher.replaceAll("Java")); while(matcher.find())
		 * { matcher.appendReplacement(buf, "java");
		 * }//ͬһ��matcher������Ĳ����������һ��ƥ������ַ��������� matcher.appendTail(buf);
		 * System.out.println(buf.toString());
		 **/

		/*
		 * for(int i = 0;i<strs2.length;i++) { System.out.println(strs[i]);
		 * System.out.println(strs2[i]); }
		 */
	}

}
/*
 * Java ʾ���� String str=��123��45��67��8��; String
 * strs[]=str.split("��");//�����ԣ�Ϊ�ָ��߷ָ����仰 strs[0]=123; strs[1]=45; strs[2]=67;
 * strs[3]=8
 */
