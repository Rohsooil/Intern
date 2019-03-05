package food869.q18;

public class Test {
	public static void main(String[] args) {
		String line1 = "/* This is a comment \r\n" + " * that continues \r\n" + " * across lines \r\n" + " */ \r\n"
				+ "First line.";
		String line2 = "/* This is a comment that \r\n" + "continues across lines */ \r\n" + "Second Line.";
		String line3 = "// This is a one-line comment \r\n" + "Third Line.";
		String line4 = "Fourth Line. // This is a one-line comment.";
		
		CodeComment codeComment = new CodeComment();
		codeComment.removeComment(line1);
		codeComment.removeComment(line2);
		codeComment.removeComment(line3);
		codeComment.removeComment(line4);
	}
}
