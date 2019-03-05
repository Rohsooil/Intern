package food869.q2;

public class Test {
	public static void main(String[] args) {
		Sphere sphere = new Sphere(3);
		Square square = new Square(3, 4);
		Triangle triangle = new Triangle(3, 4);
		
		System.out.println(sphere.size());
		System.out.println(square.size());
		System.out.println(triangle.size());
	}
}
