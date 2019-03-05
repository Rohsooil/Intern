package food869.split;

public class StringSplit {

	// regex 단위로 문자열을 자름
	// 인자로 주어진 문자열을 문자단위 배열로 바꾸고,
	// regex를 몇개 가지고 있는 지 파악한 후에
	// regex갯수 +1 개만큼의 문자열 배열로 자른다.
	public static String[] split(String str, String regex) {
		char[] arr = str.toCharArray();
		int numOfRegex = getNumOfRegex(arr, regex);
		String[] result = getStringArr(arr, regex, numOfRegex);

		// 문자열 배열에서 regex를 제거해서 출력.
		for (int i = 0; i < numOfRegex; i++) {
			result[i] = result[i].replace(regex, "");
		}

		return result;
	}

	// regex의 갯수+1개 만큼 문자열 배열을 만들고,
	// 각각의 배열 원소로 문자열을 더해 만들어서 집어넣는다.
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

	// regex의 갯수를 파악하기 위해 문자열을 더하다가 regex를 가지고 있는 문자열이 나오면 numOfRegex를 증가시키고
	// 문자열에 공백 대입하는 과정으로 반복문 실행
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
