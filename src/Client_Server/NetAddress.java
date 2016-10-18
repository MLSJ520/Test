package Client_Server;

import java.net.*;

public class NetAddress {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			InetAddress[] addresses = InetAddress.getAllByName("taobao.com");
			for (int i = 0; i < addresses.length; i++)
				System.out.println(addresses[i]);
			// InetAddress address1 = InetAddress
			// System.out.println(address.getCanonicalHostName());
			System.out.println(address);
		} catch (UnknownHostException e) {
			System.out.println("Can't find the host");
		}
	}

}
