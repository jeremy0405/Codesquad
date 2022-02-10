package mission.cs.cs10.prac;

import java.net.InetAddress;
import java.net.Socket;

public class InetAddressApp {

	public static void main(String[] args) throws Exception {

		InetAddress byName = InetAddress.getByName("www.google.com");
		System.out.println(byName.getHostAddress());
		System.out.println(byName.getHostName());

//		ServerSocket server = new ServerSocket(Integer.parseInt(byName.getHostAddress()), 80);
		Socket socket = new Socket(byName.getHostAddress(), 443);

		System.out.println(socket);

	}

}
