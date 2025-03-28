package InterviewQuations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromArray {

	public static void main(String[] args) {


		List<String> names = new ArrayList<>(Arrays.asList("Java", "Python", "Java", "C++", "Python"));
        
		List<String> newName  =names.stream().distinct().collect(Collectors.toList());
		
		System.out.println(newName);

	}

}
