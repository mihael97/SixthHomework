package hr.fer.zemris.java.hw06.observer2;

/**
 * Class implements changes counter
 * 
 * @author Mihael
 *
 */
public class ChangeCounter implements IntegerStorageObserver {
	/**
	 * Numbers of changes
	 */
	private int numberOfChanges;

	/**
	 * Public constructor
	 */
	public ChangeCounter() {
		numberOfChanges = 0;
	}

	/**
	 * When stored value is changed,method increments number of changes and prints
	 * current number of changes
	 * 
	 * @param istorage
	 *            - structure with informations about last change
	 */
	@Override
	public void valueChanged(IntegerStorageChange istorage) {
		System.out.println("Number of value changes since tracking: " + (++numberOfChanges));
	}
}
