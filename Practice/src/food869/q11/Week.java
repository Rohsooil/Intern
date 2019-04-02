package food869.q11;

public class Week {
	static final int WEEK_IN_YEAR = 52;

	private Week() {
	}

	public static String getWeek(int year, int month, Day day) {
		int firstday = day.getDate() - day.getDayNum();
		String result = "";
		int count = 0;
		if (firstday < 0) {
			count = -firstday;
			firstday = Month.getDaysInMonth(year, month - 1) - count;
			result = divdeFirst(firstday, count);
		} else if (firstday + Day.DAY_IN_WEEK > Month.getDaysInMonth(year, month)) {
			count = day.getDayNum();
			result = divdeFirst(firstday, count);
		} else {
			for (int i = count; i < Day.DAY_IN_WEEK; i++) {
				result = result + firstday++ + "\t";
			}
		}
		return result;
	}

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
