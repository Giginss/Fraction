package computerScienceAP;

public class Fraction implements Number {
	private int numerator;
	private int denominator;
	
	public Fraction(int num, int denom) {
		checkInput(num, denom);
		numerator = num;
		denominator = denom;
	}
	public static void checkInput(int num, int denom) {
		if(denom == 0) {
			throw new IllegalArgumentException("The denominator cannot be 0!");
		}
	}
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	private int findSmaller() {
		if (Math.abs(numerator) > Math.abs(denominator))
			return Math.abs(denominator);
		return Math.abs(numerator);
	}
	private int findGCF() {
		for (int i = findSmaller(); i > 1; i--) {
			if (numerator % i == 0 && denominator % i == 0) {
				return i;
			}
		}
		return 1;
	}
	public Fraction reduceFraction() {
		int GCF = findGCF();
		return new Fraction(numerator/GCF, denominator/GCF);
	}
	public Fraction getReciprocal() {
		if(numerator == 0) {
			throw new ArithmeticException("You cannot divide by 0!");
		}
		return new Fraction(denominator, numerator);
	}
	@Override
	public Number add(Number num) {
		int commonDenom = denominator * ((Fraction) num).getDenominator();
		int numer = numerator * (commonDenom/denominator) + ((Fraction) num).getNumerator() * (((Fraction) num).getDenominator()/commonDenom);
		Fraction addFrac = new Fraction(numer, commonDenom);
		return addFrac.reduceFraction();
	}

	@Override
	public Number subtract(Number num) {
		int commonDenom = denominator * ((Fraction) num).getDenominator();
		int numer = numerator * (commonDenom/denominator) - ((Fraction) num).getNumerator() * (((Fraction) num).getDenominator()/commonDenom);
		Fraction addFrac = new Fraction(numer, commonDenom);
		return addFrac.reduceFraction();
	}

	@Override
	public Number multiply(Number num) {
		int numer = numerator * ((Fraction) num).getNumerator();
		int denom = denominator * ((Fraction) num).getDenominator();
		Fraction multFrac = new Fraction(numer, denom);
		return multFrac.reduceFraction();
	}

	@Override
	public Number divide(Number num) {
		Fraction num2 = ((Fraction) num).getReciprocal();
		int numer = numerator * num2.getNumerator();
		int denom = denominator * num2.getDenominator();
		Fraction divFrac = new Fraction(numer, denom);
		return divFrac.reduceFraction();
	}
	@Override
	public String toString() {
		if(numerator == 0) {
			return "0";
		}
		if(denominator == 1) {
			return "" + numerator;
		}
		return numerator + "/" + denominator;
	}
}
