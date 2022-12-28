package Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
public class Supply {

	public static  void main(String arg[]) {
		
		ArrayList <String> name =new ArrayList<String>();
		name.add("Gibi");
		name.add("John");
		
		
		Supplier <List <String>> supplier =() -> new ArrayList<>(name) ;
		System.out.println(supplier.get());
	}
}
