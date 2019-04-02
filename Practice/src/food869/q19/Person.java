package food869.q19;

import java.util.HashMap;

public class Person {
	private String last_name;
	private String first_name;
	private String email;
	private String gender;
	private String birthDay;
	private String profession;
	private String location;
	private String status;
	private String interests;
	private String seeking;
	private final String TAB = "\t";

	public Person(HashMap<String, Integer> title_map, String[] row) {
		PersonInfoSetter personInfoSetter = new PersonInfoSetter(title_map, row);

		last_name = personInfoSetter.setPersonLastname();
		first_name = personInfoSetter.setPersonFirstname();
		email = personInfoSetter.setPersonEmail();
		gender = personInfoSetter.setPersonGender();
		birthDay = personInfoSetter.setPersonBirthDay();
		profession = personInfoSetter.setPersonProfession();
		location = personInfoSetter.setPersonLocation();
		status = personInfoSetter.setPersonStatus();
		interests = personInfoSetter.setPersonInterests();
		seeking = personInfoSetter.setPersonSeeking();
	}

	@Override
	public String toString() {
		String row = last_name + TAB + first_name + TAB + email + TAB + gender + TAB + birthDay + TAB + profession + TAB
				+ location + TAB + status + TAB + interests + TAB + seeking;
		return row;
	}

	/*
	 * Getter
	 */

	public String getLast_name() {
		return last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getProfession() {
		return profession;
	}

	public String getLocation() {
		return location;
	}

	public String getStatus() {
		return status;
	}

	public String getInterests() {
		return interests;
	}

	public String getSeeking() {
		return seeking;
	}

}
