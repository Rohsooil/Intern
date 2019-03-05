package food869.q7;

//자바에서 주어진 Math 클래스의 함수 내용 제거.

public class Rounds {
	// 주어진 double형 숫자와 몇째 자리에서 반올림 할건지에 대한 digit
	public double round(double num, int digit) {
		// num에다가 10의 digit수 승 만큼 곱해준다.
		double change = num * (double) pow(digit);
		// 정수형으로 변환하면 소숫점 아래 숫자들이 잘려나감.
		int i_change = (int) change;
		// 1의 자리 숫자를 알아보기 위해 변환한 숫자의 10으로 나눈 나머지를 구함
		int one = i_change % 10;
		// 1의자리 숫자가 5보다 크거나 같으면 10에서 1의자리 숫자를 빼준만큼 더해준다.
		if (one >= 5) {
			i_change = i_change + (10 - one);
		} else {
			// 1의자리 숫자가 5보다 작으면 1의자라 숫자만큼 빼준다.
			i_change = i_change - one;
		}
		// 정수로 변환한 숫자를 다시 10의 digit수 승 만큼 나누어준다.
		change = i_change / (double) pow(digit);
		return change;
	}

	// 10의 digit 제곱수를 구하기 위한 함수.
	public int pow(int digit) {
		int pow_num = 1;
		for (int i = 0; i < digit; i++) {
			pow_num *= 10;
		}
		return pow_num;
	}

	public static void main(String[] args) {
		double num = 0.123456789;
		Rounds rounds = new Rounds();
		System.out.println(rounds.round(num, 3)); // 소숫점 아래 세번째 자리에서 반올림
		System.out.println(rounds.round(num, 4)); // 소숫점 아래 네번째 자리에서 반올림
		System.out.println(rounds.round(num, 5)); // 소숫점 아래 다섯번째 자리에서 반올림
		System.out.println(rounds.round(num, 6)); // 소숫점 아래 여섯번째 자리에서 반올림
	}
}
