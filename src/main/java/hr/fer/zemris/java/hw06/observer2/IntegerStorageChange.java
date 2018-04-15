package hr.fer.zemris.java.hw06.observer2;

/**
 * Class implements structure with attributes: storage(type
 * {@link IntegerStorage}) and before and after change stored values(type
 * primitive integer). It is used for storing more informations about last
 * change
 * 
 * @author Mihael
 *
 */
public class IntegerStorageChange {
	/**
	 * Reference to IntegerStorage
	 */
	private IntegerStorage storage;
	/**
	 * Reference to previous value of stored value
	 */
	private int beforeChange;
	/**
	 * Reference to future value of stored value
	 */
	private int afterChange;

	/**
	 * Constructor which makes new {@link IntegerStorageChange}
	 * 
	 * @param storage
	 *            - {@link IntegerStorage}
	 * @param beforeChange
	 *            - value before change
	 * @param afterChange
	 *            - value after change
	 */
	public IntegerStorageChange(IntegerStorage storage, int beforeChange, int afterChange) {
		super();
		this.storage = storage;
		this.beforeChange = beforeChange;
		this.afterChange = afterChange;
	}

	/**
	 * Returns {@link IntegerStorage}
	 * 
	 * @return {@link IntegerStorage}
	 */
	public IntegerStorage getStorage() {
		return storage;
	}

	/**
	 * Returns value which was stored before change
	 * 
	 * @return value before change
	 */
	public int getBeforeChange() {
		return beforeChange;
	}

	/**
	 * Returns value which is currently stored
	 * 
	 * @return currently stored value
	 */
	public int getAfterChange() {
		return afterChange;
	}

}
