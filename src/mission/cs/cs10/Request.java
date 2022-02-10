package mission.cs.cs10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Request {

	private final String url;
	private final Socket socket;
	private String ipAddress;

	public Request(String url) throws IOException {
		this.url = url;
		String scheme = getScheme(url);
		socket = new Socket(returnHostAddress(), 80);
	}

	private String getScheme(String url) {
		if (url.startsWith("https")) {
			return url.substring(5);
		}
		if (url.startsWith("http")) {
			return url.substring(4);
		}
		return null;
	}

	private String[] splitURL() {
		return url.split("/");
	}

	public String returnHostAddress() throws UnknownHostException {
		String host = splitURL()[0];
		InetAddress byName = InetAddress.getByName(host);
		ipAddress = byName.getHostAddress();
		return ipAddress;
	}

	private void get() throws IOException {
		String getCommand = "GET " + "/" + returnQuery() + " HTTP/1.1";

		BufferedWriter out = new BufferedWriter(
			new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
		BufferedReader in = new BufferedReader(
			new InputStreamReader(socket.getInputStream()));

		System.out.println(getCommand);

		out.write("GET /search?q=test&sxsrf=APq-WBuumwSRkR0BfVwlc9dlUcdaKZFPXg%3A1644482620369&source=hp&ei=PNAEYoWLEoT3-Qb8qZDwCA&iflsig=AHkkrS4AAAAAYgTeTOy6RtdfMvxwfBTSdU3TINN9uQ2m&ved=0ahUKEwiFmbCT3_T1AhWEe94KHfwUBI4Q4dUDCAk&uact=5&oq=test&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECcyBAgjECcyBAgjECcyEQguEIAEELEDEIMBEMcBENEDMgsIABCABBCxAxCDATILCAAQgAQQsQMQgwEyDgguEIAEELEDEMcBENEDMgsIABCABBCxAxCDATILCAAQgAQQsQMQgwEyCwgAEIAEELEDEIMBOggIABCABBCxAzoOCC4QgAQQsQMQxwEQowI6BQgAEIAEOhEILhCABBCxAxCDARDHARCvAToHCCMQ6gIQJ1AAWK4RYNcSaARwAHgDgAGdA4gBghCSAQkwLjIuMi4yLjGYAQCgAQGwAQo&sclient=gws-wiz HTTP/1.1" + "\r\n");

		out.write("\r\n");

		out.flush();

		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}

	}

	private String returnQuery() {
		return splitURL()[1];
	}

	public static void main(String[] args) throws IOException {
		Request request = null;
		try {
			request = new Request(
				"www.google.co.kr/search?q=test&sxsrf=APq-WBuumwSRkR0BfVwlc9dlUcdaKZFPXg%3A1644482620369&source=hp&ei=PNAEYoWLEoT3-Qb8qZDwCA&iflsig=AHkkrS4AAAAAYgTeTOy6RtdfMvxwfBTSdU3TINN9uQ2m&ved=0ahUKEwiFmbCT3_T1AhWEe94KHfwUBI4Q4dUDCAk&uact=5&oq=test&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECcyBAgjECcyBAgjECcyEQguEIAEELEDEIMBEMcBENEDMgsIABCABBCxAxCDATILCAAQgAQQsQMQgwEyDgguEIAEELEDEMcBENEDMgsIABCABBCxAxCDATILCAAQgAQQsQMQgwEyCwgAEIAEELEDEIMBOggIABCABBCxAzoOCC4QgAQQsQMQxwEQowI6BQgAEIAEOhEILhCABBCxAxCDARDHARCvAToHCCMQ6gIQJ1AAWK4RYNcSaARwAHgDgAGdA4gBghCSAQkwLjIuMi4yLjGYAQCgAQGwAQo&sclient=gws-wiz");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(request.returnHostAddress());
		request.get();

		System.out.println("\n * Response");

	}

}
