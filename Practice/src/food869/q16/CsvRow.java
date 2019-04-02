package food869.q16;

import food869.split.StringSplit;

public class CsvRow {
	private CsvData[] csvDatas;

	public CsvRow(String row) {
		// 콤마단위로 데이터를 구분할 때, csv형식에서 구분자로 쓰는 콤마와,
		// 따옴표 안에 데이터로 들어있는 콤마를 구분해야함.
		String[] tmpDatas = StringSplit.split(row, CsvWritter.COMMA + "");
		tmpDatas = addRemovedComma(tmpDatas);
		int numOfDatas = countDatas(tmpDatas);
		csvDatas = new CsvData[numOfDatas];

		for (int i = 0; i < numOfDatas; i++) {
			csvDatas[i] = new CsvData(tmpDatas[i]);
		}

	}

	// 이 행에 들어있는 데이터의 갯수를 반환.
	public int getRowSize() {
		return this.csvDatas.length;
	}

	// 인덱스로 데이터를 가져올 수 있는 메소드
	public CsvData getData(int index) {
		if (index >= csvDatas.length) {
			return null;
		} else {
			return csvDatas[index];
		}
	}

	// 한 행 안에 데이터 갯수를 세서 반환하는 메소드
	private int countDatas(String[] tmpDatas) {
		int num = 0;
		for (String s : tmpDatas) {
			if (s != null) {
				num++;
			}
		}
		return num;
	}

	// 따옴표 안에 들어있는 콤마는 데이터 안에 있던 콤마이므로 복구해야함.
	private String[] addRemovedComma(String[] tmpDatas) {
		for (int i = 0; i < tmpDatas.length; i++) {
			if (countQuotes(tmpDatas[i]) % 2 == 1) {
				tmpDatas[i + 1] = tmpDatas[i] + CsvWritter.COMMA + tmpDatas[i + 1];
				tmpDatas[i] = null;
			}
		}

		for (int i = 0; i < tmpDatas.length - 1; i++) {
			if (tmpDatas[i] == null) {
				tmpDatas[i] = tmpDatas[i + 1];
				tmpDatas[i + 1] = null;
			}
		}

		return tmpDatas;
	}

	// 따옴표의 갯수를 세서 반환.
	private int countQuotes(String data) {
		char[] dataToCharArr = data.toCharArray();
		int count = 0;
		for (char s : dataToCharArr) {
			if (s == CsvWritter.QUOTES) {
				count++;
			}
		}
		return count;
	}

	@Override
	public String toString() {
		String result = "";

		for (CsvData d : csvDatas) {
			result = result + d + "  ";
		}
		return result;
	}
}
