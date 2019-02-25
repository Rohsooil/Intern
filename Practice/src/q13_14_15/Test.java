package q13_14_15;

public class Test {
	public static void main(String[] args) {
		StringUtil stringUtil = new StringUtil();
		////////////////////////////////////////////////////////////////////////////////
		///// -------------------------------q13---------------------------------- /////
		////////////////////////////////////////////////////////////////////////////////
		String sentence = "It's a nice\r\n" + "\r\n" + "day, isn't it, Mr. Mxyzzptllxy?\r\n" + "\r\n"
				+ "I think we should\r\n" + "\r\n" + "go for a walk.";

		System.out.println(stringUtil.formatSentence(sentence, 72));
		System.out.println();

		////////////////////////////////////////////////////////////////////////////////
		///// -------------------------------q14---------------------------------- /////
		////////////////////////////////////////////////////////////////////////////////
		String str = "Contents\r\n" + "1 Usage\r\n" + "2 Encoding\r\n" + "2.1 Character encodings\r\n"
				+ "2.2 Control codes\r\n" + "3 See also";

		for (SortType type : SortType.values()) {
			System.out.println(stringUtil.sort(str, 70, type));
		}

		////////////////////////////////////////////////////////////////////////////////
		///// -------------------------------q15---------------------------------- /////
		////////////////////////////////////////////////////////////////////////////////
		String words = "Father Charles Goes Down And Ends Battle";
		System.out.println(stringUtil.reverseWord(words));
	}
}
