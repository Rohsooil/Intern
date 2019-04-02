package food869.q20;

import food869.q10.DateCompare;

public class Community {
	private Info completed = new Info("완료 여부");
	private Info part = new Info("구분");
	private Info name = new Info("이름");
	private Info holdNum = new Info("세대수");
	private Info address = new Info("주소");
	private Info voteDate = new Info("투표날짜");
	private Info voteNum = new Info("선거인수");
	private Info voteName = new Info("투표명");

	private Info[] infos = { completed, part, name, holdNum, address, voteDate, voteNum, voteName };

	private final String DEFAULT_ADDRESS = "서울시 서초구 남부순환로 2201";
	private final String COMPLETED = "투표완료";
	private final String UNCOMPLETED = "투표예정";
	private final String VOTING = "투표중";
	private final String SEPERATOR = "\t";
	private final String TODAY = "2019-03-15";

	public Community(String[] data) {
		for (String s : data) {
			setInfosValue(s);
		}
		setCompleted(voteDate.getValue());
		Info.index = 0;
	}

	// 각각의 정보에 값을 집어넣는 메소드.
	private void setInfosValue(String s) {
		String key = s.substring(0, s.indexOf("="));
		String value = s.substring(s.indexOf("=") + 1, s.length());

		Info i = getInfo(key);

		if (i != null) {
			i.setValue(value);
		}

		if (i.getKey().equals(address.getKey())) {
			if (isRoadNameAddress(value)) {
				address.setValue(value);
			} else {
				address.setValue(DEFAULT_ADDRESS);
			}
		}

	}

	private Info getInfo(String key) {
		for (Info i : infos) {
			if (i.getKey().equals(key)) {
				return i;
			}
		}
		return null;
	}

	// 도로명 주소인지 지번주소인지 알아보는 메소드
	private boolean isRoadNameAddress(String value) {
		if (value.endsWith("번지")) {
			return false;
		} else {
			return true;
		}
	}

	public String getCompleted() {
		return completed.getValue();
	}

	public String getPart() {
		return part.getValue();
	}

	public String getName() {
		return name.getValue();
	}

	public String getHoldNum() {
		return formatNumbers(holdNum.getValue());
	}

	public String getAddress() {
		return address.getValue();
	}

	public String getVoteDate() {
		return voteDate.getValue();
	}

	public String getVoteNum() {
		return formatNumbers(voteNum.getValue());
	}

	public String getVoteName() {
		return voteName.getValue();
	}

	// 숫자로 되어있는 스트링은 천단위로 콤마를 찍어주는 메소드.
	private String formatNumbers(String num) {
		char[] numToCharArr = num.toCharArray();
		String resultNum = "";
		for (int i = numToCharArr.length - 1; i >= 0; i--) {
			resultNum += numToCharArr[(numToCharArr.length - 1) - i];
			if ((i != 0) && (i % 3 == 0)) {
				resultNum += ',';
			}
		}
		return resultNum;
	}

	// 출력시에 탭사이즈를 어느정도 맞추기 위한 메소드.
	private String formatString(String value) {
		if (value.length() < 8) {
			value += SEPERATOR;
		}
		return value;
	}

	// 세대수를 정수값으로 반환해주는 메소드.
	public int countHoldNum() {
		int num = Integer.parseInt(holdNum.getValue());
		return num;
	}

	// 완료된 투표인지 아닌지 비교.
	// 이전에 만들었던 클래스를 재활용.
	private void setCompleted(String date) {
		DateCompare dateCompare = new DateCompare();
		switch (dateCompare.compareDate(date, TODAY)) {
		case 1:
			completed.setValue(UNCOMPLETED);
			break;
		case -1:
			completed.setValue(COMPLETED);
			break;
		default:
			completed.setValue(VOTING);
			break;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		String result = "";
		result = getCompleted() + SEPERATOR + getPart() + SEPERATOR + formatString(getName()) + SEPERATOR + getHoldNum()
				+ SEPERATOR + formatString(getAddress()) + SEPERATOR + getVoteDate() + SEPERATOR + getVoteNum()
				+ SEPERATOR + getVoteName();
		return result;
	}

}
