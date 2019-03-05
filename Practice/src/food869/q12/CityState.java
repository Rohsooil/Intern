package food869.q12;

public class CityState {
	private City city;
	private State state;

	public City getCity() {
		return this.city;
	}
	
	public void setCity(City newCity) {
		this.city = newCity;
	}

	public State getState() {
		return this.state;
	}
	
	public void setState(State newState) {
		this.state = newState;
	}

	// city. state로 되어있는 문자열에서 각각 City, State의 객체의 이름으로 City, State 객체를 만들어서 설정해줌.
	public void split(String str, String regex) {
		String cityname = "";
		String statename = "";
		if (str.contains(regex)) {
			cityname = str.substring(0, str.indexOf(regex));
			statename = str.substring(str.indexOf(regex) + regex.length());
		}

		setCity(new City(cityname));
		setState(new State(statename));
	}

}
