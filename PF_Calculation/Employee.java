package PF_Calculation;

import java.util.Scanner;

public class Employee {

	int empid;
    String name;
    String loc;
    float salary,PF;
    Employee()
    {
        empid=0;
        name = "";
        salary = 0.0f;
        PF = 0.0f;
        
    }
    void unit()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Employee number=");
        empid = sc.nextInt();
        System.out.print("Enter name=");
        name = sc.next();
        System.out.print("Enter location=");
        loc = sc.next();
        System.out.print("Enter salary=");
        salary = sc.nextFloat();
    }
    void calc()
    {
       if (salary >= 50000){
           salary = (float) (salary * 0.12);
       }
       else if (salary >=80000){
           salary =(float) (salary * 0.18);
       }
       else {
           salary =(float) (salary * 0.15);
       }
        
    }
    void display()
    {
        
        System.out.println("Employee number="+empid);
        System.out.println("Name="+name);
          System.out.println("Location="+loc);
        System.out.println("PF="+salary);        
    
    }
    public static void main(String args[])
    {
        Employee e = new Employee();
        e.unit();
        e.calc();
        e.display();
    }
}
