package q13_14_15;

public class Format {
	private String sentence;

	public Format(String sentence) {
		this.sentence = sentence;
	}

	public String formatSentence(int col) {
		String result = "";

		// 기존 문자열 개행 제거 \r\n이 두번 연속 들어간 것을 공백으로 바꿔줌.
		// 공백 단위로 문장을 짤라, 단어단위의 문자열 행렬 생성.
		sentence = sentence.replaceAll("\r\n\r\n", " ");
		String[] arr = sentence.split(" ");

		// 문자 갯수 파악하기 위한 변수.
		// 전체 문자열과 칼럼 수 사이의 차이. 이 숫자를 이용해 개행.
		int wordNum = 0;
		int gap = sentence.length() - col;

		for (String word : arr) {
			if (wordNum > col - gap) { // 문자 갯수가 칼럼 수에서 차이만큼 뺀거보다 커지면 개행.
				result += "\n";
				wordNum = 0;
			} else {
				wordNum = result.length();
			}
			result = result + word + " "; // 결과 문자열에 문자와 띄어쓰기를 계속 더해줌
		}

		return result;
	}
}
