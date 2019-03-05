package food869.q1;


public class ToStringWith {
	//멤버변수 x,y
	private int x;
	private int y;
	//생성자
	public ToStringWith(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//자바 최상의 클래스인 Object 클래스의 toString()메소드를 오버라이딩, 내용을 재정의 한다.
	@Override
	public String toString() {
		return "ToStringWith["+this.x+", "+this.y+"]";
	}
	
	public static void main(String[] args) {
		//toString은 객체의 문자정보를 리턴하는 메소드이다. 기본적으로는 클래스@16진수해시코드로 구성된 정보를 리턴하지만
		//toString을 오버라이딩 했기 때문에 ToStringWith[42, 86] 이라고 출력된다.
		System.out.println(new ToStringWith(42, 86));
	}
}
