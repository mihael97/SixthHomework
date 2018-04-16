package hr.fer.zemris.java.hw06.observer2;

import java.util.Objects;

/**
 * Razred predstavlja brojač promjena
 * 
 * @author Mihael
 *
 */
public class ChangeCounter implements IntegerStorageObserver {
	/**
	 * Broj promjena
	 */
	private int numberOfChanges;

	/**
	 * Javni konstruktor
	 */
	public ChangeCounter() {
		numberOfChanges = 0;
	}

	/**
	 * Kada je pohranjena vrijendost promjenjena,metoda inkrementira brojač promjena
	 * i ispisuje ga
	 * 
	 * @param istorage
	 *            - opisnik zadnje promjene
	 * 
	 * @throws NullPointerException
	 *             - ako je argument null
	 */
	@Override
	public void valueChanged(IntegerStorageChange istorage) {
		Objects.requireNonNull(istorage);
		System.out.println("Number of value changes since tracking: " + (++numberOfChanges));
	}
}
