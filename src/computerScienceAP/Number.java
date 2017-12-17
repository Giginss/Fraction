package computerScienceAP;

public interface Number {
	public Number add(Number num);
	// add - used as a method for a subclass of number to implement its add method
	// @param - a subclass of number
	// @return - a subclass of number
	public Number subtract(Number num);
	// subtract - used as a method for a subclass of number to implement its subtract method
	// @param - a subclass of number
	// @return - a subclass of number
	public Number multiply(Number num);
	// multiply - used as a method for a subclass of number to implement its multiply method
	// @param - a subclass of number
	// @return - a subclass of number
	public Number divide(Number num);
	// divide - used as a method for a subclass of number to implement its divide method
	// @param - a subclass of number
	// @return - a subclass of number
}