package food869.q19;

import java.util.HashMap;

public class PersonInfoSetter {
	private HashMap<String, Integer> title_map;
	private String[] row;

	PersonInfoSetter(HashMap<String, Integer> title_map, String[] row) {
		this.title_map = title_map;
		this.row = row;
	}

	public String setPersonLastname() {
		return row[title_map.get(PersonE.last_name.name())];
	}

	public String setPersonFirstname() {
		return row[title_map.get(PersonE.first_name.name())];
	}

	public String setPersonEmail() {
		return row[title_map.get(PersonE.email.name())];
	}

	public String setPersonGender() {
		return row[title_map.get(PersonE.gender.name())];
	}

	public String setPersonBirthDay() {
		return row[title_map.get(PersonE.birthday.name())];
	}

	public String setPersonProfession() {
		return row[title_map.get(PersonE.profession.name())];
	}

	public String setPersonLocation() {
		return row[title_map.get(PersonE.location.name())];
	}

	public String setPersonStatus() {
		return row[title_map.get(PersonE.status.name())];
	}

	public String setPersonInterests() {
		return row[title_map.get(PersonE.interests.name())];
	}

	public String setPersonSeeking() {
		return row[title_map.get(PersonE.seeking.name())];
	}
}
