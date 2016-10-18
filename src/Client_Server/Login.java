package Client_Server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/*
 * 在此类中完成
 * 验证码的下载
 * 
 */
public class Login {
	CloseableHttpClient client = HttpClients.createDefault();
	final String Surl = "http://tjcredit.gov.cn";
	final String url = "http://tjcredit.gov.cn/platform/saic/index.ftl";
	final String root = "yzmcode\\";
	public void GetCookie(){
		HttpGet get = new HttpGet(Surl+"/verifycode");
		try {
			CloseableHttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			if(entity!=null){
				File file = new File(root+"1.jpg");
				OutputStream ops = new FileOutputStream(file);
				entity.writeTo(ops);
			}
			else
				System.out.println("验证码获取失败！");
			response.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpPost post = new HttpPost(url);//form action="/platform/saic/search.ftl"
		
	}
	/*
	 * List<Cookie> cookies = httpclient.getCookieStore().getCookies();
            httpGet.releaseConnection();
            StringBuilder cookiesSB = new StringBuilder();
            System.out.println("第一次cookie");
	 */

}
