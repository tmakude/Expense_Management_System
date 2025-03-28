package InterviewQuations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SecondLargestNumberInTheArray {

	public static void main(String[] args) {



		int[] arr = {1, 2, 3, 4, 2, 5, 6, 3, 7};	
		findDuplicateNumbers(arr);



	}
	
	public static void findDuplicateNumbers(int[] arr) {
		

		Set<Integer> numbers = new HashSet<>();
		
		Set<Integer> duplicates = new HashSet<>();
		
		
		for(int num : arr) {

			if(!numbers.add(num)) {
				
				duplicates.add(num);
				
			}


			
			
			
		}
		
		System.out.println("Duplicates Numbers : "+ duplicates);
		
	}



}
