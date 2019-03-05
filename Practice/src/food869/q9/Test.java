package food869.q9;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<String> arraylist = new ArrayList<String>();
		MyArrayList<String> myarraylist = new MyArrayList<String>();
		
		arraylist.add("22");			//22
		arraylist.add("11");			//22 11
		arraylist.add("22");			//22 11 22
		arraylist.add(1, "333");		//22 333 11 22
		arraylist.add("44");			//22 333 11 22 44
		System.out.println(arraylist);	
		
		myarraylist.add("22");			//22
		myarraylist.add("11");			//22 11
		myarraylist.add("22");			//22 11 22
		myarraylist.add(1, "333");		//22 333 11 22
		myarraylist.add("44");			//22 333 11 22 44
		System.out.println(myarraylist);



		arraylist.remove(1);		//22 11 22 44
		myarraylist.remove(1);		//22 11 22 44

		System.out.println(myarraylist.remove("222"));	//false
		System.out.println(arraylist.remove("222"));	//false
		
		System.out.println(arraylist);
		System.out.println(myarraylist);
		
		System.out.println(arraylist.indexOf("22"));		//0
		System.out.println(myarraylist.indexOf("22"));		//0
		
		System.out.println(arraylist.get(3));		//44
		System.out.println(myarraylist.get(3));		//44

		System.out.println(arraylist.lastIndexOf("22"));	//2
		System.out.println(myarraylist.lastIndexOf("22"));	//2
		
		System.out.println(arraylist.contains("33"));
		System.out.println(myarraylist.contains("33"));
		
	}
}
