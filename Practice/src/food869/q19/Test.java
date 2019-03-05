package food869.q19;

public class Test {
	public static void main(String[] args) {
		String[] title = { "last_name", "first_name", "email", "gender", "birthday", "profession", "location", "status",
				"interests", "seeking" };
		String[][] contents = { { "Anderson", "Jillian", "jill_anderson@breakneckpizza.com", "F", "1980-09-05",
				"TechnicalWriter", "PaloAlto,CA", "single", "kayaking,reptiles", "relationship,friends" }

				, { "Kenton", "Leo", "lkenton@starbuzzcoffee.com", "M", "1974-01-10", "Manager", "SanFrancisco,CA",
						"divorced", "women", "womentodate" }

				, { "McGavin", "Darrin", "captainlove@headfirsttheater.com", "M", "1966-01-23", "CruiseShipCaptain",
						"SanDiego,CA", "single", "sailing,fishing,yachting", "womenforcasualrelationships" }

				, { "Franklin", "Joe", "joe_franklin@leapinlimos.com", "M", "1977-04-28", "SoftwareSales", "Dallas,TX",
						"married", "fishing,drinking", "newjob" }

				, { "Hamilton", "Jamie", "dontbother@starbuzzcoffee.com", "F", "1964-09-10", "SystemAdministrator",
						"Princeton,NJ", "married", "RPG", "nothing" }

				, { "Chevrolet", "Maurice", "bookman4u@objectville.net", "M", "1962-07-01", "BookshopOwner",
						"MountainView,CA", "married", "collectingbooks,scubadiving", "friends" }

				, { "Kroger", "Renee", "poorrenee@mightygumball.net", "F", "1976-12-03", "Unemployed",
						"SanFrancisco,CA", "divorced", "cooking", "employment" }

				, { "Mendoza", "Angelina", "angelina@starbuzzcoffee.com", "F", "1979-08-19", "UNIXSysadmin",
						"SanFrancisco,CA", "married", "acting,dancing", "newjob" }

				, { "Murphy", "Donald", "padraic@tikibeanlounge.com", "M", "1967-01-23", "ComputerProgrammer",
						"NewYorkCity,NY", "committedrelationsh", "RPG,anime", "friends" }

				, { "Spatner", "John", "jpoet@objectville.net", "M", "1963-04-18", "Salesman", "Woodstock,NY",
						"married", "poetry,screenwriting", "nothing" } };
		Table table = new Table(title, contents);
		System.out.println(table);
	}
}
