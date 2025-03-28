package InterviewQuations;

public class CountTheNumbersInTheString {

	public static void main(String[] args) {


        String sentence = "Java is a powerful programming language";
        System.out.println("Word Count: " + countWords(sentence)); 

	}

	private static int countWords(String sentence) {
		
		if(sentence == null || sentence.isEmpty()) {
			
			return 0;
		}
		
		return sentence.split(" ").length;
	}

}
