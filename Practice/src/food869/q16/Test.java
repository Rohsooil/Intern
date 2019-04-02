package food869.q16;

public class Test {

	public static void main(String[] args) {
		// csv : comma seperated values 파일로, 콤마로 구분하여 저장되는 형식.\
		String csv = "1,\"says \"\"aa\"\"\",c\r\n" + "\r\n" + "2,\"\"\"2,130\"\"\",d\r\n" + "\r\n"
				+ "3,hi,\"\"\"aaa\"\"\r\n" + "\"\"ddd\"\r\n" + "\r\n" + "4,yyy,zzz";
		// System.out.println(csv);
		CsvWritter csvWritter = new CsvWritter(csv);

		System.out.println(csvWritter.getData(0, 1));
		System.out.println(csvWritter.getData(0, 2));
		System.out.println(csvWritter.getData(1, 2));

		System.out.println(csvWritter.getRow(0));

		System.out.println(csvWritter.getRow(1));

		System.out.println(csvWritter.getRow(3));
	}

}
