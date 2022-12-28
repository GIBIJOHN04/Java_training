package Employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeTest {
	
	public static void main (String args[]) {
		
		ApplicationContext contex = new ClassPathXmlApplicationContext("applicationContext.xml");
		Details d = contex.getBean("emp",Details.class);
		d.display();
	}

}
