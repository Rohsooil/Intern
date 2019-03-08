package food869.q18;

public class Test {
	public static void main(String[] args) {

		String codeWithComment = "/* This is a comment \r\n" + " * that continues \r\n" + " * across lines \r\n"
				+ " */ \r\n" + "First line.\r\n" + "\r\n" + "/* This is a comment that \r\n"
				+ "continues across lines */ \r\n" + "Second Line.\r\n" + "// This is a one-line comment \r\n"
				+ "Third Line.\r\n" + "\r\n" + "Fourth Line. // This is a one-line comment.";
		Code code = new Code();
		System.out.println(code.removeComment(codeWithComment));
	}
}
