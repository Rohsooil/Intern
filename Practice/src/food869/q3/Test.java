package food869.q3;

public class Test {
	public static void main(String[] args) {

		Find find1 = new Find();
		Find find2 = new Find();
		Find find3 = new Find();
		Find find4 = new Find();

		System.out.println(Find.num); // 4

		find4 = null;
		System.gc();
		// System.gc();를 이용해도 가비지 컬렉터의 시점이 불분명. 따라서 반복문으로 num이 4에서 값이 바뀔때 까지 기다려봄
		while (Find.num == 4) {
			System.out.println("Waiting...");
		}

		System.out.println(Find.num); // 3
	}

}
