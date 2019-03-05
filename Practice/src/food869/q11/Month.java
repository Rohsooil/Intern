package food869.q11;

public enum Month {
	// 월을 정해진 값이 있으므로 열거형으로 표현.
	// 월(월 번호, 일수) 로 구성.
	JAN(1, 31), FEB(2, 28), Mar(3, 31), APR(4, 30), MAY(5, 31), JUN(6, 30), JUL(7, 31), AUG(8, 31), SEP(9, 30),
	OCT(10, 31), NOV(11, 30), DEC(12, 31);

	private int days;
	private int month;

	private Month(int month, int days) {
		this.month = month;
		this.days = days;
	}

	public int getMonth() {
		return this.month;
	}

	public int getDays() {
		return this.days;
	}

	// 해당 년도 해당 월에 몇 일이 있는지 계산.
	// static 메소드로 만들어서 객체화 하지 않고 사용가능.
	public static int getDaysInMonth(int year, int month) {
		int days = 0;
		for (Month m : Month.values()) {
			if (m.getMonth() == month) {
				days = m.getDays();
			}
		}
		if (month == 2 && Year.isLeapYear(year)) {
			days += 1;
		}

		return days;
	}
	
	@Override
	public String toString() {
		return this.month + ", " + this.name();
	}

}
