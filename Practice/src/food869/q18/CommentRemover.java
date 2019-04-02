package food869.q18;

public class CommentRemover {
	private final String ONELINE_CMT_START = "//";
	private final String ONELINE_CMT_END = "\n";
	private final String MULTLINE_CMT_START = "/*";
	private final String MULTLINE_CMT_END = "*/";
	private final String EMPTY = "";

	public String removeComment(String str) {
		String result = removeBlockOrLine(str, MULTLINE_CMT_START, MULTLINE_CMT_END);
		result = removeBlockOrLine(result, ONELINE_CMT_START, ONELINE_CMT_END);

		return result;
	}

	// '//'로 시작하는 라인 주석은 개행 문자열인 '\r\n'을 만날 때 까지 공백 처리.
	// '/*'로 시작해서 '*/'로 끝나는 여러줄의 블록을 삭제하도록 처리하는 메소드.
	// '/*' 기호가 있으면 주석으로 인식하고 '/*' 기호가 있을 때 까지 공백으로 처리.
	private String removeBlockOrLine(String str, String startFlag, String endFlag) {
		char[] arr = str.toCharArray();
		boolean isComment = false;
		String result = EMPTY, tmp = EMPTY;

		for (char a : arr) {
			if (!isComment) {
				result += a;
				result = result.replace(startFlag, EMPTY);
			}
			tmp += a;
			if (tmp.contains(startFlag)) {
				isComment = true;
				tmp = EMPTY;
			} else if (tmp.contains(endFlag)) {
				isComment = false;
			}

		}
		return result;
	}

}
