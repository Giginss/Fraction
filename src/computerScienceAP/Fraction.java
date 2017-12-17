package computerScienceAP;

public class Fraction implements Number {
	private int numerator;
	// numerator - stores the numerator value
	private int denominator;
	// denominator - stores the denominator value
	
	// Constructor - builds the fraction object
	public Fraction(int num, int denom) {
		checkInput(num, denom);
		numerator = num;
		denominator = denom;
	}
	// static checkInput - throws an exception if the denominator is 0
	// @param - the data to be checked
	public static void checkInput(int num, int denom) {
		if(denom == 0) {
			throw new IllegalArgumentException("The denominator cannot be 0!");
		}
	}
	// getNumerator - returns the numerator
	// @return - the numerator
	public int getNumerator() {
		return numerator;
	}
	// getDenominator - returns the denominator
	// @return - the denominator
	public int getDenominator() {
		return denominator;
	}
	// findSmaller - finds the smaller absolute value between the numerator and the denominator
	// @return - the smaller absolute value
	private int findSmaller() {
		if (Math.abs(numerator) > Math.abs(denominator))
			return Math.abs(denominator);
		return Math.abs(numerator);
	}
	// findGCF - finds the greatest common factor of the numerator and denominator
	// @return - the GCF - if there isn't a GCF, then it returns 1
	private int findGCF() {
		for (int i = findSmaller(); i > 1; i--) {
			if (numerator % i == 0 && denominator % i == 0) {
				return i;
			}
		}
		return 1;
	}
	// reduceFraction - reduces the fraction to its simplest form
	// @return - the reduced fraction
	public Fraction reduceFraction() {
		int GCF = findGCF();
		return new Fraction(numerator/GCF, denominator/GCF);
	}
	// getReciprocal - returns the reciprocal of the fraction
	// @return - the inverted fraction
	public Fraction getReciprocal() {
		if(numerator == 0) {
			throw new ArithmeticException("You cannot divide by 0!");
		}
		return new Fraction(denominator, numerator);
	}
	// checkObject - checks to make sure the object passed in is a fraction object
	// @param - num - the object to be checked
	private void checkObject(Number num) {
		if(!(num instanceof Fraction)) {
			throw new IllegalArgumentException("The object must be a fraction to perform an operation on it!");
		}
	}
	// add - adds the fraction object passed in to the current fraction object and returns the result
	// @param - the fraction object to be added
	// @return - the result of the addition
	@Override
	public Number add(Number num) {
		checkObject(num);
		int commonDenom = denominator * ((Fraction) num).getDenominator();
		int numer = numerator * ((Fraction) num).getDenominator() + ((Fraction) num).getNumerator() * denominator;
		return new Fraction(numer, commonDenom);
	}
	// subtract - subtracts the fraction object passed in to the current fraction object and returns the result
	// @param - the fraction object to be subtracted
	// @return - the result of the subtraction
	@Override
	public Number subtract(Number num) {
		checkObject(num);
		int commonDenom = denominator * ((Fraction) num).getDenominator();
		int numer = numerator * ((Fraction) num).getDenominator() - ((Fraction) num).getNumerator() * denominator;
		return new Fraction(numer, commonDenom);
	}
	// multiply - multiplies the fraction object passed in to the current fraction object and returns the result
	// @param - the fraction object to be multiplied
	// @return - the result of the multiply
	@Override
	public Number multiply(Number num) {
		checkObject(num);
		int numer = numerator * ((Fraction) num).getNumerator();
		int denom = denominator * ((Fraction) num).getDenominator();
		return new Fraction(numer, denom);
	}
	// divide - divides the fraction object passed in to the current fraction object and returns the result
	// @param - the fraction object to be divided
	// @return - the result of the division
	@Override
	public Number divide(Number num) {
		checkObject(num);
		Fraction num2 = ((Fraction) num).getReciprocal();
		int numer = numerator * num2.getNumerator();
		int denom = denominator * num2.getDenominator();
		return new Fraction(numer, denom);
	}
	// toString - formats and outputs the data in the complex object
	// @return - the data in the complex object
	@Override
	public String toString() {
		Fraction fraction = reduceFraction();
		if(fraction.numerator == 0) {
			return "0";
		}
		if(fraction.denominator == 1) {
			return "" + fraction.numerator;
		}
		return fraction.numerator + "/" + fraction.denominator;
	}
}