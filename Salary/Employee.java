package Salary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {

	public static void main(String[] args) {
	
        List<EmployeeSal> emp = new ArrayList<EmployeeSal>();
        
        emp.add( new EmployeeSal("Site",1500) );
        emp.add( new EmployeeSal("Rama",1500) );
        emp.add( new EmployeeSal("Rohan",4500) );
        
       
        List < EmployeeSal > Sorted = emp.stream()
	            .sorted((o1, o2) -> (int)(o1.getSalary() - o2.getSalary())).collect(Collectors.toList());
	        System.out.println(Sorted);
	}
	      /*  for (int i =0 ;i<Sorted.size();i++) {
	        	for(int j=i+1;j<Sorted.size();j++) {
	        		if(Sorted.get(i).getSalary().equals(get(j).getSalary())) {
	        			long value =Sorted.get(i).getSalary()+get(j).getSalary();
	        			Sorted.get(i).setSalary(value);
	        			Sorted.remove(j);
	        		}
	        	}
	        }
	        System.out.println(Sorted.size());
	        System.out.println(Sorted);*/
         

	private static EmployeeSal get(int j) {
		// TODO Auto-generated method stub
		return null;
	} 

	}


