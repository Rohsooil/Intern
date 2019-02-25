package q13_14_15;

public class StringSort {
	private String str;
	private int COL;

	public StringSort(String str, int COL) {
		this.str = str;
		this.COL = COL;
	}

	// 주어진 방향으로 정렬.
	public String sort(SortType sortType) {
		String result = "";
		String direction = sortType.toString();
		String[] arr = str.split("\r\n");
		for (String s : arr) {
			result = result + wordSort(s, direction) + "\n";
		}

		return result;
	}

	// 칼럼 길이와 정렬 방향에 맞추어서 문자열 정렬.
	private String wordSort(String sortString, String direction) {
		int startOfString = setStart(sortString, direction);
		String result = "";

		for (int i = 0; i < startOfString; i++) {
			result += " ";
		}

		result += sortString;

		return result;
	}

	// 정렬 방향에 따라 문자열의 시작 위치를 정하기 위함.
	private int setStart(String sortString, String direction) {
		int lengthOfString = sortString.length();
		if (direction.equals("RIGHT")) {
			return (COL - lengthOfString);
		} else if (direction.equals("MIDDLE")) {
			return (COL - lengthOfString) / 2;
		} else {
			return 0;
		}
	}

	// 주어진 칼럼수를 가져오고 변경하는 게터 세터 메소드
	public int getCOL() {
		return COL;
	}

	public void setCOL(int COL) {
		this.COL = COL;
	}

	// 주어진 스트링을 가져오고 변경한는 게터 세터 메소드
	public String getStr() {
		return this.str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}