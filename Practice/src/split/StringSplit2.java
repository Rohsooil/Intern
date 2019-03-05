package split;

public class StringSplit2 {

	// regex 단위로 문자열을 자름
	public static String[] splitString(String str, String regex) {
		char[] arr = str.toCharArray();
		int numOfRegex = getNumOfRegex(arr, regex);
		String[] result = getStringArr(arr, regex, numOfRegex);

		for (int i = 0; i < numOfRegex; i++) {
			result[i] = result[i].replace(regex, "");
		}

		return result;
	}

	private static String[] getStringArr(char[] arr, String regex, int numOfRegex) {
		String[] result = new String[numOfRegex + 1];
		String tmp = "";
		int index = 0;

		for (char c : arr) {
			tmp += c;
			if (tmp.contains(regex)) {
				result[index++] = tmp;
				tmp = "";
			}
		}
		result[numOfRegex] = tmp;
		return result;
	}

	private static int getNumOfRegex(char[] arr, String regex) {
		int numOfRegex = 0;
		String tmp = "";
		for (char c : arr) {
			tmp += c;
			if (tmp.contains(regex)) {
				numOfRegex++;
				tmp = "";
			}
		}
		return numOfRegex;
	}
}
