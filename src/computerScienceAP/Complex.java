package computerScienceAP;

public class Complex implements Number {
	private double real;
	// real - stores the real portion of the complex number
	private double imaginary;
	// imaginary - stores the imaginary portion of the complex number
	
	// Constructor - builds the Complex object
	public Complex(double real, double imag) {
		this.real = real;
		this.imaginary = imag;
	}
	// getReal - returns the real value
	// @return - the real value
	public double getReal() {
		return real;
	}
	//getImag - returns the imaginary value
	// @return - the imaginary value
	public double getImag() {
		return imaginary;
	}
	// checkObject - checks to make sure the object passed in is a complex object
	// @param - num - the object to be checked
	private void checkObject(Number num) {
		if(!(num instanceof Complex)) {
			throw new IllegalArgumentException("The object must be a complex number to perform an operation on it!");
		}
	}
	// add - adds the complex object passed in to the current complex object and returns the result
	// @param - the complex object to be added
	// @return - the result of the addition
	@Override
	public Number add(Number num) {
		checkObject(num);
		return new Complex(real + ((Complex) num).getReal(), imaginary + ((Complex) num).getImag());
	}
	// subtract - subtracts the complex object passed in to the current complex object and returns the result
	// @param - the complex object to be subtracted
	// @return - the result of the subtraction
	@Override
	public Number subtract(Number num) {
		checkObject(num);
		return new Complex(real - ((Complex) num).getReal(), imaginary - ((Complex) num).getImag());
	}
	// multiply - multiplies the complex object passed in to the current complex object and returns the result
	// @param - the complex object to be multiplied
	// @return - the result of the multiplication
	@Override
	public Number multiply(Number num) {
		checkObject(num);
		double multReal = real * ((Complex) num).getReal() - imaginary * ((Complex) num).getImag();
		double multImag = real * ((Complex) num).getImag() + imaginary * ((Complex) num).getReal();
		return new Complex(multReal, multImag);
	}
	// divide - divides the complex object passed in to the current complex object and returns the result
	// @param - the complex object to be divided
	// @return - the result of the division
	@Override
	public Number divide(Number num) {
		checkObject(num);
		double denom = ((Complex) num).getReal() * ((Complex) num).getReal() + ((Complex) num).getImag() * ((Complex) num).getImag();
		if(denom == 0) {
			throw new ArithmeticException("You cannot divide by 0!");
		}
		Number divideComp = multiply(new Complex(((Complex) num).getReal(), ((Complex) num).getImag() * -1));
		return new Complex(((Complex) divideComp).getReal()/denom, ((Complex) divideComp).getImag()/denom);
	}
	// toString - formats and outputs the data in the complex object
	// @return - the data in the complex object
	@Override
	public String toString() {
		if(real == 0 && imaginary == 0)
			return "0";
		if(real == 0)
			return String.format("%.2f", imaginary) + "i";
		if(imaginary == 0)
			return String.format("%.2f", real);
		if(imaginary < 0)
			return String.format("%.2f", real) + " - " + String.format("%.2f", (imaginary*-1)) + "i";
		return String.format("%.2f", real) + " + " + String.format("%.2f", imaginary) + "i";
	}

}