package q11;

public class Year {
	private int year;
	private final int DAY_IN_YEAR = 365;

	public int getYear() {
		return year;
	}

	public Year(int year) {
		this.year = year;
	}

	// 1년에 몇일이 있는지 반환해주는 메소드.
	public int dayInYear() {
		if (isLeapYear()) {
			return DAY_IN_YEAR + 1;
		} else {
			return DAY_IN_YEAR;
		}
	}

	// 해당 년도가 윤년인지 아닌지 확인할 수 있게 해주는 메소드.
	public boolean isLeapYear() {
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

}
