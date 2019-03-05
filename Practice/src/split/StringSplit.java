package split;

public class StringSplit {

	// regex 단위로 문자열을 자름
	public static String[] splitString(String str, String regex) {
		int strLength = str.length();
		String tmp = str;
		int numOfRegex = 0;

		// 해당 문자열에 regex 단위가 몇개 있는지 확인을 함.
		for (int i = 0; i < strLength; i++) {
			if (tmp.contains(regex)) {
				numOfRegex++;
				tmp = tmp.replaceFirst(regex, "");
			}
		}

		// regex 갯수 +1만큼의 크기를 가지는 배열 생성, regex갯수가 0개일수도 있기 때문.
		String[] result = new String[numOfRegex + 1];

		// regex 갯수 만큼 str에서 문자열을 잘라서 넣는다.
		for (int i = 0; i < numOfRegex; i++) {
			tmp = str.substring(0, str.indexOf(regex));
			result[i] = tmp;
			str = str.replaceFirst(tmp + regex, "");
		}

		// 마지막으로 남는 문자열을 마지막 인덱스에 집어넣는다.
		result[numOfRegex] = str;

		return result;
	}

}
