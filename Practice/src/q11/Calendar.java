package q11;

public class Calendar {
	private Year year;
	private int month;
	private final int DAY_IN_WEEK = 7;
	private final int WEEK_IN_YEAR = 52;
	private final int DAY_IN_YEAR = 365;

	public Calendar(String date) {
		int year_num = Integer.parseInt(date.substring(0, date.indexOf("��")));
		int month_num = Integer.parseInt(date.substring(date.indexOf(" ") + 1, date.indexOf("��")));

		this.year = new Year(year_num);
		this.month = month_num;
	}

	// 연도와 월을 다시 설정할 수 있도록 해주는 메소드.
	public void setTime(String date) {
		int year_num = Integer.parseInt(date.substring(0, date.indexOf("��")));
		int month_num = Integer.parseInt(date.substring(date.indexOf(" ") + 1, date.indexOf("��")));

		this.year = new Year(year_num);
		this.month = month_num;
	}

	// 해당 년도는 몇일로 되어있는지 계산.
	public int getDaysInYear() {
		return this.year.dayInYear();
	}

	// 해당 년도 해당 월에 몇일이 있는지 계산.
	public int getDaysInMonth() {
		return Month.getDaysInMonth(year, month);
	}

	// 해당 년도, 해당 월의 마지막 날 반환.
	public Day getLastDayInMonth() {
		int days = getDays(year.getYear(), month);
		int daysInMonth = Month.getDaysInMonth(year, month);
		days += daysInMonth;
		days = days % DAY_IN_WEEK;

		Day day = getDay(days);
		day.setDate(daysInMonth);

		return day;
	}

	// 해당 년도, 해당 월의 첫번째 날 반환.
	public Day getFirstDayInMonth() {
		int days = getDays(year.getYear(), month);
		days += 1;
		days = days % DAY_IN_WEEK;

		Day day = getDay(days);
		day.setDate(1);

		return day;
	}

	// 구해진 총 일수로 요일을 알아내고 날짜형태로 반환.
	private Day getDay(int days) {
		Day day = null;
		for (Day d : Day.values()) {
			if (d.getDayNum() == days) {
				day = d;
				break;
			}
		}
		return day;
	}

	// 0001년 부터 해당 년도와 해당 월까지 몇일이 있나 계산을함. 요일을 구하기 위함.
	private int getDays(int year, int month) {
		int days = (year - 1) * DAY_IN_YEAR + (year / 4 - year / 100 + year / 400);

		for (Month m : Month.values()) {
			if (m.getMonth() >= month) {
				break;
			}
			days += m.getDays();
			if (m.equals(Month.FEB) && this.year.isLeapYear()) {
				days += 1;
			}
		}

		return days;
	}

	// 입력받은 년도와 월을 이용해서 마지막 주를 반환.
	// 요일 요일
	// 날짜 날짜 형태로 반환
	public String getLastWeek() {
		// 해당년도와 해당하는 월의 첫번째 날인 일요일부터
		// 마지막 날짜까지 구함.
		Day d = getLastDayInMonth();
		Day[] days = Day.values();
		int lastday = d.getDate();
		lastday -= d.getDayNum();
		String week = "";
		for (int i = 0; i <= d.getDayNum(); i++) {
			week = week + days[i].name() + " ";
		}
		week += "\n";

		for (int i = 0; i <= d.getDayNum(); i++) {
			week = week + lastday + "  ";
			lastday++;
		}
		return week;
	}

	// 입력받은 년도와 월을 이용해서 첫번째 주를 반환.
	// 요일 요일
	// 날짜 날짜 형태로 반환
	public String getFirstWeek() {
		// 해당년도와 해당하는 월의 첫번째 날짜부터
		// 그 주의 마지막 날인 토요일까지 구함
		Day d = getFirstDayInMonth();
		Day[] days = Day.values();
		int firstday = d.getDate();
		String week = "";
		for (int i = d.getDayNum(); i < days.length; i++) {
			week = week + days[i].name() + " ";
		}
		week += "\n";

		for (int i = d.getDayNum(); i < days.length; i++) {
			week = week + firstday + "   ";
			firstday++;
		}
		return week;
	}

	// 해당 년도를 반환
	public int getYear() {
		return this.year.getYear();
	}

	// 1년은 52주하고 하루나 이틀이기때문에 52주로 보는게 맞음.
	public int getWeeksInYear() {
		return WEEK_IN_YEAR;
	}
}
