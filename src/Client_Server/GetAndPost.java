package Client_Server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.ByteArrayBuffer;
import org.htmlparser.NodeFilter;
//import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.util.ParserException;
import org.htmlparser.filters.*;

public class GetAndPost {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		GetAndPost jq = new GetAndPost();
		jq.postData();
	}

	private String text;

	public String postData() {

		String url = "http://tjcredit.gov.cn/platform/saic/baseInfo.json?entId=a10d93880a0a093c0005a2a2010c44f6&departmentId=scjgw&infoClassId=dj";
		HttpClient httpclient = new DefaultHttpClient();

		HttpGet httpget = new HttpGet(url);
		/*
		 * HttpPost httppost = new
		 * HttpPost("http://gsxt.cqgs.gov.cn/search_ent"); httpget.addHeader(new
		 * BasicHeader("Cookie","JSESSIONID" +
		 * "=LHHvXwkRD7p1pPLrxjY52BPsJS6SLGN2qJbYGl1kykGnjnZx8X8L!-741014447!-1281013803"
		 * )); httpget.addHeader("Content-Type","text/html;charset=UTF-8" ); //
		 * httppost.addHeader(name, value); httpget.addHeader("User-Agent",
		 * "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; LCJB; rv:11.0) like Gecko"
		 * ); httpget.addHeader("Host", "gsxt.cqgs.gov.cn");
		 * httpget.addHeader("Accept","/"); httpget.addHeader("Accept-Language",
		 * "zh-Hans-CN, zh-Hans; q=0.5"); httpget.addHeader("Accept-Encoding",
		 * "gzip, deflate"); httpget.addHeader("Referer",
		 * "http://gsxt.cqgs.gov.cn/");
		 */

		try {

			HttpResponse response = httpclient.execute(httpget);

			InputStream is = response.getEntity().getContent();
			BufferedInputStream bis = new BufferedInputStream(is);
			ByteArrayBuffer baf = new ByteArrayBuffer(20);

			int current = 0;
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
			}

			text = new String(baf.toByteArray(), "utf-8"); // 指定编码//GB2312
			System.out.println(text);
			// return text;

		} catch (ClientProtocolException e) {
			System.out.println("客户端请求错误");
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
		} finally {

		}
		return text;

	}
}
