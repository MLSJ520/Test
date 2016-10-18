package Client_Server;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.*;

/**
 * ���ҳ��������Ա�entId�Ľ���
 * 
 */
public class DownLoadPage {
	// ����ָ����ҳ��
	@SuppressWarnings("deprecation")
	String ID = "120222000415292";
	String url = "http://tjcredit.gov.cn/platform/saic/viewBase.ftl?entId=a10d93880a0a093c0005a2a2010c44f6";
	String entId;
	String page;
	CloseableHttpClient client = HttpClients.createDefault();

	public String downloadPage(String url) throws IOException {
     
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse response = client.execute(httpget);
		try {
		    
			int statusCode = response.getStatusLine().getStatusCode(); // �����Ӧ��
			if (statusCode != HttpStatus.SC_OK)
				System.out.println("Method failed:" + response.getStatusLine());
			InputStream is = response.getEntity().getContent();
			BufferedInputStream bis = new BufferedInputStream(is);
			ByteArrayBuffer baf = new ByteArrayBuffer(20);

			int current = 0;
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
			}
			page = new String(baf.toByteArray(), "utf-8"); // ָ������//GB2312
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			response.close();
			client.close();
		}
		return page;
	}

	/*
	 * ����ҳ������
	 * �ȼ���Ϣ
	 */
	public String Savepage() throws IOException {
		entId = GetID(url);
		String content = null;
		String url2 = "http://tjcredit.gov.cn/platform/saic/baseInfo.json?entId=" + entId + "&departmentId=scjgw&infoClassId=dj";

		HttpGet get = new HttpGet(url2);
		//HttpPost post = new HttpPost(url2);
		CloseableHttpResponse response = client.execute(get);
		 try {    
			 HttpEntity entity = response.getEntity();     
			 if (entity != null) {        
				 InputStream is = entity.getContent();        
				 try {         
					BufferedInputStream bis = new BufferedInputStream(is);
					ByteArrayBuffer baf = new ByteArrayBuffer(20);

					int current = 0;
					while ((current = bis.read()) != -1) {
						baf.append((byte) current);
					}
					 content = new String(baf.toByteArray(), "utf-8");	 
				 } finally {           
					 is.close();     
				 }
		    }
		 } finally {  
		     response.close();
		     client.close();
		 }
		// System.out.println(content);
	return content;
	}

	/*
	 * ����ҳ�棬 �õ�entId
	 */
	public String GetID(String url) throws IOException {
		DownLoadPage download = new DownLoadPage();
		String Page;
		String intid = null;
		String id = null;
		Page = download.downloadPage(url);
		Pattern pattern1 = Pattern.compile("entId:\"(\\w+)");//
		Pattern pattern2 = Pattern.compile("ע���: (\\w+)");
		Matcher matcher = pattern1.matcher(Page);
		Matcher matcher2 = pattern2.matcher(Page);
		if(matcher2.find()){
			id = matcher2.group();
			System.out.println(id);
		}

		if (matcher.find()) {
			// System.out.println(matcher.group());
			intid = matcher.group();
			// System.out.println(id);
			intid = intid.substring(7);
			System.out.println(intid);
			return intid;
		} else {
			System.out.println(ID + "--��ȡentIdʧ��");
			return null;
		}

	}

	/*
	 * public static void main(String[] args) throws IOException { String Page =
	 * downloadPage(
	 * "http://tjcredit.gov.cn/platform/saic/viewBase.ftl?entId=a10d93880a0a093c0005a2a2010c44f6"
	 * ); String entId; Pattern pattern1 = Pattern.compile("entId:\"(\\w+)");//
	 * Matcher matcher = pattern1.matcher(Page);
	 * 
	 * 
	 * if(matcher.find()){ System.out.println(matcher.group()); entId =
	 * matcher.group(); entId = entId.substring(7); System.out.println(entId); }
	 * else System.out.println("����ʧ��"); Pattern pattern2 =
	 * Pattern.compile("href=\"(\\w.+)\""); Matcher matcher1 = pattern2.matcher(
	 * "< href=\"infex.html\">��ҳ</a>"); if(matcher1.find()){
	 * System.out.println(matcher1.group()); } }
	 */
}
