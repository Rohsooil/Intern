package food869.q18;

public class CodeComment {
	public void removeComment(String str) {
		if (str.contains("/*")) {
			str = str.substring(str.indexOf("*/") + 3);

			System.out.println(str);
		} else if (str.contains("//") && str.indexOf("//") == 0) {
			str = str.substring(str.indexOf("\r\n"));
			System.out.println(str);
		} else if (str.contains("//") && str.indexOf("//") != 0) {
			str = str.substring(0, str.indexOf("//"));
			System.out.println(str);
		}
	}
}
