package food869.q16;

public class CsvData {
	private String data;

	public CsvData(String data) {
		this.data = removeQuotes(data);
	}

	// csv 형식에서 불필요하게 증가한 따옴표를 제거.
	private String removeQuotes(String data) {
		char[] dataToCharArr = data.toCharArray();
		if (dataToCharArr[0] == '"' && dataToCharArr[dataToCharArr.length - 1] == CsvWritter.QUOTES) {
			String resultData = "";
			for (int i = 1; i < dataToCharArr.length - 1; i++) {
				resultData += dataToCharArr[i];
			}
			resultData = resultData.replaceAll(CsvWritter.DOUBLE_QUOTES, CsvWritter.QUOTES + "");
			return resultData;
		} else {
			return data;
		}

	}

	@Override
	public String toString() {
		return this.data;
	}

}
