package Client_Server;

import java.io.*;

public class Savecontent {
	File file;
	String root = "info\\";
	String entId;
	static String url = "http://tjcredit.gov.cn/platform/saic/viewBase.ftl?entId=a10d93880a0a093c0005a2a2010c44f6";
	String url2;
	static String Content;
	static DownLoadPage dpage = new DownLoadPage();
	static String ID;

	public void WritePage() throws IOException {
		try {
			FileWriter fw = new FileWriter(root + ID + ".txt",true);
		//	FileWriter fw = new FileWriter(filePath, true);  
            BufferedWriter bw = new BufferedWriter(fw); 
            System.out.println("正在写入"+ID+"信息...");
			bw.write(Content);
			
			bw.close();
			fw.close();
			System.out.println("写入成功！！");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("写入失败！");
			/*
			 * 添加功能，将写入失败的ID加入队列，后续重新写入
			 */
		}
	}

	public static void main(String[] args) throws IOException {
		Savecontent SaveC = new Savecontent();
		ID = dpage.ID;
		Content = dpage.Savepage();
		//SaveC.WritePage();
		// DownLoadPage.GetID(url);
	}
}
