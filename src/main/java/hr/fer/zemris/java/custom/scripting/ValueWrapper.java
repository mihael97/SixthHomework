package hr.fer.zemris.java.custom.scripting;

import hr.fer.zemris.java.custom.scripting.exceptions.ValueWrapperException;

/**
 * Class implements Wrapper for values which are used in
 * {@link ObjectMultistack}. Value can be Double,Integer,String or null
 * 
 * @author Mihael
 *
 */
public class ValueWrapper {
	/**
	 * Wrapper value
	 */
	private Object value;

	/**
	 * Public constructor for value initialization
	 * 
	 * @param value
	 * @throws ValueWrapperException
	 *             - if type of value is not supported
	 */
	public ValueWrapper(Object value) {
		checkType(value);
		this.value = value;
	}

	/**
	 * Method adds argument to current value
	 * 
	 * @param incValue
	 *            - addition argument
	 */
	public void add(Object incValue) {
		calculate(incValue, "add");
	}

	/**
	 * Method subtract argument from current value
	 * 
	 * @param decValue
	 *            - second argument in subtraction
	 */
	public void subtract(Object decValue) {
		calculate(decValue, "subtract");
	}

	/**
	 * Method multiplies current value and argument
	 * 
	 * @param mulValue
	 *            - argument used for multiplication
	 */
	public void multiply(Object mulValue) {
		calculate(mulValue, "multiply");
	}

	/**
	 * Method divides current stored number with argument
	 * 
	 * @param divValue
	 *            - argument used for division (denominator)
	 */
	public void divide(Object divValue) {
		calculate(divValue, "divide");
	}

	/**
	 * Method compares current stored value and argument. If current value is
	 * smaller than argument,returned value will be integer negative integer. If
	 * stored value is greater,returned integer will be positive integer. If values
	 * are equal or null, returned value will be 0
	 * 
	 * @param withValue
	 *            - argument used for comparison
	 * @return integer(presents relation between stored value and argument)
	 */
	public int numCompare(Object withValue) {
		if (value == null && withValue == null)
			return 0;

		Object first = parse(withValue);
		Object second = cast();

		if (first instanceof Double || second instanceof Double) {
			return ((Double) second).compareTo((Double) first);
		}

		return ((Integer) second).compareTo((Integer) first);
	}

	/**
	 * Method returns current stored value
	 * 
	 * @return current value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * Method sets value to another value
	 * 
	 * @param value
	 *            - new value
	 * 
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * Method calculates next value state depends on operation and argument
	 * 
	 * @param incValue
	 *            - argument
	 * @param string
	 *            - operation we want to make
	 * 
	 * @throws ValueWrapperException
	 *             - if operation is not supported
	 * @throws ArithmeticException
	 *             - is operation is divide and denominator is zero
	 */
	private void calculate(Object incValue, String string) {
		checkType(incValue);
		Object number1 = parse(incValue);
		Object number2 = cast();

		switch (string.trim().toLowerCase()) {
		case "add":
			if (number1 instanceof Double || number2 instanceof Double) {

				double[] array = getDoubles(number1, number2);
				value = Double.valueOf(array[0] + array[1]);

			} else {
				value = Integer.valueOf((Integer) number1 + (Integer) number2);
			}
			break;
		case "subtract":
			if (number1 instanceof Double || number2 instanceof Double) {
				double[] array = getDoubles(number1, number2);
				value = Double.valueOf(array[1] - array[0]);
			} else {
				value = Integer.valueOf((Integer) number2 - (Integer) number1);
			}
			break;
		case "multiply":
			if (number1 instanceof Double || number2 instanceof Double) {
				double[] array = getDoubles(number1, number2);
				value = Double.valueOf(array[0] * array[1]);
			} else {
				value = Integer.valueOf((Integer) number1 * (Integer) number2);
			}
			break;
		case "divide":
			if (number1 instanceof Double || number2 instanceof Double) {
				double[] array = getDoubles(number1, number2);

				if (array[1] == 0) {
					throw new ArithmeticException("Number can't be divided with zero!");
				}

				value = Double.valueOf(array[1] / array[0]);

			} else {
				Integer first = (Integer) number1;

				if (first.intValue() == 0) {
					throw new ArithmeticException("Number can't be divided with zero!");
				}

				value = Integer.valueOf((Integer) number2 / first);
			}
			break;
		default:
			throw new ValueWrapperException("Invalid operation!");
		}
	}

	/**
	 * Method casts current value to type of argument
	 * 
	 * @return casted current value
	 * @throws ValueWrapperException
	 *             - if current value can't be casted
	 */
	private Object cast() {

		if (value == null) {
			return Integer.valueOf(0);
		}

		try {
			if (value instanceof Double) {
				return Double.valueOf(Double.parseDouble(String.valueOf(value)));
			}

			if (value instanceof Integer) {
				return Integer.valueOf(Integer.parseInt(String.valueOf(value)));
			}

			String casted = String.valueOf(value);

			if (casted.contains(".") || casted.contains("E"))
				return Double.valueOf(Double.parseDouble(casted));

			return Integer.valueOf(Integer.parseInt(casted));
		} catch (NumberFormatException e) {
			throw new ValueWrapperException("Value can't be casted to any supported type!");
		}

	}

	/**
	 * Method converts Object to some {@link Number} type. If argument is null,it
	 * will be converted to Integer with value 0. If argument is String,it will be
	 * converted to Double or Integer,depends if it contains '.' or 'E'. If argument
	 * is Double or Integer,returned Object will have same type
	 * 
	 * @param incValue
	 * @return converted Object
	 * 
	 * @throws ValueWrapperException
	 *             - if String can't be parsed to Double or Integer
	 */
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
				throw new ValueWrapperException(
						"Result of operation is undefined.Parsing failed for\'" + casted + "\'");
			}
		} else if (incValue instanceof Double) {
			return Double.valueOf((Double.parseDouble(casted)));
		} else {
			return Integer.valueOf(Integer.parseInt(casted));
		}
	}

	/**
	 * Method checks if argument's type is supported. Supported types are
	 * Integer,Double,String or null
	 * 
	 * @param incValue
	 *            - argument whose type we want check
	 * @throws ValueWrapperException
	 *             - if argument's type is not supported
	 */
	private void checkType(Object incValue) {
		if (!(incValue == null || incValue instanceof Double || incValue instanceof Integer
				|| incValue instanceof String)) {
			throw new ValueWrapperException(
					"Argument must be instance of Double,Integer or String. Also it can be null!");
		}
	}

	/**
	 * Method creates array with two elements,every element is double value of
	 * argument
	 * 
	 * @param number1
	 *            - first argument
	 * @param number2
	 *            - second argument
	 * @return double array
	 */
	private double[] getDoubles(Object number1, Object number2) {
		double[] array = new double[2];

		array[0] = (number1 instanceof Double) ? ((Double) number1).doubleValue()
				: Double.valueOf(((Integer) number1).intValue());

		array[1] = (number2 instanceof Double) ? ((Double) number2).doubleValue()
				: Double.valueOf(((Integer) number2).intValue());

		return array;
	}
}
