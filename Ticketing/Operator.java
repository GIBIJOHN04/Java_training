package Ticketing;

public class Operator<T> {
	Operator<Integer> addOperation = new Operator<Integer>() {
		 public int a=5;
  	  @Override
  	 
  	  public Integer process(Integer a, Integer amount) {
  	    return a * amount;
  	  }
  	};

	public Integer process(Integer a, Integer b) {
		// TODO Auto-generated method stub
		return null;
	};
}
