package q11;

public class Test {
	public static void main(String[] args) {
//		

		// 2019년 2월
		Calendar cc = new Calendar("2019�� 2��");
		System.out.println(cc.getDaysInYear());
		System.out.println(cc.getDaysInMonth());
		System.out.println(cc.getLastDayInMonth()); // 28, Thursday
		System.out.println(cc.getFirstDayInMonth()); // 1, Friday
		System.out.println(cc.getWeeksInYear());
		System.out.println(cc.getFirstWeek());
		System.out.println(cc.getLastWeek());

		System.out.println();

		// 2019년 9월
		cc.setTime("2019�� 9��");
		System.out.println(cc.getDaysInYear());
		System.out.println(cc.getDaysInMonth());
		System.out.println(cc.getLastDayInMonth()); // 31, Sunday
		System.out.println(cc.getFirstDayInMonth()); // 1, Friday
		System.out.println(cc.getWeeksInYear());
		System.out.println(cc.getFirstWeek());
		System.out.println(cc.getLastWeek());
	}
}
