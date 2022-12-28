package Employee;

public class Details {

	private String name ;
	private int id ;
	private String location ;
 
	public Details(String name, int id, String location) {
		
		this.name = name;
		this.id = id;
		this.location = location;
	}


	public void display () {
		
		System.out.println("Employee Name =" +name +   "Employee id is  :"  + id  +  "lOCATION of employee : " + location );;
        
            
    
	}
	
}
