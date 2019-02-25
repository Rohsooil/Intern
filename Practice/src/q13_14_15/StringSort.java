package q13_14_15;

public class StringSort {
	private String str;
	private int COL;

	public StringSort(String str, int COL) {
		this.str = str;
		this.COL = COL;
	}

	// �־��� �������� ����.
	public String sort(SortType sortType) {
		String result = "";
		String direction = sortType.toString();
		String[] arr = str.split("\r\n");
		for (String s : arr) {
			result = result + wordSort(s, direction) + "\n";
		}

		return result;
	}

	// Į�� ���̿� ���� ���⿡ ���߾ ���ڿ� ����.
	private String wordSort(String sortString, String direction) {
		int startOfString = setStart(sortString, direction);
		String result = "";

		for (int i = 0; i < startOfString; i++) {
			result += " ";
		}

		result += sortString;

		return result;
	}

	// ���� ���⿡ ���� ���ڿ��� ���� ��ġ�� ���ϱ� ����.
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

	// �־��� Į������ �������� �����ϴ� ���� ���� �޼ҵ�
	public int getCOL() {
		return COL;
	}

	public void setCOL(int COL) {
		this.COL = COL;
	}

	// �־��� ��Ʈ���� �������� �����Ѵ� ���� ���� �޼ҵ�
	public String getStr() {
		return this.str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}