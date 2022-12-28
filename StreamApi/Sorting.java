package StreamApi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Sorting {

	 public static void main(String[] args) {

	        
	        List < Employee > employees = new ArrayList < Employee > ();
	        employees.add(new Employee(10, "Ramesh", "Chennai", 400000));
	        employees.add(new Employee(20, "John", "TVM", 350000));
	        employees.add(new Employee(30, "Tom", "TVM", 450000));
	        employees.add(new Employee(40, "Pramod", "Pun", 500000));

	        List < Employee > Sorted = employees.stream()
	            .sorted((o1, o2) -> (int)(o1.getSalary() - o2.getSalary())).collect(Collectors.toList());
	        System.out.println(Sorted);
	     
}
}
