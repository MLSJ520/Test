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
            System.out.println("����д��"+ID+"��Ϣ...");
			bw.write(Content);
			
			bw.close();
			fw.close();
			System.out.println("д��ɹ�����");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("д��ʧ�ܣ�");
			/*
			 * ��ӹ��ܣ���д��ʧ�ܵ�ID������У���������д��
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
