import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zhengze {
	public static void main(String[] args) {
		String a = "<html><body><a href=http://www.baidu.com>�ٶ�</a>��<a href='http://www.163.com'target='_blank'>����</a></body></html>";
		Pattern pattern = Pattern.compile("(http://|https��//){1}[\\w\\.\\-/:]+");
		Matcher matcher = pattern.matcher(a);
		StringBuffer buffer = new StringBuffer();
		while (matcher.find()) {
			buffer.append(matcher.group());
			buffer.append("\r\n");
			System.out.println(buffer.toString());
		}

	}
}