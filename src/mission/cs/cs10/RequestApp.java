package mission.cs.cs10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RequestApp {

	private Socket socket;

	public RequestApp(String url) throws IOException {

		URL dns = getURL(url);
		connectTCP(dns);
		request(dns);
		getResponse();

	}

	private void request(URL dns) throws IOException {

		try {
			socket.setSoTimeout(3000);
		} catch (SocketException e) {

		}

		BufferedWriter out = new BufferedWriter(
			new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

		List<String> headers = new ArrayList<>();

		headers.add("GET" + getQuery(dns) + "HTTP/1.1");

		System.out.println("\n=======Request=======");

		for (String header : headers) {
			System.out.println(header);
			out.write(header + "\r\n");
		}

		out.write("\r\n");

		out.flush();
		System.out.println("\n=======Response=======");

	}


	private void getResponse() throws IOException {
		BufferedReader in = new BufferedReader(
			new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}

	}

	private String getQuery(URL dns) {
		if (Objects.isNull(dns.getQuery())) {
			return " / ";
		}
		return " " + dns.getPath() + "?" + dns.getQuery() + " ";
	}

	private void connectTCP(URL url) throws IOException {
		InetAddress byName = getAddressFromDNS(url);
		socket = new Socket(getHostAddress(byName), getPort(url));
		System.out.println("TCP Connection : " + getHostAddress(byName) + " " + getPort(url));
	}

	private InetAddress getAddressFromDNS(URL url) throws UnknownHostException {
		System.out.println("(DNS Lookup...)");
		return InetAddress.getByName(url.getHost());
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
