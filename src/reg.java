import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class reg {
	public static void main(String[] args) {
		// String s="<p id=km>&nbsp;<a
		// href=http://down.111cn.net>�ռ�</a>&nbsp;|&nbsp;<a ";
		String s = "<html><body><a href=http://www.baidu.com>�ٶ�</a>��<a href='http://www.163.com'target='_blank'>����</a></body></html>";

		String regex = "<a.*?/a>";
		Pattern pt = Pattern.compile(regex);
		Matcher mt = pt.matcher(s);
		while (mt.find()) {
			System.out.println(mt.group());
			System.out.println();
			String s2 = ">.*?</a>";// ���ⲿ��
			String s3 = "href=.*?>";

			Pattern pt2 = Pattern.compile(s2);
			Matcher mt2 = pt2.matcher(mt.group());
			while (mt2.find()) {
				System.out.println("���⣺" + mt2.group().replaceAll(">|</a>", ""));
			}

			Pattern pt3 = Pattern.compile(s3);
			Matcher mt3 = pt3.matcher(mt.group());
			while (mt3.find()) {
				System.out.println("��ַ��" + mt3.group().replaceAll("href=|>", ""));
			}
		}
	}
}