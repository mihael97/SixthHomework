package hr.fer.zemris.java.hw06.observer2;

/**
 * Class implements process which prints double value of current stored value
 * 
 * @author Mihael
 *
 */
public class DoubleValue implements IntegerStorageObserver {

	/**
	 * Limit how much time we want to print double value of stored integer
	 */
	private int limit;

	/**
	 * Public constructor
	 * 
	 * @param number
	 *            - how much times we want to print double value of current stored
	 *            integer
	 */
	public DoubleValue(int number) {
		limit = number;
	}

	/**
	 * When stored value is changed,method prints double value of current stored
	 * value. When method is called for n times(n is given to the constructor at the
	 * begin), it de-registers this observer from observers list in
	 * {@link IntegerStorage}
	 * 
	 * @param istorage
	 *            - structure with informations about last change
	 */
	@Override
	public void valueChanged(IntegerStorageChange istorage) {
		System.out.println("Double value: " + 2 * istorage.getStorage().getValue());

		if (--limit == 0) {
			istorage.getStorage().removeObserver(this);
		}
	}

}