package in.edac;

public class Main {
	
	// @Autowired
	private Engine e;
	
	public static void main(String[] args) {
		
	}
	
	public void testEngine() {
		// COMPLEX OBJECT :: DISEL/PETROL/ELECTRIC/BATTERY/SOLAR
		// Engine e = new Engine("SOLAR");
				
		Car car = new Car(1, "AAA", "BLACK", e);
		System.out.println(car);
	}
	
}
