package hr.fer.zemris.java.custom.scripting.exceptions;

/**
 * Class implements specific exception for ValueWrapper
 * 
 * @author ime
 *
 */
public class ValueWrapperException extends RuntimeException {

	/**
	 * serialVerionID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Public constructor
	 * 
	 * @param str
	 *            - exception explanation
	 */
	public ValueWrapperException(String str) {
		super(str);
	}
}
