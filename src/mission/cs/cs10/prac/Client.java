package mission.cs.cs10.prac;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("google.co.kr", 80);
		socket.setSoTimeout(15000);

		//https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%8F%99%EA%B8%B0

		BufferedWriter out = new BufferedWriter(
			new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader in = new BufferedReader(
			new InputStreamReader(socket.getInputStream()));

		System.out.println(" * Request");

		List<String> contents = new ArrayList<>();
		contents.add(
			"GET /search?q=codesquad&client=safari&sxsrf=APq-WBtPYIRyqRgh7exxwCLCK0obx4btKQ%3A1644494345398&source=hp&ei=Cf4EYo2hFNuAoATprKHoDA&iflsig=AHkkrS4AAAAAYgUMGeb4HIwv4T70TicHqDmGuLsXNB7u&ved=0ahUKEwjNyafqivX1AhVbAIgKHWlWCM0Q4dUDCA4&uact=5&oq=codesquad&gs_lcp=Cgdnd3Mtd2l6EAMyCwguEIAEEMcBEK8BMgUIABDLATIECAAQHjIECAAQHjIECAAQHjIECAAQHjIGCAAQBRAeMgYIABAFEB46BAgjECc6DgguEIAEELEDEMcBEKMCOg4ILhCABBCxAxDHARDRAzoLCAAQgAQQsQMQgwE6BQgAEIAEOhEILhCABBCxAxCDARDHARCjAjoICAAQgAQQsQM6CwguEIAEELEDENQCOggILhCABBCxAzoOCC4QgAQQsQMQxwEQrwE6DgguEIAEELEDEIMBENQCOgsILhDHARCvARDLAToHCAAQChDLAToKCC4Q1AIQChDLAVAAWKUTYLQUaABwAHgAgAGKAYgBswiSAQMwLjmYAQCgAQE&sclient=gws-wiz HTTP/1.1");

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