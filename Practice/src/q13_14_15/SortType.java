package q13_14_15;

public enum SortType {
	// ������ �̿�. ����׷��� ���� ���Ĺ��� ����.
	LEFT("<--LEFT-->"), MIDDLE("<--MIDDLE-->"), RIGHT("<--RIGHT-->");
	
	private String sort;
	
	private SortType (String sort) {
		this.sort = sort;
	}
	
	public String getSort() {
		return this.sort;
	}
}
