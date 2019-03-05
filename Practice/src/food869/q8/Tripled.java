package food869.q8;

public class Tripled {
	private int page, row, col, size = 100;
	// 동일한 크기의 문자열 배열과 int형 배열 두개 선언
	private String positions[] = new String[size];
	private int values[] = new int[size];
	// 배열에 몇개만큼 들어갔는지 알기 위해 pointer 변수 선언.
	private int pointer = 0;

	// 생성자를 통해 page,row,col (3차원 배열의 행,렬, 페이지) 초기화
	public Tripled(int page, int row, int col) {
		this.page = page;
		this.row = row;
		this.col = col;
	}

	// 3차원 배열 모양의 1차원 배열에 원소를 집어넣는 메소드
	public void put(int page, int row, int col, int value) {
		// 주어진 행렬의 인덱스보다 더 큰 인덱스를 넣을려고 하면 오버플로우
		if (this.page < page || this.row < row || this.col < col) {
			System.out.println("Overflow");
		} else {
			// page,row,col 형태로 포지션을 문자열로 만들고 positions 문자열 배열에 넣는다.
			String position = page + "," + row + "," + col;
			positions[pointer] = position;
			// 원소값은 원소끼리 모여있는 배열에 저장
			values[pointer] = value;
			// 포인터 +1
			pointer = pointer + 1;
		}
	}

	// 해당 포지션에 원소를 확인하기 위한 메소드.
	public Object get(int page, int row, int col) {
		// 파라미터로 주어진 page,row,col 형태로 position 문자열을 만듬.
		String position = page + "," + row + "," + col;
		int where = -1;
		// pointer(배열에 실제로 저장되어있는 최대 크기) 만큼 반복문을 실행, 파라미터로 주어진 position과 같은 값이 있나 찾아본다.
		for (int i = 0; i < pointer; i++) {
			// 찾는다면 해당 원소의 인덱스를 찾고 반복문 종료.
			if (positions[i].equals(position)) {
				where = i;
				break;
			}
		}
		// 못찾으면 null 값 반환
		if (where == -1) {
			return null;
		} else {
			return values[where];
		}
	}
}
