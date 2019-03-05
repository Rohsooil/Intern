package food869.q8;

public class Test {
	public static void main(String[] args) {
		Tripled tripled = new Tripled(3, 4, 5);
		tripled.put(1, 2, 3, 33);
		tripled.put(3, 5, 5, 45); // overflow
		tripled.put(2, 3, 5, 15);
		tripled.put(1, 2, 5, 55);
		tripled.put(3, 4, 1, 75);
		tripled.put(1, 1, 1, 99);
		System.out.println(tripled.get(2, 3, 5));
		System.out.println(tripled.get(1, 2, 5));
		System.out.println(tripled.get(1, 1, 1));

		System.out.println(tripled.get(3, 3, 3)); // null
	}
}
