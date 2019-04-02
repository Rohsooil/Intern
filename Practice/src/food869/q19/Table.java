package food869.q19;

import java.util.HashMap;

public class Table {
	private Person[] persons;
	private HashMap<String, Integer> title_map;

	public Table(String[] title, String[][] contents) {
		persons = new Person[contents.length];
		title_map = new HashMap<>();

		for (int i = 0; i < title.length; i++) {
			title_map.put(title[i], i);
		}

		for (int i = 0; i < persons.length; i++) {
			persons[i] = new Person(title_map, contents[i]);
		}

	}

	public Person getPerson(int index) {
		if (index >= persons.length) {
			return null;
		} else {
			return persons[index];
		}
	}

	@Override
	public String toString() {
		String table = "";
		for (Person p : persons) {
			table = table + p + "\n";
		}
		return table;
	}
}
