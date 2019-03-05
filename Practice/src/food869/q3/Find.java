package food869.q3;

public class Find {
	// 자신의 클래스로 인스턴트화 되어 사용되는 객체의 갯수를 알아보기 위해서
	// 동일한 클래스 내의 객체끼리 공유되게 하도록 static 키워드의 멤버 변수를 생성한다.
	// static 키워드로 생성된 멤버 변수는 클래스가 메모리에 올라갈 때 생성된다.
	static int num = 0;

	// 생성자로 객체의 갯수가 늘어날 때 마다 증가시킨다.
	public Find() {
		Find.num++;
	}

	// finalize()는 JVM이 가비지 컬렉션이 수행될 때 더 이상 사용되지 않는 자원에 대한 정리를 진행할 때 호출하는 메소드.
	// 이를 Object 클래스에서 오버라이드하여 소멸될 때 num 1 감소.
	@Override
	protected void finalize() throws Throwable {
		Find.num--;
		super.finalize();
	}

}
