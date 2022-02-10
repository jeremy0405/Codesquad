package mission.cs.cs10.prac;

import java.net.MalformedURLException;
import java.net.URL;

public class URLApp {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://www.google.co.kr");
		System.out.println(url);
		System.out.println(url.getHost());
		System.out.println(url.getPath());
		System.out.println(url.getQuery());
		System.out.println(url.getDefaultPort());
		System.out.println(url.getProtocol());
	}

}
