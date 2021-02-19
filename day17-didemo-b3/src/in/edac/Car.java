package in.edac;

public class Car {
	private int id;
	private String modelNumber;
	private String color;
	
	// @AutoWired
	private Engine engine;
	/*private Suspension suspension;
	private Cooling cooling;
	private Streing stering;
	private Navigation navigation;*/
	
	
	public Car(int id, String modelNumber, String color, Engine engine) {
		super();
		this.id = id;
		this.modelNumber = modelNumber;
		this.color = color;
		this.engine = engine;
	}
	
}
