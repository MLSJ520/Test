import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class reg {
	public static void main(String[] args) {
		// String s="<p id=km>&nbsp;<a
		// href=http://down.111cn.net>空间</a>&nbsp;|&nbsp;<a ";
		String s = "<html><body><a href=http://www.baidu.com>百度</a>，<a href='http://www.163.com'target='_blank'>网易</a></body></html>";

		String regex = "<a.*?/a>";
		Pattern pt = Pattern.compile(regex);
		Matcher mt = pt.matcher(s);
		while (mt.find()) {
			System.out.println(mt.group());
			System.out.println();
			String s2 = ">.*?</a>";// 标题部分
			String s3 = "href=.*?>";

			Pattern pt2 = Pattern.compile(s2);
			Matcher mt2 = pt2.matcher(mt.group());
			while (mt2.find()) {
				System.out.println("标题：" + mt2.group().replaceAll(">|</a>", ""));
			}

			Pattern pt3 = Pattern.compile(s3);
			Matcher mt3 = pt3.matcher(mt.group());
			while (mt3.find()) {
				System.out.println("网址：" + mt3.group().replaceAll("href=|>", ""));
			}
		}
	}
}