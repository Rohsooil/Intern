package food869.q11;

public class Year {
	
	static final int DAY_IN_YEAR = 365;


	private Year() {}

	// 1년에 몇일이 있는지 반환해주는 메소드.
	public static int dayInYear(int year) {
		if (isLeapYear(year)) {
			return DAY_IN_YEAR + 1;
		} else {
			return DAY_IN_YEAR;
		}
	}

	// 해당 년도가 윤년인지 아닌지 확인할 수 있게 해주는 메소드.
	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

}
