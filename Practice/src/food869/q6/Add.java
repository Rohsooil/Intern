package food869.q6;

import java.math.BigDecimal;

public class Add {
	public static void main(String[] args) {
		double sum = 0.0;
		int _sum = 0;
		for(int i = 1; i <21; i++) {
			double x = 0.0;
			for(int j=0; j<i;j++) {
				x = x + 0.1;
			}
			sum = sum + x;
		}
		for(int i = 1; i <21; i++) {
			int k = 0;
			for(int j=0; j<i;j++) {
				k = k + 1;
			}
			_sum = _sum +k;
		}
		System.out.println(sum);
		System.out.println(_sum);
		
		/*
		 결과 : 21.000000000000004
		 결론 : 생각했던 결과와 다르다, 혹시나 해서 정수형 1로 똑같은 코드를 실행해봤다. 210으로 1부터 20까지 더한 값이 정확히 나온다.
		 이유 : 찾아본 결과,컴퓨터에서는 float, double의 실수표현은 부동 소숫점을 이용하기 때문에 정확한 실수를 저장할 수 없으며,
		  	  빠르게, 최대한 완벽에 가깝기를 바라는 근사치 값을 저장한다고 한다.
		  	 float의 상대오차는 약 10^-7 정도, double의 상대 오차는 약 10^-15 정도
		  	 자바에서는 BigDecimal이라는 클래스를 활용해서 이런 문제를 해결할 수 있다.
		 */
		
		BigDecimal bd_sum = new BigDecimal("0.0");
		for(int i = 1; i <21; i++) {
			BigDecimal a = new BigDecimal("0.0");
			for(int j=0; j<i;j++) {
				a = a.add(new BigDecimal("0.1"));
			}
			bd_sum = bd_sum.add(a);
		}
		System.out.println(bd_sum);
	}
}
