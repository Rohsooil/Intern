package food869.q17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Test {

	public static void main(String[] args) {
		String input1 = "Here is something I wanted to say:\\\r\n" + "Try and Buy in every way.\r\n" + "Go Team!";
		String input2 = "From: ian Tuesday, January 1, 2000 8:45 AM EST\r\n" + "To: Book-reviewers List\r\n"
				+ "Received: by darwinsys.com (OpenBSD 2.6)\r\n" + "    from localhost\r\n"
				+ "    at Tuesday, January 1, 2000 8:45 AM EST\r\n"
				+ "Subject: Hey, it's 2000 and MY computer is still up";

		String output1 = "";
		String output2 = "";

		MyStringReader myStringReader = new MyStringReader(new StringReader(input1));
		MyStringReader myStringReader2 = new MyStringReader(new StringReader(input2));

		myStringReader.setContinationMode(false);
		myStringReader2.setContinationMode(true);

		try {
			while (!(output1 = myStringReader.readLine()).equals("null")) {
				System.out.println(output1);
			}
//			System.out.println(myStringReader.readLine());
//			System.out.println(myStringReader.readLine());
			System.out.println();
//			System.out.println(myStringReader2.readLine());
//			System.out.println(myStringReader2.readLine());
//			System.out.println(myStringReader2.readLine());
//			System.out.println(myStringReader2.readLine());
			while (!(output2 = myStringReader2.readLine()).equals("null")) {
				System.out.println(output2);
			}
			myStringReader.close();
			myStringReader2.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
