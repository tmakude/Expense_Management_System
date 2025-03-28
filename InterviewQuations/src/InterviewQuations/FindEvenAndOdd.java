package InterviewQuations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindEvenAndOdd {

	public static void main(String[] args) {
    List<Integer> listOfInteger = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
		
	Map<String , List<Integer>>	 map=listOfInteger.stream().collect(Collectors.groupingBy(n->n%2==0 ? "Even" : "Odd" ));
	
	System.out.println(map);

		

	}

}
