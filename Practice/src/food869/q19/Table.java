package food869.q19;

public class Table {
	private String[] title;
	private String[][] contents;
	private int[] tabSize;
	private String table = "";

	public Table(String[] title, String[][] contents) {
		setTitleContents(title, contents);
	}

	public void setTitleContents(String[] title, String[][] contents) {
		this.title = title;
		this.contents = contents;
		this.tabSize = new int[title.length];
		makeTable();
	}

	private void makeTable() {
		setTabSize();
		for (int i = 0; i < title.length; i++) {
			int size = tabSize[i] - title[i].length();
			table = table + title[i] + sizeTab(title[i], size) + "│";
		}

		table += getRow();
		for (int i = 0; i < contents.length; i++) {
			for (int j = 0; j < contents[i].length; j++) {
				int size = tabSize[j] - contents[i][j].length();
				table = table + contents[i][j] + sizeTab(contents[i][j], size) + "│";

			}
			table += "\n";
		}

	}

	private String sizeTab(String str, int size) {
		String result = "";
		for (int i = 0; i < size; i++) {
			result += " ";
		}

		return result;
	}

	private void setTabSize() {
		for (int i = 0; i < title.length; i++) {
			tabSize[i] = title[i].length();
		}
		for (int i = 0; i < contents.length; i++) {
			for (int j = 0; j < contents[i].length; j++) {
				if (contents[i][j].length() > tabSize[j]) {
					tabSize[j] = contents[i][j].length();
				}
			}
		}
	}

	private String getRow() {
		int howLong = 0;
		String row = "\n";
		for (int i : tabSize) {
			howLong += i;
		}
		for (int i = 0; i < howLong; i++) {
			row += "─";
		}
		row += "\n";
		return row;
	}

	@Override
	public String toString() {
		return this.table;
	}

}
