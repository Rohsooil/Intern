package food869.q14;

public class Test {
	public static void main(String[] args) {
		String str = "Contents\r\n" + "1 Usage\r\n" + "2 Encoding\r\n" + "2.1 Character encodings\r\n"
				+ "2.2 Control codes\r\n" + "3 See also";

		// 주어진 문자열과 칼럼수 70으로 생성.
		StringSort stringSort = new StringSort();

		// 각 열거형의 원소들을 돌며 문자열 정렬 실행.
		for (SortType type : SortType.values()) {
			System.out.println(stringSort.sort(str, type, 70));
		}

		// 칼럼길이 100으로 변경
		stringSort.setCol(100);
		// 각 열거형의 원소들을 돌며 문자열 정렬 실행.
		for (SortType type : SortType.values()) {
			System.out.println(stringSort.sort(str, type));
		}
	}
}
