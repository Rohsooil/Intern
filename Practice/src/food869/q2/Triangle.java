package food869.q2;

public class Triangle extends Shape {
	// height : 높이, width : 너비
	private int height, width;

	public Triangle(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}

	// 밑변 * 높이 /2, 부모클래스의 size()오버라이딩.
	@Override
	public double size() {
		return (double) height * width / 2;
	}
}
