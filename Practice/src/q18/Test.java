package q18;

import split.StringSplit;
import split.StringSplit2;

public class Test {
	public static void main(String[] args) {
		String line1 = "/* This is a comment \r\n" + " * that continues \r\n" + " * across lines \r\n" + " */ \r\n"
				+ "First line.";
		String line2 = "/* This is a comment that \r\n" + "continues across lines */ \r\n" + "Second Line.";
		String line3 = "// This is a one-line comment \r\n" + "Third Line.";
		String line4 = "Fourth Line. // This is a one-line comment.";

		String a = "hi? ew as be 00hi hi bye hi";

		String[] li2 = StringSplit2.splitString(line1, " ");

		for (String s : li2) {
			System.out.println(s);
		}
		System.out.println();

		String[] li3 = line1.split(" ");

		for (String s : li3) {
			System.out.println(s);
		}
		
		System.out.println(li2[1].equals(li3[1]));
	}
}
