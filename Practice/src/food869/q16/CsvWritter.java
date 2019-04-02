package food869.q16;

import food869.split.StringSplit;

public class CsvWritter {
	static final String LINE_COMMA = "\r\n\r\n";
	static final char QUOTES = '"';
	static final String DOUBLE_QUOTES = "\"\"";
	static final char COMMA = ',';
	private CsvRow[] csvRows;

	public CsvWritter(String csvData) {
		String[] tmp_Rows = StringSplit.split(csvData, LINE_COMMA);
		csvRows = new CsvRow[tmp_Rows.length];
		for (int i = 0; i < tmp_Rows.length; i++) {
			csvRows[i] = new CsvRow(tmp_Rows[i]);
		}
	}

	public CsvRow getRow(int index) {
		if (index > csvRows.length) {
			return null;
		} else {
			return csvRows[index];
		}
	}

	public CsvData getData(int row, int col) {
		if (row >= csvRows.length || col >= csvRows[row].getRowSize()) {
			return null;
		} else {
			return csvRows[row].getData(col);
		}
	}

}
