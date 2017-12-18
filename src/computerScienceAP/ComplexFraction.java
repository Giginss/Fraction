package computerScienceAP;

public class ComplexFraction implements Number {
	private Fraction real;
	private Fraction imaginary;
	
	public ComplexFraction(Fraction real, Fraction imag) {
		this.real = real;
		this.imaginary = imag;
	}
	public Fraction getReal() {
		return real;
	}
	public Fraction getImag() {
		return imaginary;
	}
	@Override
	public Number add(Number num) {
		Fraction addReal = (Fraction) real.add(((ComplexFraction) num).getReal());
		Fraction addImag = (Fraction) imaginary.add(((ComplexFraction) num).getImag());
		return new ComplexFraction(addReal, addImag);
	}

	@Override
	public Number subtract(Number num) {
		Fraction subReal = (Fraction) real.subtract(((ComplexFraction) num).getReal());
		Fraction subImag = (Fraction) imaginary.subtract(((ComplexFraction) num).getImag());
		return new ComplexFraction(subReal, subImag);
	}

	@Override
	public Number multiply(Number num) {
		Fraction multReal = (Fraction) real.multiply(((ComplexFraction) num).getReal()).subtract(imaginary.multiply(((ComplexFraction) num).getImag()));
		Fraction multImag = (Fraction) real.multiply(((ComplexFraction) num).getImag()).add(imaginary.multiply(((ComplexFraction) num).getReal()));
		return new ComplexFraction(multReal, multImag);
	}

	@Override
	public Number divide(Number num) {
		Fraction denom = (Fraction) ((ComplexFraction) num).getReal().add(((ComplexFraction) num).getImag());
		if(denom.getDenominator() == 0) {
			throw new ArithmeticException("You cannot divide by 0!");
		}
		Number divideCompNum = multiply(new ComplexFraction(((ComplexFraction) num).getReal(), (Fraction) ((ComplexFraction) num).getImag().multiply(new Fraction(-1, 1))));
		return new ComplexFraction((Fraction) ((ComplexFraction) divideCompNum).getReal().divide(denom), (Fraction) ((ComplexFraction) divideCompNum).getImag().divide(denom));
	}
	public String toString() {
		Fraction realOutput = real.reduceFraction();
		Fraction imagOutput = imaginary.reduceFraction();
		if(imagOutput.getNumerator() == 0 && realOutput.getNumerator() == 0) {
			return "0";
		} else if(realOutput.getNumerator() == 0) {
			return imagOutput.getNumerator() + "i/" + imagOutput.getDenominator();
		} else if(imagOutput.getNumerator() == 0) {
			return realOutput.toString();
		} else if(imagOutput.getNumerator() < 0) {
			return realOutput.toString() + " - " + imagOutput.getNumerator() * -1 + "i/" + imagOutput.getDenominator();
		} else if(imagOutput.getDenominator() < 0) {
			return realOutput.toString() + " - " + imagOutput.getNumerator() + "i/" + imagOutput.getDenominator() * -1;
		}
		return realOutput.toString() + " + " + imagOutput.getNumerator() + "i/" + imagOutput.getDenominator();
	}

}