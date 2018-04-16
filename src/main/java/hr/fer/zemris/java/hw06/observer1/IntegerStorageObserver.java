package hr.fer.zemris.java.hw06.observer1;

import hr.fer.zemris.java.hw06.observer2.IntegerStorageChange;

/**
 * Interface with method which accepts {@link IntegerStorage} when stored value
 * is changed
 * 
 * @author Mihael
 *
 */
public interface IntegerStorageObserver {
	/**
	 * Method is called when stored value is changed
	 * 
	 * @param istorage
	 *            -reference to structure {@link IntegerStorageChange} with
	 *            informations about last change
	 */
	public void valueChanged(IntegerStorage istorage);
}
