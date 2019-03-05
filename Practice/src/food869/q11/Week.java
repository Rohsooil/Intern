package food869.q11;

public class Week {
	static final int WEEK_IN_YEAR = 52;

	private Week() {
	}

	// 연도, 월, 일에 대해서 한 주에 관한 값을 일요일부터 토요일까지 문자열로 반환.
	public static String getWeek(int year, int month, Day day) {
		int firstday = day.getDate() - day.getDayNum(); // 해당 주의 일요일 날짜 계산.
		String result = "";
		int count = 0;

		// 일요일의 날짜가 0보다 작으면 일요일은 그 전달의 마지막 주.
		if (firstday < 0) {
			count = -firstday;
			firstday = Month.getDaysInMonth(year, month - 1) - count;
			result = divdeFirst(firstday, count);
		} else if (firstday + Day.DAY_IN_WEEK > Month.getDaysInMonth(year, month)) {
			// 일요일 날짜 + 7일이 해당 날짜의 마지막 날보다 크다면, 그 주는 마지막 주고, 다음달로 넘어가는 주.
			count = day.getDayNum();
			result = divdeFirst(firstday, count);
		} else {
			for (int i = count; i < Day.DAY_IN_WEEK; i++) {
				result = result + firstday++ + "\t";
			}
		}
		return result;
	}

	// 입력받은 날짜가 속한 주의 첫번째 날짜를 구하기 위한 메소드.
	private static String divdeFirst(int firstday, int count) {
		String result = "";
		for (int i = 0; i <= count; i++) {
			result = result + firstday++ + "\t";
		}
		firstday = 1;
		for (int i = count + 1; i < Day.DAY_IN_WEEK; i++) {
			result = result + firstday++ + "\t";
		}
		return result;
	}
}
