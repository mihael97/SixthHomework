package hr.fer.zemris.java.custom.scripting.exceptions;

/**
 * Class implements exception which can be thrown in {@link ObjectMultistackTest}
 * 
 * @author Mihael
 *
 */
public class ObjectMultistackException extends RuntimeException {

	/**
	 * serialVerisonUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Public constructor with string argument we want to print
	 * 
	 * @param text
	 *            - exception explanation
	 */
	public ObjectMultistackException(String text) {
		super(text);
	}
}
