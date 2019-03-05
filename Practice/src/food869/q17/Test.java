package food869.q17;

import java.io.StringReader;

public class Test {

	public static void main(String[] args) {
		StringReader s = new StringReader(
				"Here is something I wanted to say:\\\r\n" + "Try and Buy in every way.\r\n" + "Go Team!");

		System.out.println(s);
	}

}
