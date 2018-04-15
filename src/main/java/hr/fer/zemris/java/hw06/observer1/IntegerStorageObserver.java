package hr.fer.zemris.java.hw06.observer1;

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
	 * @param istorage - reference to updated {@link IntegerStorage}
	 */
	public void valueChanged(IntegerStorage istorage);
}
