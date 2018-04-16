package hr.fer.zemris.java.hw06.observer2;

import java.util.ArrayList;
import java.util.List;

/**
 * Razred predstavlja spremnik primitivne vrijednosti
 * 
 * @author Mihael
 *
 */
public class IntegerStorage {
	/**
	 * Pohranjena vrijendost
	 * 
	 */
	private int value;
	/**
	 * Lista promatača
	 */
	private List<IntegerStorageObserver> observers; // use ArrayList here!!!

	/**
	 * Konstruktor koji inicijalizira početnu vrijednost
	 * 
	 * @param initialValue
	 *            - početna vrijednost
	 */
	public IntegerStorage(int initialValue) {
		this.value = initialValue;
		observers = new ArrayList<>();
	}

	/**
	 * Metoda briše promatrača iz liste
	 * 
	 * @param observer
	 *            - promatrač kojeg želimo izbrisati
	 */
	public void addObserver(IntegerStorageObserver observer) {
		if (!observers.contains(observer))
			observers.add(observer);
	}

	/**
	 * Metoda briše promatrača iz liste
	 * 
	 * @param observer
	 *            - promatrač kojeg želimo izbrisati
	 */
	public void removeObserver(IntegerStorageObserver observer) {
		observers.remove(observer);
	}

	/**
	 * Metoda briše sve promatrače iz liste
	 */
	public void clearObservers() {
		observers.clear();
	}

	/**
	 * Metoda vraća trenutno pohranjenu vrijednost
	 * 
	 * @return value - pohranjena vrijednost
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Ako je argument drugačiji od pohranjene vrijednosti,postavlja novu vrijednost
	 * 
	 * @param value
	 *            - nova vrijednost koju želimo postaviti
	 */
	public void setValue(int value) {
		if (this.value != value) {
			IntegerStorageChange storageChange = new IntegerStorageChange(this, this.value, value);
			this.value = value;
			if (observers != null) {
				ArrayList<IntegerStorageObserver> pomList = new ArrayList<>(observers);
				for (IntegerStorageObserver observer : pomList) {
					observer.valueChanged(storageChange);
				}
			}
		}
	}
}
