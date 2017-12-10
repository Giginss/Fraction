package computerScienceAP;

public class Complex implements Number {
	private double real;
	private double imaginary;
	private int denominator;
	
	public Complex(double real, double imag) {
		this.real = real;
		this.imaginary = imag;
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		if(real == 0 && imaginary == 0)
			return "0";
		if(real == 0)
			return imaginary + "i";
		if(imaginary == 0)
			return "" + real;
		if(imaginary < 0)
			return real + "-" + (imaginary*-1) + "i";
		return real + "+" + imaginary + "i";
	}

}