package food869.q2;

public class Sphere extends Shape {
	// radius : 반지름
	private int radius;

	public Sphere(int rad) {
		super();
		this.radius = rad;
	}

	// Pi * 반지름 * 반지름, 부모클래스의 size()오버라이딩.
	@Override
	public double size() {
		return radius * radius * Math.PI;
	}
}
