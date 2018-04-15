package hr.fer.zemris.java.hw06.observer2;

/**
 * Interface with method which accepts {@link IntegerStorage} when stored value
 * is changed
 * 
 * @author Mihael
 *
 */
public interface IntegerStorageObserver {
	/**
	 * 
	 * @param istorage
	 *            - reference to structure {@link IntegerStorageChange} with
	 *            informations about last change
	 */
	public void valueChanged(IntegerStorageChange istorage);
}
