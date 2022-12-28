package Odd;

import java.util.Arrays;

public class Reduce {
	public static void sum() {
		int[] arr = {1,2,3,4,5};
		int total;
		total=Arrays.stream(arr).reduce(0, Integer ::SUM);
		System.out.println(total);
		
	}
	 
}
