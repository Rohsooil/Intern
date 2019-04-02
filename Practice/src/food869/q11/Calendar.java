package food869.q11;

public class Calendar {
	private int year;
	private int month;
	private int day;

	public Calendar(String date) {
		int year_num = Integer.parseInt(date.substring(0, date.indexOf("년")));
		int month_num = Integer.parseInt(date.substring(date.indexOf(" ") + 1, date.indexOf("월")));
		int day_num = Integer.parseInt(date.substring(date.lastIndexOf(" ") + 1, date.indexOf("일")));

		setDate(year_num, month_num, day_num);
	}

	public Calendar(int year, int month, int day) {
		setDate(year, month, day);
	}

	private void setDate(int year, int month, int day) {
		this.year = year;
		if (month > 12) {
			this.month = 1;
		} else {
			this.month = month;
		}
		if (day > Month.getDaysInMonth(year, this.month)) {
			this.day = 1;
		} else {
			this.day = day;
		}
	}

	public Day getDay() {
		int days = getDays(year, month);
		days += this.day;
		days = days % Day.DAY_IN_WEEK;

		Day day = getDay(days);
		day.setDate(this.day);
		return day;
	}

	// 연도와 월을 다시 설정할 수 있도록 해주는 메소드.
	public void setTime(String date) {
		int year_num = Integer.parseInt(date.substring(0, date.indexOf("년")));
		int month_num = Integer.parseInt(date.substring(date.indexOf(" ") + 1, date.indexOf("월")));
		int day_num = Integer.parseInt(date.substring(date.lastIndexOf(" ") + 1, date.indexOf("일")));

		setDate(year_num, month_num, day_num);
	}

	// 연도와 월을 다시 설정할 수 있도록 해주는 메소드.
	public void setTime(int year, int month, int day) {
		setDate(year, month, day);
	}

	// 해당 년도는 몇일로 되어있는지 계산.
	public int getDaysInYear() {
		return Year.dayInYear(this.year);
	}

	// 해당 년도 해당 월에 몇일이 있는지 계산.
	public int getDaysInMonth() {
		return Month.getDaysInMonth(year, month);
	}

	// 해당 년도, 해당 월의 마지막 날 반환.
	public Day getLastDayInMonth() {
		int days = getDays(year, month);
		int daysInMonth = Month.getDaysInMonth(year, month);
		days += daysInMonth;
		days = days % Day.DAY_IN_WEEK;

		Day day = getDay(days);
		day.setDate(daysInMonth);

		return day;
	}

	// 해당 년도, 해당 월의 첫번째 날 반환.
	public Day getFirstDayInMonth() {
		int days = getDays(year, month);
		days += 1;
		days = days % Day.DAY_IN_WEEK;

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

	public Month getMonth() {
		Month month = null;
		for (Month m : Month.values()) {
			if (m.getMonth() == this.month) {
				month = m;
				break;
			}
		}
		return month;
	}

	// 0001년 부터 해당 년도와 해당 월까지 몇일이 있나 계산을함. 요일을 구하기 위함.
	private int getDays(int year, int month) {
		int days = (year - 1) * Year.DAY_IN_YEAR + (year / 4 - year / 100 + year / 400);

		for (Month m : Month.values()) {
			if (m.getMonth() >= month) {
				break;
			}
			days += m.getDays();
			if (m.equals(Month.FEB) && Year.isLeapYear(year)) {
				days += 1;
			}
		}

		return days;
	}

	public String getWeek() {
		String result = "";
		for (Day d : Day.values()) {
			result = result + d.name() + "\t";
		}
		result += "\n";

		result += Week.getWeek(this.year, this.month, getDay());
		return result;
	}

	// 입력받은 년도와 월을 이용해서 마지막 주를 반환.
	// 요일 요일
	// 날짜 날짜 형태로 반환
	public String getLastWeek() {
		// 해당년도와 해당하는 월의 첫번째 날인 일요일부터
		// 마지막 날짜까지 구함.
		String result = "";
		for (Day d : Day.values()) {
			result = result + d.name() + "\t";
		}
		result += "\n";

		result += Week.getWeek(this.year, this.month, getLastDayInMonth());
		return result;
	}

	// 입력받은 년도와 월을 이용해서 첫번째 주를 반환.
	// 요일 요일
	// 날짜 날짜 형태로 반환
	public String getFirstWeek() {
		// 해당년도와 해당하는 월의 첫번째 날짜부터
		// 그 주의 마지막 날인 토요일까지 구함
		String result = "";
		for (Day d : Day.values()) {
			result = result + d.name() + "\t";
		}
		result += "\n";

		result += Week.getWeek(this.year, this.month, getFirstDayInMonth());
		return result;
	}

	// 해당 년도를 반환
	public int getYear() {
		return this.year;
	}

	// 1년은 52주하고 하루나 이틀이기때문에 52주로 보는게 맞음.
	public int getWeeksInYear() {
		return Week.WEEK_IN_YEAR;
	}
}
