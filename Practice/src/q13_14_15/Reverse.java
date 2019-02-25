package q13_14_15;

public class Reverse {
	public String reverseWord(String words) {
		String[] list = words.split(" ");
		String result = "";

		// 단어 단위로 문자열 배열 생성 및 길이값을 이용해서 역순으로 출력.
		for (int i = list.length - 1; i >= 0; i--) {
			result = result + list[i] + " ";
		}

		return result;
	}
}