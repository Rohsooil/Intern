package q13_14_15;

public class StringSort {
	private String str;
	private int col;

	// �־��� �������� ����.
	public String sort(String str, SortType sortType) {
		this.setStr(str);
		String result = wordSort(sortType.getSort(), sortType) + "\n";
		String[] arr = str.split("\r\n");
		for (String s : arr) {
			result = result + wordSort(s, sortType) + "\n";
		}

		return result;
	}

	public String sort(String str, SortType sortType, int col) {
		this.setCol(col);
		return this.sort(str, sortType);
	}

	// Į�� ���̿� ���� ���⿡ ���߾ ���ڿ� ����.
	private String wordSort(String sortString, SortType direction) {
		int startOfString = setStart(sortString, direction);
		String result = "";

		for (int i = 0; i < startOfString; i++) {
			result += " ";
		}

		result += sortString;

		return result;
	}

	// ���� ���⿡ ���� ���ڿ��� ���� ��ġ�� ���ϱ� ����.
	private int setStart(String sortString, SortType direction) {
		int lengthOfString = sortString.length();
		if (direction.equals(SortType.RIGHT)) {
			return (col - lengthOfString);
		} else if (direction.equals(SortType.MIDDLE)) {
			return (col - lengthOfString) / 2;
		} else {
			return 0;
		}
	}

	// �־��� Į������ �������� �����ϴ� ���� ���� �޼ҵ�
	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	// �־��� ��Ʈ���� �������� �����Ѵ� ���� ���� �޼ҵ�
	public String getStr() {
		return this.str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}