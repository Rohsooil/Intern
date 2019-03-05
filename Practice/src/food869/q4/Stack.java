package food869.q4;

public class Stack {
	private int Max, point;	//스택 최대 크기와, 스택의 포인트(top)
	private Object[] store; //스택의 원소들이 들어갈 배열
	
	public Stack(int Max) {	//스택 생성시에 스택의 크기를 파리미터 값으로 받아옴 
		this.Max = Max;		
		this.store = new Object[Max];
		this.point = 0;
	}
	//스택에 원소를 집어 넣는 메소드
	public void push(Object parm) {
		//스택이 차 있으면 오버플로우
		if(isFull()) {	
			System.out.println("Cannot Push IsFull");
		}else {			
			store[point++] = parm; //원소를 스택배열에 넣어주고 point 증가
			printStack();
		}
	}
	public void pop() {
		//스택이 비어있는 경우
		if(isEmpty()) {
			System.out.println("Cannot Pop IsEmpty.");
		}else{
			point--;	//point를 1 감소
			printStack();
		}
	}
	
	//스택의 최 상단에 있는 원소를 보여주기 위한 top 메소드
	public Object top() {
		return store[point-1];
	}
	
	//스택이 비어있는지 확인 point가 0보다 같거나 작아지면 스택이 비어있음
	public boolean isEmpty() {
		return (point<=0)?true:false;
	}
	
	//스택이 Max보다 커지나 같아지면 스택이 가득 차있는 상태.
	public boolean isFull() {
		return (point>=Max)?true:false;
	}
	
	//스택의 원소들을 출력하기 위한 메소드.
	public void printStack() {
		for(int i =0; i< point; i++) {
			System.out.print(store[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Stack stack = new Stack(100);
		stack.push("one");
		stack.push("Tow");
		stack.push(new Integer(1));
		stack.pop();
		stack.push(new Double(5.0));
		stack.push("Three");
		stack.pop();
		stack.pop();
	}
}
