package InterviewQuations;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainClassForImmutableClass {

	public static void main(String[] args) {
		



		
		List<Integer> list = List.of(10,20,50,90,5,25,75,7);
		
		List<Integer> list1= list.stream().sorted((a,b)-> b-a).collect(Collectors.toList());
		
		list1.forEach(System.out::println);
		
		

	}

}
