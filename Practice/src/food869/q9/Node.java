package food869.q9;

public class Node {
	// MyArrayList의 원소가 될 Node

	private Object data = null; // Node의 데이터 부분
	private Node next; // 해당 Node의 다음에 올 Node

	public Node(Object data) { // data를 인자로 받아와 생성
		this.data = data;
		this.next = null;
	}

	public void setNext(Node node) { // Node의 다음노드를 지정하는 메소드.
		this.next = node;
	}

	public Node getNext() { // Node의 다음 노드를 반환하는 메소드.
		return next;
	}

	public Object getData() { // Node의 데이터를 반환하는 메소드.
		return this.data;
	}

	@Override
	public String toString() {
		return this.data + "";
	}

}
