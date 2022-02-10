package mission.cs.cs10;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;

public class RequestApp {

	private Socket socket;

	public RequestApp(String url) {

		try {
			URL dns = getURL(url);
//			System.out.println(this.url.getHost());
//			System.out.println(this.url.getProtocol());
//			System.out.println(this.url.getDefaultPort());
			connectTCP(dns);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void connectTCP(URL url) throws IOException {
		InetAddress byName = InetAddress.getByName(url.getHost());
		System.out.println("(DNS Lookup...)");
		socket = new Socket(getHostAddress(byName), getPort(url));
		System.out.println("TCP Connection : " + getHostAddress(byName) + " " + getPort(url));
	}

	private int getPort(URL url) {
		return url.getDefaultPort();
	}

	private String getHostAddress(InetAddress byName) {
		return byName.getHostAddress();
	}

	private URL getURL(String stringURL) throws MalformedURLException {
		if (isNotStartWithHttp(stringURL) && stringURL.startsWith("www.")) {
			stringURL = "http://" + stringURL;
		} else if (isNotStartWithHttp(stringURL)) {
			stringURL += "http://www.";
		}
		return new URL(stringURL);
	}

	private boolean isNotStartWithHttp(String stringURL) {
		return !stringURL.startsWith("http://") && !stringURL.startsWith("https://");
	}


}
