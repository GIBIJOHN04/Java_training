
public class Vechile {
	
	String name ;
	public Void Wheel() {
		System.out.println("No of whell");
		return null;
	}
}
	class Car extends Vechile {
		
		Void display() {
			System.out.println("Model is " +name );
			return null;
		
	}
		class Main {
			public static void main ( String args[]) {
				Car c = new  Car();
				c.name ="ALTO";
				c.display();
				c.Wheel();
			}
					
				
		}
	
	}




