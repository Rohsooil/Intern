package food869.q12;

public class Test {
	public static void main(String[] args) {
		String citystate = "Seattle, WA";
		String citystate2 = "Natchez, MS";
		String citystate3 = "Las Vegas, NV";
		String citystate4 = "Palo Alto, CA";
		String citystate5 = "NYC, NY";

		CityState stringSplit = new CityState();

		stringSplit.split(citystate, ", ");
		System.out.println("City : " + stringSplit.getCity() + "\nState : " + stringSplit.getState() + "\n");

		stringSplit.split(citystate2, ", ");
		System.out.println("City : " + stringSplit.getCity() + "\nState : " + stringSplit.getState() + "\n");

		stringSplit.split(citystate3, ", ");
		System.out.println("City : " + stringSplit.getCity() + "\nState : " + stringSplit.getState() + "\n");

		stringSplit.split(citystate4, ", ");
		System.out.println("City : " + stringSplit.getCity() + "\nState : " + stringSplit.getState() + "\n");

		stringSplit.split(citystate5, ", ");
		System.out.println("City : " + stringSplit.getCity() + "\nState : " + stringSplit.getState() + "\n");
	}
}
