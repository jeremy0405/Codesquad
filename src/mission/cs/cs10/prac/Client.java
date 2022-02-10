package mission.cs.cs10.prac;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("google.co.kr", 80);

		BufferedWriter out = new BufferedWriter(
			new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
		BufferedReader in = new BufferedReader(
			new InputStreamReader(socket.getInputStream()));

		sendMessage(out);
		readResponse(in);

		out.close();
		in.close();
	}

	private static void sendMessage(BufferedWriter out) throws IOException {
		System.out.println(" * Request");

		List<String> contents = new ArrayList<>();
		contents.add("GET /search?q=java&client=safari&sxsrf=APq-WBtjxSD4GDOcbYs7oByHxNZtSDt7ow%3A1644471203878&source=hp&ei=o6MEYs_OM8TO-QaI0734Bg&iflsig=AHkkrS4AAAAAYgSxs4d6k8L0aqzYkQ7mk2id-ayP0NEm&ved=0ahUKEwiPrMvPtPT1AhVEZ94KHYhpD28Q4dUDCA4&uact=5&oq=java&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECcyBAgjECcyBAgjECcyBAgAEEMyBAgAEEMyBAgAEEMyBAgAEEMyBAgAEEMyBwgAELEDEEMyCwgAEIAEELEDEIMBUABYywFgyQJoAHAAeACAAYsBiAGLAZIBAzAuMZgBAKABAQ&sclient=gws-wiz HTTP/1.1");

		///search?q=java&client=safari&sxsrf=APq-WBtjxSD4GDOcbYs7oByHxNZtSDt7ow%3A1644471203878&source=hp&ei=o6MEYs_OM8TO-QaI0734Bg&iflsig=AHkkrS4AAAAAYgSxs4d6k8L0aqzYkQ7mk2id-ayP0NEm&ved=0ahUKEwiPrMvPtPT1AhVEZ94KHYhpD28Q4dUDCA4&uact=5&oq=java&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECcyBAgjECcyBAgjECcyBAgAEEMyBAgAEEMyBAgAEEMyBAgAEEMyBAgAEEMyBwgAELEDEEMyCwgAEIAEELEDEIMBUABYywFgyQJoAHAAeACAAYsBiAGLAZIBAzAuMZgBAKABAQ&sclient=gws-wiz

		for (String content : contents) {
			System.out.println(content);
			out.write(content + "\r\n");
		}

//		for (String line : getContents(request)) {
//			System.out.println(line);
//			out.write(line + "\r\n");
//		}

		out.write("\r\n");
		out.flush();
	}

	private static void readResponse(BufferedReader in) throws IOException {
		System.out.println("\n * Response");

		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
	}

	private static List<String> getContents(File file) throws IOException {
		List<String> contents = new ArrayList<String>();

		BufferedReader input = new BufferedReader(new FileReader(file));
		String line;
		while ((line = input.readLine()) != null) {
			contents.add(line);
		}
		input.close();

		return contents;
	}
}
