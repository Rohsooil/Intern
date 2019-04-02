package food869.q11;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		java.util.Calendar c = java.util.Calendar.getInstance();

		// 2019년 3월 4일
		Calendar cc = new Calendar("2019년 3월 7일");
		System.out.println(cc.getDaysInYear());
		System.out.println(cc.getDaysInMonth());
		System.out.println(cc.getLastDayInMonth());
		System.out.println(cc.getFirstDayInMonth());
		System.out.println(cc.getWeeksInYear());
		System.out.println(cc.getFirstWeek());
		System.out.println(cc.getLastWeek());
		System.out.println(cc.getDay());
		System.out.println(cc.getWeek());

		System.out.println();

		// 2020년 2월 29일
//		cc.setTime(2020,2,29);
//		System.out.println(cc.getDaysInYear());
//		System.out.println(cc.getDaysInMonth());
//		System.out.println(cc.getLastDayInMonth()); 
//		System.out.println(cc.getFirstDayInMonth()); 
//		System.out.println(cc.getWeeksInYear());
//		System.out.println(cc.getFirstWeek());
//		System.out.println(cc.getLastWeek());
	}
}
