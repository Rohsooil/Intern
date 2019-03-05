package food869.strutil;

import food869.q13.Format;
import food869.q14.SortType;
import food869.q14.StringSort;
import food869.q15.Reverse;

public class StringUtil {
	private Format format;
	private StringSort stringSort;
	private Reverse reverse;

	public StringUtil() {
		this.format = new Format();
		this.reverse = new Reverse();
		this.stringSort = new StringSort();
	}

	public String formatSentence(String str, int col) {
		return this.format.formatSentence(str, col);
	}

	public String sort(String str, int col, SortType sortType) {
		this.setSortCol(col);
		return this.stringSort.sort(str, sortType);
	}

	public String sort(String str, SortType sortType) {
		return this.stringSort.sort(str, sortType);
	}

	public void setSortCol(int col) {
		this.stringSort.setCol(col);
	}

	public String reverseWord(String words) {
		return this.reverse.reverseWord(words);
	}

}
