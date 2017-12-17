package computerScienceAP;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import BreezySwing.DoubleField;
import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

@SuppressWarnings({ "serial", "unused" })
public class CalculatorGUI extends GBFrame {
	private JLabel numeratorLabel = addLabel("Numerator", 1, 1, 1, 1);
	private JLabel denominatorLabel = addLabel("Denominator", 1, 2, 1, 1);
	private IntegerField numeratorField1 = addIntegerField(0, 2, 1, 1, 1);
	private IntegerField denominatorField1 = addIntegerField(1, 2, 2, 1, 1);
	private IntegerField numeratorField2 = addIntegerField(0, 3, 1, 1, 1);
	private IntegerField denominatorField2 = addIntegerField(1, 3, 2, 1, 1);
	private JButton inputFraction = addButton("Input Fractions", 3, 4, 1, 1);
	private JLabel realLabel = addLabel("Real", 4, 1, 1, 1);
	private JLabel imaginaryLabel = addLabel("Imaginary", 4, 2, 1, 1);
	private DoubleField realField1 = addDoubleField(0, 5, 1, 1, 1);
	private DoubleField imaginaryField1 = addDoubleField(0, 5, 2, 1, 1);
	private DoubleField realField2 = addDoubleField(0, 6, 1, 1, 1);
	private DoubleField imaginaryField2 = addDoubleField(0, 6, 2, 1, 1);
	private JLabel i1Label = addLabel("i              ", 5, 3, 1, 1);
	private JLabel i2Label = addLabel("i              ", 6, 3, 1, 1);
	private JButton inputComplex = addButton("Input Complex Numbers", 6, 4, 1, 1);
	private JButton add = addButton("Add", 7, 1, 1, 1);
	private JButton subtract = addButton("Subtract 1st from 2nd", 7, 2, 1, 1);
	private JButton multiply = addButton("Multiply", 7, 3, 1, 1);
	private JButton divide = addButton("Divide 1st from 2nd", 7, 4, 1, 1);
	private JButton clear = addButton("Clear", 7, 5, 1, 1);
	private JButton exit = addButton("Exit", 8, 5, 1, 1);
	private JButton subtractOther = addButton("Subtract 2nd from 1st", 8, 2, 1, 1);
	private JButton divideOther = addButton("Divide 2nd from 1st", 8, 4, 1, 1);
	private JTextArea displayArea = addTextArea("", 9, 1, 8, 1);
	private JLabel complexFraction1Label = addLabel("Real:", 1, 6, 1, 1);
	private JLabel complexFraction2Label = addLabel("Imaginary:", 1, 7, 1, 1);
	private JLabel i3Label = addLabel("i        ", 2, 8, 1, 1);
	private JLabel i4Label = addLabel("i        ", 5, 8, 1, 1);
	private IntegerField realNumeratorField1 = addIntegerField(0, 2, 6, 1, 1);
	private IntegerField realNumeratorField2 = addIntegerField(0, 5, 6, 1, 1);
	private IntegerField realDenominatorField1 = addIntegerField(1, 3, 6, 1, 1);
	private IntegerField realDenominatorField2 = addIntegerField(1, 6, 6, 1, 1);;
	private IntegerField imaginaryNumeratorField1 = addIntegerField(0, 2, 7, 1, 1);
	private IntegerField imaginaryNumeratorField2 = addIntegerField(0, 5, 7, 1, 1);
	private IntegerField imaginaryDenominatorField1 = addIntegerField(1, 3, 7, 1, 1);
	private IntegerField imaginaryDenominatorField2 = addIntegerField(1, 6, 7, 1, 1);
	private JButton inputComplexFraction = addButton("Input Complex Fractions", 6, 8, 1, 1);
	private final String NOT_ENOUGH_INPUT = "You have not entered 2 fractions or 2 complexes, please press clear and try again.";
	private Number num1;
	// num1 - place to hold the first fraction or complex
	private Number num2;
	// num2 - place to hold the second fraction or complex

	// Constructor - builds the CalculatorGUI
	public CalculatorGUI() {
		setVisible(true);
		setSize(1000, 700);
		setTitle("Fraction and Complex Calculator");
		numeratorField1.setText("");
		numeratorField2.setText("");
		realField1.setText("");
		imaginaryField1.setText("");
		realField2.setText("");
		imaginaryField2.setText("");
		displayArea.setEditable(false);
		massEnableDisable(false);
	}
	// buttonClicked - executes the proper code when a button is pressed
	// @param - button - the button object that was pressed
	public void buttonClicked(JButton button) {
		if (button == inputFraction) {
			try {
				if (numeratorField1.isValidNumber() && denominatorField1.isValidNumber()) {
					Fraction.checkInput(numeratorField1.getNumber(), denominatorField1.getNumber());
					Fraction.checkInput(numeratorField2.getNumber(), denominatorField2.getNumber());
					num1 = new Fraction(numeratorField1.getNumber(), denominatorField1.getNumber());
					num2 = new Fraction(numeratorField2.getNumber(), denominatorField2.getNumber());
					displayArea.setText("Fraction " + num1.toString() + " and " + num2.toString() + " entered!");
					displayArea.append("\nYou have entered 2 fractions, perform an operation now!");
					inputComplex.setEnabled(false);
					inputFraction.setEnabled(false);
					inputComplexFraction.setEnabled(false);
					massEnableDisable(true);
					numeratorField1.setText("");
					denominatorField1.setText("1");
					numeratorField2.setText("");
					denominatorField2.setText("1");
				} else {
					displayArea.setText("The numerator or denominator is either not a valid number, or is a non-integer number!");
				}
			} catch (Exception e) {
				displayArea.setText(e.getMessage());
			}
		} else if (button == inputComplex) {
				if (realField1.isValidNumber() && imaginaryField1.isValidNumber() && realField2.isValidNumber() && imaginaryField2.isValidNumber()) {
					num1 = new Complex(realField1.getNumber(), imaginaryField1.getNumber());
					num2 = new Complex(realField2.getNumber(), imaginaryField2.getNumber());
					displayArea.setText("Complex " + num1.toString() + " and " + num2.toString() + " entered!");
					inputFraction.setEnabled(false);
					inputComplex.setEnabled(false);
					inputComplexFraction.setEnabled(false);
					realField1.setText("");
					imaginaryField1.setText("");
					realField2.setText("");
					imaginaryField2.setText("");
					displayArea.append("\nYou have entered 2 complex numbers, perform an operation now!");
					massEnableDisable(true);
				} else {
					displayArea.setText("The real or imaginary value is not a valid number!");
				}
		} else if(button == inputComplexFraction) {
			if (checkAllComplexFractionFields()) {
				Fraction frac0 = new Fraction(realNumeratorField1.getNumber(), realDenominatorField1.getNumber());
				Fraction frac1 = new Fraction(imaginaryNumeratorField1.getNumber(), imaginaryDenominatorField1.getNumber());
				Fraction frac2 = new Fraction(realNumeratorField2.getNumber(), realDenominatorField2.getNumber());
				Fraction frac3 = new Fraction(imaginaryNumeratorField2.getNumber(), imaginaryDenominatorField1.getNumber());
				num1 = new ComplexFraction(frac0, frac1);
				num2 = new ComplexFraction(frac2, frac3);
				displayArea.setText("Complex Fraction " + num1.toString() + " and " + num2.toString() + " entered!");
				inputFraction.setEnabled(false);
				inputComplex.setEnabled(false);
				inputComplexFraction.setEnabled(false);
				realNumeratorField1.setText("");
				realDenominatorField1.setText("1");
				realNumeratorField2.setText("");
				realDenominatorField2.setText("1");
				imaginaryNumeratorField1.setText("");
				imaginaryDenominatorField1.setText("1");
				imaginaryNumeratorField2.setText("");
				imaginaryDenominatorField2.setText("1");
				displayArea.append("\nYou have entered 2 complex fractions, perform an operation now!");
				massEnableDisable(true);
			} else {
				displayArea.setText("The real or imaginary value(s) is not a valid number!");
			}
		} else if (button == add) {
			try {
				displayArea.setText(num1.add(num2).toString());
			} catch(NullPointerException e) {
				displayArea.setText(NOT_ENOUGH_INPUT);
			} catch(Exception e) {
				displayArea.setText(e.getMessage());
			}
		} else if (button == multiply) {
			try {
				displayArea.setText(num1.multiply(num2).toString());
			} catch(NullPointerException e) {
				displayArea.setText(NOT_ENOUGH_INPUT);
			} catch(Exception e) {
				displayArea.setText(e.getMessage());
			}
		} else if (button == subtract) {
			try {
				displayArea.setText(num1.subtract(num2).toString());
			} catch(NullPointerException e) {
				displayArea.setText(NOT_ENOUGH_INPUT);
			} catch(Exception e) {
				displayArea.setText(e.getMessage());
			}
		} else if (button == divide) {
			try {
				displayArea.setText(num1.divide(num2).toString());
			} catch(NullPointerException e) {
				displayArea.setText(NOT_ENOUGH_INPUT);
			} catch(Exception e) {
				displayArea.setText(e.getMessage());
			}
		} else if (button == subtractOther) {
			try {
				displayArea.setText(num2.subtract(num1).toString());
			} catch(NullPointerException e) {
				displayArea.setText(NOT_ENOUGH_INPUT);
			} catch(Exception e) {
				displayArea.setText(e.getMessage());
			}
		} else if (button == divideOther) {
			try {
				displayArea.setText(num2.divide(num1).toString());
			} catch(NullPointerException e) {
				displayArea.setText(NOT_ENOUGH_INPUT);
			} catch(Exception e) {
				displayArea.setText(e.getMessage());
			}
		} else if (button == clear) {
			inputFraction.setEnabled(true);
			inputComplex.setEnabled(true);
			inputComplexFraction.setEnabled(true);
			massEnableDisable(false);
			displayArea.setText("Inputs cleared!");
		} else if (button == exit) {
			System.exit(0);
		}
	}
	// massEnableDisable - enables or disables a large portion of the GUI at once
	// @param - state - if true, enable all objects, if false, disable all buttons
	private void massEnableDisable(boolean state) {
		add.setEnabled(state);
		subtract.setEnabled(state);
		multiply.setEnabled(state);
		divide.setEnabled(state);
		subtractOther.setEnabled(state);
		divideOther.setEnabled(state);
	}
	private boolean checkAllComplexFractionFields() {
		return realNumeratorField1.isValidNumber() && realNumeratorField2.isValidNumber() && realDenominatorField1.isValidNumber() &&
				realDenominatorField2.isValidNumber() && imaginaryNumeratorField1.isValidNumber() && imaginaryNumeratorField2.isValidNumber()
				&& imaginaryDenominatorField1.isValidNumber() && imaginaryDenominatorField1.isValidNumber();
	}
	public static void main(String[] args) {
		CalculatorGUI gui = new CalculatorGUI();
	}
}