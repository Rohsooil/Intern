package food869.q18;

public class Code {
	private final String ONELINE_CMT_START = "//";
	private final String MULTLINE_CMT_START = "/*";
	private final String MULTLINE_CMT_END = "*/";
	private final String EMPTY = "";
	private final char NEXT_LINE = '\n';

	public String removeComment(String str) {
		String result = removeBlock(str);
		result = removeLine(result);

		return result;
	}

	private String removeLine(String str) {
		char[] arr = str.toCharArray();
		boolean iscomment = false;
		String result = EMPTY, tmp = EMPTY;

		for (char a : arr) {
			if (!iscomment) {
				result += a;
				result = result.replace(ONELINE_CMT_START, EMPTY);
			}
			tmp += a;
			if (tmp.contains(ONELINE_CMT_START)) {
				iscomment = true;
				tmp = EMPTY;
			} else if (a == NEXT_LINE) {
				iscomment = false;
			}

		}
		return result;
	}

	private String removeBlock(String str) {
		char[] arr = str.toCharArray();
		boolean iscomment = false;
		String result = EMPTY, tmp = EMPTY;

		for (char a : arr) {
			if (!iscomment) {
				result += a;
				result = result.replace(MULTLINE_CMT_START, EMPTY);
			}
			tmp += a;
			if (tmp.contains(MULTLINE_CMT_START)) {
				iscomment = true;
				tmp = EMPTY;
			} else if (tmp.contains(MULTLINE_CMT_END)) {
				iscomment = false;
			}

		}
		return result;
	}
}
