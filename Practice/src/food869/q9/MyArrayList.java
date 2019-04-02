package food869.q9;

//시스템에서 제공하는 ArrayList와 동일하게 동작하는 MyArrayList 클래스를 작성하라.

public class MyArrayList<Type> {
	private int size; // MyArraylist의 size
	private Node headNode; // headNode, 제일 처음으로 올 노드.

	public int size() { // MyArrayList의 size를 반환하는 메소드.
		return this.size;
	}

	public MyArrayList() { // MyArrayList 생성자
		this.size = 0;
	}

	@Override
	public String toString() { // MyArrayList를 출력하기 위한 toString 메소드.
		Node node = headNode;
		String result = "[" + node;
		for (int i = 0; i < size - 1; i++) {
			node = node.getNext();
			result = result + ", " + node;
		}
		result = result + "]";
		return result;
	}

	// MyArrayList 제일 끝 부분에 인자값으로 value라는 원소를 집어넣는 메소드.
	public void add(Type value) {
		Node newNode = new Node(value);
		if (isEmpty()) { // 비어있는 리스트라면 새로운 값이 headNode가 된다.
			headNode = newNode;
		} else {
			// newNode의 바로 앞에 올 prevNode를 찾기 위해 size -1만큼 반복문 실행
			Node prevNode = headNode;
			for (int i = 0; i < this.size - 1; i++) {
				prevNode = prevNode.getNext();
			}
			// prevNode의 다음 노드를 newNode로 지정
			prevNode.setNext(newNode);
		}
		this.size++;

	}

	// 주어진 index에 두번째 인자값으로 주어진 value를 삽입하기 위한 메소드.
	public void add(int index, Type value) {
		if (index > this.size || index < 0) { // 주어진 index가 size보다 크거나 0보다 작으면 집어 넣을수 없음.
			System.out.println("IndexOutOfBounds");
		} else {
			Node prevNode = headNode;
			Node newNode = new Node(value);
			// newNode의 prevNode를 찾기 위해 index -1만큼 반복문 실행.
			for (int i = 0; i < index - 1; i++) {
				prevNode = prevNode.getNext();
			}
			// newNode의 다음 노드를 이전노드의 다음 노드로 지정.
			newNode.setNext(prevNode.getNext());
			// 이전 노드의 다음노드로 newNode를 지정.
			prevNode.setNext(newNode);
			this.size++;

		}
	}

	// 해당 인덱스의 원소를 삭제하기 위하 메소드.
	public void remove(int index) {
		if (index > this.size || index < 0) { // index가 size보다 크거나 0보다 작으면 지울 수 없음.
			System.out.println("IndexOutOfBounds");
		} else if (index == 0) {
			// 주어진 index가 0이면 headNode를 다음 노드로 지정. removeNode는 지워질 노드
			Node removeNode = headNode;
			headNode = removeNode.getNext();
			// removeNode를 null값으로 처리.
			removeNode = null;
			this.size--;
		} else {
			// 주어진 index가 1 이상일 때 지워질 노드와 이전 노드를 찾기 위해 (index -1)만큼 반복문 실행
			Node prevNode = headNode;
			for (int i = 0; i < index - 1; i++) {
				prevNode = prevNode.getNext();
			}
			// 지워질 노드는 이전 노드의 다음 노드.
			Node removeNode = prevNode.getNext();
			// 이전노드의 다음 노드를 지워질 노드의 다음노드로 설정.
			prevNode.setNext(removeNode.getNext());
			removeNode = null;
			this.size--;
		}

	}

	// MyArrayList에서 해당하는 value값을 삭제하기 위한 메소드.
	public boolean remove(Type value) {
		Node node = headNode;
		int index = -1; // 지워질 노드의 index를 찾는다, 초기값은 -1;
		for (int i = 0; i < this.size; i++) {
			// vaule와 이전노드의 값이 같을때의 i를 index에 넣고 반복문 종료.
			if (node.getData().equals(value)) {
				index = i;
				break;
			}
			node = node.getNext();
		}
		if (index != -1) {
			// 해당 index의 원소를 remove하는 메소드 호출.
			remove(index);
			return true;
		} else {
			return false;
		}
	}

	// MyArrayList의 원소의 index를 찾는 메소드. 제일 처음으로 찾는 값 반환. 없으면 -1 반환.
	public int indexOf(Object value) {
		Node node = headNode;
		for (int i = 0; i < this.size; i++) {
			if (node.getData().equals(value)) {
				return i;
			}
			node = node.getNext();
		}
		return -1;
	}

	// MyArrayList의 원소의 index를 찾는 메소드. 제일 마지막으로 찾는 값 반환. 없으면 -1 반환.
	public int lastIndexOf(Object value) {
		Node node = headNode;
		int num = -1;
		for (int i = 0; i < this.size; i++) {
			if (node.getData().equals(value)) {
				num = i;
			}
			node = node.getNext();
		}
		return num;
	}

	// MyArrayList가 비어있는지 확인
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	// MyArrayList에 해당 index에 있는 원소를 반환하는 메소드.
	@SuppressWarnings("unchecked")
	public Type get(int index) {
		if (index > this.size || index < 0) {
			return null;
		} else {
			Node node = headNode;
			for (int i = 0; i < index; i++) {
				node = node.getNext();
			}
			return (Type) node.getData();
		}
	}

	// MyArrayList에 해당하는 원소가 있으면 true 없으면 false를 반환하는 메소드.
	public boolean contains(Object value) {
		Node node = headNode;
		for (int i = 0; i < this.size; i++) {
			if (node.getData().equals(value)) {
				return true;
			}
			node = node.getNext();
		}
		return false;
	}

}
