package q13_14_15;

public class Reverse {
	public String reverseWord(String words) {
		String[] list = words.split(" ");
		String result = "";

		// �ܾ� ������ ���ڿ� �迭 ���� �� ���̰��� �̿��ؼ� �������� ���.
		for (int i = list.length - 1; i >= 0; i--) {
			result = result + list[i] + " ";
		}

		return result;
	}
}