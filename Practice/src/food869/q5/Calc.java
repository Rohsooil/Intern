package food869.q5;

public class Calc {
	// 1/3*5 게산식을 소수점까지 정확이 계산하는 프로그램을 작성한다.
	// 1/3*5 문장을 준용하여 합니다.약간의 가감만 필요함.

	// 1/3*5 수식을 String으로 입력 받고, 곱셈과 나눗셈의 교환법칙을 이용하여 연산의 순서를 바꾸었다.
	// 1/3*5 수식을 준용, 다른 수식으로 하면 엉뚱한 결과가 나온다.... 
	public double calculation(String data) {
		String[] data_list = data.split("");
		String[] result_list;
		String tmp = "";
		double result = 0.0;
		for (int i = 0; i < data_list.length; i++) {
			if (data_list[i].equals("*")) {
				tmp = data_list[i + 1] + data_list[i];
				data = data.substring(0,i);
			}
		}
		tmp = tmp + data;
		result_list = tmp.split("");
		result = Double.parseDouble(result_list[0]);
		for(int i = 1; i< result_list.length; i++) {
			if(result_list[i].equals("*")) {
				result = result * Double.parseDouble(result_list[i+1]);
			}else if(result_list[i].equals("/")) {
				result = result / Double.parseDouble(result_list[i+1]);
			}
		}
		return result;
	}

}