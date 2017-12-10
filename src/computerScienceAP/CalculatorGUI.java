package computerScienceAP;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import BreezySwing.GBFrame;
import BreezySwing.IntegerField;

@SuppressWarnings({"serial", "unused"})
public class CalculatorGUI extends GBFrame {
	private JLabel numeratorLabel = addLabel("Numerator", 1, 1, 1, 1);
	private JLabel denominatorLabel = addLabel("Denominator", 1, 2, 1, 1);
	private IntegerField numeratorField = addIntegerField(0, 2, 1, 1, 1);
	private IntegerField denominatorField = addIntegerField(1, 2, 2, 1, 1);
	private JButton inputFraction = addButton("Input Fraction", 2, 4, 1, 1);
	private JLabel realLabel = addLabel("Real", 3, 1, 1, 1);
	private JLabel imaginaryLabel = addLabel("Imaginary", 3, 2, 1, 1);
	private IntegerField realField = addIntegerField(0, 4, 1, 1, 1);
	private IntegerField imaginaryField = addIntegerField(0, 4, 2, 1, 1);
	private JLabel iLabel = addLabel("i              ", 4, 3, 1, 1);
	private JButton inputComplex = addButton("Input Complex", 4, 4, 1, 1);
	private JButton add = addButton("Add", 5, 1, 1, 1);
	private JButton subtract = addButton("Subtract 1st from 2nd", 5, 2, 1, 1);
	private JButton multiply = addButton("Multiply", 5, 3, 1, 1);
	private JButton divide = addButton("Divide 1st from 2nd", 5, 4, 1, 1);
	private JButton clear = addButton("Clear", 5, 5, 1, 1);
	private JButton exit = addButton("Exit", 5, 6, 1, 1);
	private JButton subtractOther = addButton("Subtract 2nd from 1st", 6, 2, 1, 1);
	private JButton divideOther = addButton("Divide 2nd from 1st", 6, 4, 1, 1);
	private JTextArea displayArea = addTextArea("", 7, 1, 6, 1);
	private Calculator calculator = new Calculator();
	private int numInputted;
	
	public CalculatorGUI() {
		setVisible(true);
		setSize(800, 500);
		numeratorField.setText("");
		realField.setText("");
		imaginaryField.setText("");
		displayArea.setEditable(false);
		massEnableDisable(false);
		numInputted = 0;
	}
	public void buttonClicked(JButton button) {
		if(button == inputFraction) {
			try {
				if(numInputted < 2) {
					if(numeratorField.isValidNumber() && denominatorField.isValidNumber()) {
						Fraction.checkInput(numeratorField.getNumber(), denominatorField.getNumber());
						Fraction frac = new Fraction(numeratorField.getNumber(), denominatorField.getNumber());
						calculator.input(frac);
						displayArea.setText("Fraction " + frac.toString() + " entered!");
						numInputted++;
						inputComplex.setEnabled(false);
						numeratorField.setText("");
						denominatorField.setText("");
						if(numInputted == 2) {
							displayArea.setText("You have entered 2 fractions, perform an operation now!");
							massEnableDisable(true);
							inputFraction.setEnabled(false);
						}
					} else {
						displayArea.setText("The numerator or denominator is not a valid number!");
					}
				} else {
					displayArea.setText("Perform an operation");
				}
			} catch(Exception e) {
				displayArea.setText(e.getMessage());
			}
		} else if(button == inputComplex) {
			try {
				if(numInputted < 2) {
					if(realField.isValidNumber() && imaginaryField.isValidNumber()) {
						Complex comp = new Complex(realField.getNumber(), imaginaryField.getNumber());
						calculator.input(comp);
						displayArea.setText("Complex " + comp.toString() + " entered!");
						numInputted++;
						inputFraction.setEnabled(false);
						realField.setText("");
						imaginaryField.setText("");
						if(numInputted == 2) {
							displayArea.setText("You have entered 2 complex numbers, perform an operation now!");
							massEnableDisable(true);
							inputComplex.setEnabled(false);
						}
					} else {
						displayArea.setText("The numerator or denominator is not a valid number!");
					}
				} else {
					displayArea.setText("You have entered 2 fractions, perform an operation now!");
					massEnableDisable(true);
					inputComplex.setEnabled(false);
				}
			} catch(Exception e) {
				displayArea.setText(e.getMessage());
			}
		} else if(button == add) {
			displayArea.setText(calculator.add());
		} else if(button == multiply) {
			displayArea.setText(calculator.multiply());
		} else if(button == subtract) {
			displayArea.setText(calculator.subtract());
		} else if(button == divide) {
			displayArea.setText(calculator.divide());
		} else if(button == subtractOther) {
			displayArea.setText(calculator.subtractOther());
		} else if(button == divideOther) {
			displayArea.setText(calculator.divideOther());
		}else if(button == clear) {
			inputFraction.setEnabled(true);
			inputComplex.setEnabled(true);
			massEnableDisable(false);
			calculator.reset();
			numInputted = 0;
		} else if(button == exit) {
			System.exit(0);
		}
	}
	private void massEnableDisable(boolean state) {
		add.setEnabled(state);
		subtract.setEnabled(state);
		multiply.setEnabled(state);
		divide.setEnabled(state);
		subtractOther.setEnabled(state);
		divideOther.setEnabled(state);
	}
	public static void main(String[] args) {
		CalculatorGUI gui = new CalculatorGUI();
	}
}