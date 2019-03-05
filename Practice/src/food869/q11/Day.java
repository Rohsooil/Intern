package food869.q11;

public enum Day {

	// 요일에 관한건 정해져 있으므로 열겨형으로 표현
	// 요일(요일 번호, 날짜)로 구성.
	SUN(0, 0), MON(1, 0), TUE(2, 0), WEN(3, 0), THU(4, 0), FRI(5, 0), SAT(6, 0);

	private int dayNum;
	private int date;
	static final int DAY_IN_WEEK = 7;

	private Day(int dayNum, int date) {
		this.dayNum = dayNum;
		this.date = date;
	}

	public int getDayNum() {
		return this.dayNum;
	}

	@Override
	public String toString() {
		return this.date + ", " + this.name();
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}
}
