package computerScienceAP;

public class Complex implements Number {
	private double real;
	private double imaginary;
	private double denominator;
	
	public Complex(double real, double imag) {
		this.real = real;
		this.imaginary = imag;
		denominator = 1;
	}
	public Complex(double real, double imag, double denom) {
		this.real = real;
		this.imaginary = imag;
		this.denominator = denom;
	}
	public double getReal() {
		return real;
	}
	public double getImag() {
		return imaginary;
	}
	@Override
	public Number add(Number num) {
		return new Complex(real + ((Complex) num).getReal(), imaginary + ((Complex) num).getImag());
	}

	@Override
	public Number subtract(Number num) {
		return new Complex(real - ((Complex) num).getReal(), imaginary - ((Complex) num).getImag());
	}

	@Override
	public Number multiply(Number num) {
		return new Complex(real * ((Complex) num).getReal() - imaginary * ((Complex) num).getImag(), real * ((Complex) num).getImag() + imaginary * ((Complex) num).getReal());
	}

	@Override
	public Number divide(Number num) {
		double denom = ((Complex) num).getReal() + ((Complex) num).getImag();
		if(denom == 0) {
			throw new ArithmeticException("You cannot divide by 0!");
		}
		Number divideComp = multiply(new Complex(((Complex) num).getReal(), ((Complex) num).getImag() * -1));
		return new Complex(((Complex) divideComp).getReal(), ((Complex) divideComp).getImag(), denom);
	}
	@Override
	public String toString() {
		if(denominator == 1) {
		if(real == 0 && imaginary == 0)
			return "0";
		if(real == 0)
			return imaginary + "i";
		if(imaginary == 0)
			return "" + real;
		if(imaginary < 0)
			return real + " - " + (imaginary*-1) + "i";
		return real + " + " + imaginary + "i";
		} else {
			if(real == 0 && imaginary == 0)
				return "0";
			if(real == 0)
				return imaginary + "i/" + denominator;
			if(imaginary == 0)
				return "" + real + "/" + denominator;
			if(imaginary < 0)
				return real + "/" + denominator + " - " + (imaginary*-1) + "i/" + denominator;
			return real + "/" + denominator + " + " + imaginary + "i/" + denominator;
		}
	}

}