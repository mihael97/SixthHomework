package hr.fer.zemris.java.custom.scripting.exceptions;

import hr.fer.zemris.java.custom.scripting.ObjectMultistack;

/**
 * Razred predstavlja iznimku koja se može koristiti u {@link ObjectMultistack}
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
	 * Javni konstruktor
	 * 
	 * @param text
	 *            - opis iznimke
	 */
	public ObjectMultistackException(String text) {
		super(text);
	}
}
