package DangAn;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.io.IOException;

public class Client extends Socket {
	private static final String SERVER_IP = "192.168.1.113";
	private static final int SERVER_PORT = 2013;

	private Socket client;
	private FileInputStream fis;
	private DataOutputStream dos;
	private DownLoad downfile;
	private UpdateF updatef;

	public void Clint_Update(String filename) {
		try {
			try {
				client = new Socket(SERVER_IP, SERVER_PORT);
				// �����˴����ļ�
				// String filename = updatef.getTextField_4().getText();
				File file = new File(filename);
				fis = new FileInputStream(file);
				dos = new DataOutputStream(client.getOutputStream());

				// �ļ����ͳ���
				dos.writeUTF(file.getName());
				dos.flush();
				dos.writeLong(file.length());
				dos.flush();

				// �����ļ�
				byte[] sendBytes = new byte[1024];
				int length = 0;
				while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
					dos.write(sendBytes, 0, length);
					dos.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fis != null)
					fis.close();
				if (dos != null)
					dos.close();
				client.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method
	 * stub new Client(); }
	 */

}
