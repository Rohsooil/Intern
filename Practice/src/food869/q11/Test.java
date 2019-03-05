package food869.q11;

public class Test {
	public static void main(String[] args) {
		java.util.Calendar c = java.util.Calendar.getInstance();

		// 2019년 3월 4일
		Calendar cc = new Calendar("2019년 3월 7일");
		System.out.println(cc.getDaysInYear()); // 365
		System.out.println(cc.getDaysInMonth()); // 31
		System.out.println(cc.getLastDayInMonth()); // 31,SUN
		System.out.println(cc.getFirstDayInMonth()); // 1,FRI
		System.out.println(cc.getWeeksInYear()); // 52
		System.out.println(cc.getFirstWeek()); // 첫번째 주
		System.out.println(cc.getLastWeek()); // 마지막 주
		System.out.println(cc.getDate()); // 3월 7일
		System.out.println(cc.getWeek()); // 3월 7일이 있는 주
		System.out.println(cc.getMonth()); // 3, March

		System.out.println();

		// 2020년 2월 29일
		cc.setTime(2020, 1, 31);
		System.out.println(cc.getDaysInYear()); // 366
		System.out.println(cc.getDaysInMonth()); // 29
		System.out.println(cc.getLastDayInMonth()); // 29,SUN
		System.out.println(cc.getFirstDayInMonth()); // 1,SUN
		System.out.println(cc.getWeeksInYear()); // 52
		System.out.println(cc.getFirstWeek()); // 첫번째 주
		System.out.println(cc.getLastWeek()); // 마지막 주
		System.out.println(cc.getDate()); // 2월 29일
		System.out.println(cc.getWeek()); // 2월 29일이 있는 주
		System.out.println(cc.getMonth()); // 2, Feb
		
	}
}
