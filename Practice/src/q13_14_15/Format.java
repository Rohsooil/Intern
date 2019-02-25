package q13_14_15;

public class Format {
	private String sentence;

	public Format(String sentence) {
		this.sentence = sentence;
	}

	public String formatSentence(int col) {
		String result = "";

		// ���� ���ڿ� ���� ���� \r\n�� �ι� ���� �� ���� �������� �ٲ���.
		// ���� ������ ������ ©��, �ܾ������ ���ڿ� ��� ����.
		sentence = sentence.replaceAll("\r\n\r\n", " ");
		String[] arr = sentence.split(" ");

		// ���� ���� �ľ��ϱ� ���� ����.
		// ��ü ���ڿ��� Į�� �� ������ ����. �� ���ڸ� �̿��� ����.
		int wordNum = 0;
		int gap = sentence.length() - col;

		for (String word : arr) {
			if (wordNum > col - gap) { // ���� ������ Į�� ������ ���̸�ŭ ���ź��� Ŀ���� ����.
				result += "\n";
				wordNum = 0;
			} else {
				wordNum = result.length();
			}
			result = result + word + " "; // ��� ���ڿ��� ���ڿ� ���⸦ ��� ������
		}

		return result;
	}
}
