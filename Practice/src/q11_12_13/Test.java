package q13_14_15;

public class Test {
	public static void main(String[] args) {
		////////////////////////////
		///// q13
		///////////////////////////
		String sentence = "It's a nice\r\n" + "\r\n" + "day, isn't it, Mr. Mxyzzptllxy?\r\n" + "\r\n"
				+ "I think we should\r\n" + "\r\n" + "go for a walk.";

		Format format = new Format(sentence);
		System.out.println(format.formatSentence(72));
		
		

		////////////////////////////
		///// q14
		///////////////////////////
		String str = "Contents\r\n" + "1 Usage\r\n" + "2 Encoding\r\n" + "2.1 Character encodings\r\n"
				+ "2.2 Control codes\r\n" + "3 See also";

		// 주어진 문자열과 칼럼수 70으로 생성.
		StringSort stringSort = new StringSort(str, 70);

		// 각 열거형의 원소들을 돌며 문자열 정렬 실행.
		for (SortType type : SortType.values()) {
			System.out.println(stringSort.sort(type));
		}
		
		

		////////////////////////////
		///// q15
		///////////////////////////
		String words = "Father Charles Goes Down And Ends Battle";
		Reverse reveres = new Reverse();

		System.out.println(reveres.reverseWord(words));
	}
}
