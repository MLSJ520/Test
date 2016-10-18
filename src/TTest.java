import java.util.regex.*;

public class TTest {
	public static void main(String[] args) {
		String info = "<td class>营业执照注册号</br>统一社会信用代码</td><td class= width=>" + "<br/>91120222MA05J8UR9W</td>"
				+ "<td class= >名称</td>" + "<td classwidth=>天津有心广告有限公司</td></tr>";
		Pattern pattern1 = Pattern.compile("<");
		/*
		 * Pattern pattern = Pattern.compile("[,   |]+"); String[] strs =
		 * pattern.split("Java Hello World Java,Hello,,World|Sun"); String
		 * str="123￥45￥67￥8"; String strs2[]=str.split("[^0-9]");
		 * 
		 * Pattern pattern2 = Pattern.compile("正则表达式"); Matcher matcher =
		 * pattern2.matcher("hhhh 正则表达式 hello world,Java hello world");
		 * StringBuffer buf = new StringBuffer();
		 * System.out.println(matcher.replaceAll("Java")); while(matcher.find())
		 * { matcher.appendReplacement(buf, "java");
		 * }//同一个matcher，后面的操作会接着上一个匹配完的字符操作。。 matcher.appendTail(buf);
		 * System.out.println(buf.toString());
		 **/

		/*
		 * for(int i = 0;i<strs2.length;i++) { System.out.println(strs[i]);
		 * System.out.println(strs2[i]); }
		 */
	}

}
/*
 * Java 示例： String str=“123￥45￥67￥8”; String
 * strs[]=str.split("￥");//即是以￥为分割线分割整句话 strs[0]=123; strs[1]=45; strs[2]=67;
 * strs[3]=8
 */
