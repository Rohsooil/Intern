package food869.q17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class MyStringReader extends BufferedReader {

	private boolean flag;
	private final char SLASH = '\\';
	private final char TAB = '\t';
	private final char SPACE = ' ';
	private final int READ_AHEAD_LIMIT = 1000;

	// String Reader를 인자로 사용하는 BufferedReader를 상속받고 readLine 메소드 오버라이딩.
	public MyStringReader(StringReader in) {
		super(in);
	}

	@Override
	public String readLine() throws IOException {
		String line = super.readLine();
		String result = "";
		result += combineSlashLine(line); // 라인 끝이 슬래시로 끝나는 경우는 다음라인과 붙인다.
		while (hasNextLine()) { // 다음 라인이 있는 동안,
			if (flag && nextHasTabSpaceFirst()) { // flag가 true이고, 다음 라인의 첫 번째 문장이 탭, 공백으로 되어있을때.
				String nextLine = super.readLine();
				result = result + " " + removeTabSpace(nextLine); // 다음라인의 탭, 공백을 제거해서 붙인다.
			} else {
				break;
			}
		}

		return result;
	}

	// 해당 라인에서 앞부분 공백을 지우기 위한 메소드.
	private String removeTabSpace(String line) {
		int startIndex = 0;
		String result = "";
		char[] lineToChar = line.toCharArray();
		for (char c : lineToChar) {
			// 앞부분부터 공백인지 확인하고 아니면 break를 걸어준다.
			if ((c == TAB) || c == SPACE) {
				startIndex++;
			} else {
				break;
			}
		}
		for (int i = startIndex; i < lineToChar.length; i++) {
			result += lineToChar[i];
		}
		return result;
	}

	// 문장의 마지막에 슬래시가 있는 지 확인하는 메소드.
	private boolean hasSlashLast(String line) {
		char[] lineToChar = line.toCharArray();
		int lastIndex = lineToChar.length - 1;

		if (lineToChar[lastIndex] == SLASH) {
			return true;
		} else {
			return false;
		}
	}

	// 다음 줄이 있는지 확인하는 메소드.
	private boolean hasNextLine() throws IOException {
		// super.readLine()을 호출하면 다음 라인을 읽는 부분으로 넘어가기 때문에 mark를 찍고
		super.mark(READ_AHEAD_LIMIT);
		boolean haveNextLine = false;
		if (super.readLine() != null) {

			haveNextLine = true;
		}
		// reset으로 돌아와야함.
		super.reset();
		return haveNextLine;
	}

	// 다음 라인의 시작이 탭과 공백으로 되어있는지 확인.
	private boolean nextHasTabSpaceFirst() throws IOException {
		super.mark(READ_AHEAD_LIMIT);
		String nextLine = super.readLine();
		char[] lineToChar = nextLine.toCharArray();
		char firstChar = lineToChar[0];
		super.reset();
		if (firstChar == TAB || firstChar == SPACE) {
			return true;
		} else {
			return false;
		}
	}

	// 슬래시로 끝나는 라인은 다음라인과 합쳐서 반환.
	private String combineSlashLine(String line) throws IOException {
		while (this.flag && hasSlashLast(line)) {
			String nextLine = super.readLine();
			line = line.replace(SLASH, SPACE);
			line += nextLine;
		}

		return line;
	}

	// flag가 false인 경우는 원래의 readLine메소드처럼 실행.
	public void setContinationMode(boolean flag) {
		this.flag = flag;
	}

}
