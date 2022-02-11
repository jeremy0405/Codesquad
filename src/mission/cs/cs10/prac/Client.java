package mission.cs.cs10.prac;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("google.co.kr", 80);
		socket.setSoTimeout(3000);

		//https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%8F%99%EA%B8%B0

		BufferedWriter out = new BufferedWriter(
			new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader in = new BufferedReader(
			new InputStreamReader(socket.getInputStream()));

		System.out.println(" * Request");

		List<String> contents = new ArrayList<>();
		contents.add(
			"GET / HTTP/1.1");

		for (String content : contents) {
			System.out.println(content);
			out.write(content + "\r\n");
		}
		out.write("\r\n");
		out.flush();
		// get -> 서버에 보냄

//		readResponse(in);
		System.out.println("\n * Response");

		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}

		out.close();
		in.close();

	}

}