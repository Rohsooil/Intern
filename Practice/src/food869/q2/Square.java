package food869.q2;

public class Square extends Shape {
	// height : 높이, width : 너비
	private int height, width;

	public Square(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}

	// 밑변 * 높이, 부모클래스의 size()오버라이딩.
	@Override
	public double size() {
		return width * height;
	}
}
