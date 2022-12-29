package Arraysorting;

import java.util.stream.IntStream;

public class sort {
       
	public static void main(String[] args) {
		
		int[] input = { 8,7,5,2,3,6 };
		int target = 10;
		IntStream.range(0,  input.length)
	    .forEach(i -> IntStream.range(0,  input.length)
	        .filter(j -> i != j && input[i] + input[j] == target)
	        .forEach(j -> addPairs(input[i], input[j]))
	);

	}

	private static Object addPairs(int i, int j) {
		System.out.println(i);
		return null;
	}

}
