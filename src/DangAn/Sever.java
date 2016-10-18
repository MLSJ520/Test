package DangAn;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever extends ServerSocket {

	public Sever() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final int PORT = 2013;

	private ServerSocket server;
	private Socket socket;
	private DataInputStream dis;
	private FileOutputStream fos;

	public void SeverL(String fileName) throws Exception {
		try {
			try {
				server = new ServerSocket(PORT);

				while (true) {
					socket = server.accept();
					// new CreateServerThread(socket);
					dis = new DataInputStream(socket.getInputStream());
					// 文件名和长度
					// String fileName = dis.readUTF();
					long fileLength = fileName.length();
					fos = new FileOutputStream(new File("e:/" + fileName));

					byte[] sendBytes = new byte[1024];
					int transLen = 0;
					System.out.println("----开始接收文件<" + fileName + ">,文件大小为<" + fileLength + ">----");
					while (true) {
						int read = 0;
						read = dis.read(sendBytes);
						if (read == -1)
							break;
						transLen += read;
						System.out.println("接收文件进度" + 100 * transLen / fileLength + "%...");
						fos.write(sendBytes, 0, read);
						fos.flush();
					}
					System.out.println("----接收文件<" + fileName + ">成功-------");
					socket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (dis != null)
					dis.close();
				if (fos != null)
					fos.close();
				server.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] args)throws Exception { new Sever(); }
	 */

}
