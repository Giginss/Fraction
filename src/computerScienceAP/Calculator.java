package computerScienceAP;

public class Calculator {
	private Number[] numberArray;
	private int numberArraySize;
	
	public Calculator() {
		numberArray = new Number[2];
		numberArraySize = 0;
	}
	public void reset() {
		numberArraySize = 0;
	}
	public void input(Number num) {
		if(numberArraySize == numberArray.length)
			throw new ArrayIndexOutOfBoundsException("Perform an operation now.");
		numberArray[numberArraySize] = num;
		numberArraySize++;
	}
	public String multiply() {
		try {
			return numberArray[0].multiply(numberArray[1]).toString();
		} catch(NullPointerException e) {
			return "You have not inputted 2 fractions or 2 complex numbers!";
		}
	}
	public String subtract() {
		try {
			return numberArray[0].subtract(numberArray[1]).toString();
		} catch(NullPointerException e) {
			return "You have not inputted 2 fractions or 2 complex numbers!";
		}
	}
	public String subtractOther() {
		return numberArray[1].subtract(numberArray[0]).toString();
	}
	public String add() {
		try {
			return numberArray[0].add(numberArray[1]).toString();
		} catch(NullPointerException e) {
			return "You have not inputted 2 fractions or 2 complex numbers!";
		}
	}
	public String divide() {
		try {
			return numberArray[0].divide(numberArray[1]).toString();
		} catch(NullPointerException e) {
			return "You have not inputted 2 fractions or 2 complex numbers!";
		}
	}
	public String divideOther() {
		return numberArray[1].divide(numberArray[0]).toString();
	}
}