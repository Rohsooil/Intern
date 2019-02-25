package q13_14_15;

public class StringUtil {
	private Format format;
	private StringSort stringSort;
	private Reverse reverse;

	public String formatSentence(String str, int col) {
		this.format = new Format(str);
		return this.format.formatSentence(col);
	}

	public String sort(String str, int col, SortType sortType) {
		this.stringSort = new StringSort(str, col);
		return this.stringSort.sort(sortType);
	}

	public String reverseWord(String words) {
		reverse = new Reverse();
		return this.reverse.reverseWord(words);
	}

}
