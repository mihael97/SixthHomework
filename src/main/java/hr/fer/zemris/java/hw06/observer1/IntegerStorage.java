package hr.fer.zemris.java.hw06.observer1;

import java.util.ArrayList;
import java.util.List;

/**
 * Class implements our 'Subject'. It stores primitive integer value
 * 
 * @author Mihael
 *
 */
public class IntegerStorage {
	/**
	 * Primitive integer value
	 */
	private int value;
	/**
	 * List of all observers
	 */
	private List<IntegerStorageObserver> observers; // use ArrayList here!!!

	/**
	 * Constructor which sets value to given argument
	 * 
	 * @param initialValue
	 *            - first value
	 */
	public IntegerStorage(int initialValue) {
		this.value = initialValue;
		observers = new ArrayList<>();
	}

	/**
	 * Method adds new observer to list. After every change,observers and contacted
	 * and
	 * 
	 * @param observer
	 *            - observer we want to add
	 */
	public void addObserver(IntegerStorageObserver observer) {
		if (!observers.contains(observer))
			observers.add(observer);
	}

	/**
	 * Method removes observer from list
	 * 
	 * @param observer
	 *            - observer we want to remove
	 */
	public void removeObserver(IntegerStorageObserver observer) {
		observers.remove(observer);
	}

	/**
	 * Method clears(removes) all observers
	 */
	public void clearObservers() {
		observers.clear();
	}

	/**
	 * Method return current stored value
	 * 
	 * @return value - stored value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * If given value is not same as stored one,method sets stored value to argument
	 * 
	 * @param value
	 *            - new value we want to store
	 */
	public void setValue(int value) {
		if (this.value != value) {
			this.value = value;
			if (observers != null) {
				ArrayList<IntegerStorageObserver> pomList = new ArrayList<>(observers);
				for (IntegerStorageObserver observer : pomList) {
					observer.valueChanged(this);
				}
			}
		}
	}
}
