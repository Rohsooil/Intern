package food869.q13;

public class Test {
	public static void main(String[] args) {
		String sentence = "It's a nice\r\n" + 
				"\r\n" + 
				"day, isn't it, Mr. Mxyzzptllxy?\r\n" + 
				"\r\n" + 
				"I think we should\r\n" + 
				"\r\n" + 
				"go for a walk.";

		Format format = new Format();
		System.out.println(format.formatSentence(sentence, 72));
	}
}
