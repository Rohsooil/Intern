package q13_14_15;

public enum SortType {
	// 열거형 이용. 상수그룹을 통해 정렬방향 설정.
	LEFT("<--LEFT-->"), MIDDLE("<--MIDDLE-->"), RIGHT("<--RIGHT-->");
	
	private String sort;
	
	private SortType (String sort) {
		this.sort = sort;
	}
	
	public String getSort() {
		return this.sort;
	}
}
