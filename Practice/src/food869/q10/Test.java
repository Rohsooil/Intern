package food869.q10;

public class Test {
	public static void main(String[] args) {
		// 입력 시 yyyy-mm-dd 형태로 입력 받아야함.
		String date1 = "1999-12-31";
		String date2 = "2000-01-01";

		DateCompare dateCompare = new DateCompare();
		switch (dateCompare.compareDate(date1, date2)) {
		case 1:
			System.out.println(date1 + " is after " + date2);
			break;
		case -1:
			System.out.println(date2 + " is after " + date1);
			break;
		default:
			System.out.println(date1 + " is same " + date2);
			break;
		}
	}
}
