package hr.fer.zemris.java.custom.scripting;

import hr.fer.zemris.java.custom.scripting.exceptions.ValueWrapperException;

public class ValueWrapper {
	private Object value;

	public ValueWrapper(Object value) {
		this.value = value;
	}

	public void add(Object incValue) {
		calculate(incValue, "add");
	}

	public void subtract(Object decValue) {
		calculate(decValue, "subtract");
	}

	public void multiply(Object mulValue) {
		calculate(mulValue, "multiply");
	}

	public void divide(Object divValue) {
		calculate(divValue, "divide");
	}

	public int numCompare(Object withValue) {
		if (value == null && withValue == null)
			return 0;

		Object first = parse(withValue);
		Object second = cast(first);

		if (first instanceof Double) {
			return ((Double) first).compareTo((Double) second);
		}

		return ((Integer) first).compareTo((Integer) second);
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	private void calculate(Object incValue, String string) {
		checkType(incValue);
		Object number1 = parse(incValue);
		Object number2 = cast(number1);

		switch (string.trim().toLowerCase()) {
		case "add":
			if (number1 instanceof Double) {
				value = Double.valueOf((Double) number1 + (Double) number2);
			} else {
				value = Integer.valueOf((Integer) number1 + (Integer) number2);
			}
			break;
		case "subtract":
			if (number1 instanceof Double) {
				value = Double.valueOf((Double) number2 - (Double) number1);
			} else {
				value = Integer.valueOf((Integer) number2 - (Integer) number1);
			}
			break;
		case "multiply":
			if (number1 instanceof Double) {
				value = Double.valueOf((Double) number1 * (Double) number2);
			} else {
				value = Integer.valueOf((Integer) number1 * (Integer) number2);
			}
			break;
		case "divide":
			if (number1 instanceof Double) {
				Double first = (Double) number1;

				if (first.doubleValue() == 0) {
					throw new ArithmeticException("Number can't be divided by zero!");
				}

				value = Double.valueOf((Double) number2 / first);
			} else {
				Integer first = (Integer) number1;

				value = Double.valueOf((Integer) number2 / first);
			}
			break;
		default:
			throw new IllegalArgumentException("Invalid operation!");
		}
	}

	private Object cast(Object number1) {

		String casted = "";
		if (value == null) {
			casted += "0";
		} else {
			casted = String.valueOf(value);
		}

		if (number1 instanceof Double) {
			return Double.valueOf(Double.parseDouble(casted));
		}

		if (number1 instanceof Integer) {
			return Integer.valueOf(Integer.parseInt(casted));
		}

		return null;
	}

	private Object parse(Object incValue) {
		String casted = String.valueOf(incValue);

		if (incValue == null) {
			return Integer.valueOf(0);
		}
		if (incValue instanceof String) {

			try {
				if (casted.contains(".") || casted.contains("E")) {
					return Double.parseDouble(casted);
				}

				return Integer.parseInt(casted);
			} catch (NumberFormatException e) {
				throw new ValueWrapperException("Result of operation is undefined.Parse failed for\'" + casted + "\'");
			}
		} else if (incValue instanceof Double) {
			return Double.valueOf((Double.parseDouble(casted)));
		} else {
			return Integer.valueOf(Integer.parseInt(casted));
		}
	}

	private void checkType(Object incValue) {
		if (!(incValue == null || incValue instanceof Double || incValue instanceof Integer
				|| incValue instanceof String)) {
			throw new RuntimeException("Argument must be instance of Double,Integer or String. Also it can be null!");
		}
	}
}
