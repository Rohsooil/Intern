package food869.q10;

public class DateCompare {
	// 날짜를 비교하기 위한 DateFormat 클래스.

	// 숫자로되어있는 문자열을 비교하여 첫번째 인자값이 더 큰경우 1, 작은경우 -1, 같은 경우 0을 반환.
	private int compareString(String date1, String date2) {
		if (Integer.parseInt(date1) > Integer.parseInt(date2)) {
			return 1;
		} else if (Integer.parseInt(date1) < Integer.parseInt(date2)) {
			return -1;
		} else {
			return 0;
		}
	}

	// 두 날짜를 비교하기 위한 compareDate 메소드,파라미터로 date1, date2.
	// date1이 더 늦은 날짜면 1, 빠른 날짜면 -1 같은 날짜면 0을 반환.
	public int compareDate(String date1, String date2) {
		String[] first = date1.split("-"); // 각 날짜의 연,월 ,일 값을 배열 형태로 저장.
		String[] second = date2.split("-");
		int isSame = 0; // 두 날짜가 같은지 확인하는 변수

		for (int i = 0; i < first.length; i++) { // for문으로 각각 년, 월 ,일 비교
			if (compareString(first[i], second[i]) == 1) {
				isSame = 1; // 다른경우 이므로 false, 반복문 break;
				break;
			} else if (compareString(first[i], second[i]) == -1) {
				isSame = -1;
				break;
			}
		}

		return isSame;
	}

}