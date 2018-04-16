package hr.fer.zemris.java.hw06.demo2;

import java.util.Iterator;

/**
 * Razred implementira generator prostih brojeva. Brojevi će sgenerirati sve dok
 * broj generiranih brjeva ne bude jednak broju zadanom preko konstruktora
 * 
 * @author Mihael
 *
 */
public class PrimesCollection implements Iterable<Integer> {

	/**
	 * Količina brojeva koju želimo generirati
	 */
	private final int limit;

	/**
	 * Javni konstruktor koji prima broj brojeva koje želimo generirati
	 * 
	 * @param number
	 *            - količina brojeva koju želimo generirati
	 */
	public PrimesCollection(int number) {
		limit = number;
	}

	/**
	 * Methoda vraća novi iterator za prolazak kroj proste brojeve
	 * 
	 * @return iterator
	 */
	@Override
	public Iterator<Integer> iterator() {
		return new IteratorClass();
	}

	/**
	 * Razred opisuje iterator kroz proste brojeve
	 * 
	 * @author Mihael
	 *
	 */
	private class IteratorClass implements Iterator<Integer> {

		/**
		 * Referenca na zadnji generirian broj
		 */
		private int lastGenerated;
		/**
		 * Broj generiranih brojeva
		 */
		private int numberOfGenerated;

		/**
		 * Zadani konstruktor
		 */
		public IteratorClass() {
			lastGenerated = 1;
			numberOfGenerated = 0;
		}

		/**
		 * Metoda provjerava jesmo li generirali sve brojeve
		 * 
		 * @return true ako nismo,inače false
		 */
		@Override
		public boolean hasNext() {
			return checkLimit();
		}

		/**
		 * Ako nismo generirali sve brojeve,vraća sljedećeg
		 * 
		 * @return sljedeći prosti broj
		 * @throws IllegalStateException
		 *             - ako smo već generirali sve brojeve
		 */
		@Override
		public Integer next() {
			if (checkLimit()) {

				int i = lastGenerated;
				boolean notPrime = false;

				do {
					i++;
					notPrime = false;
					for (int j = 2; j <= i / 2; j++) {
						if (i % j == 0) {
							notPrime = true;
							break;
						}
					}

				} while (notPrime);

				numberOfGenerated++;
				lastGenerated = i;
				return i;
			} else {
				throw new IllegalStateException("You already generated all numbers!");
			}
		}

		/**
		 * Metoda provjerava jesmo li generirali sve brojeve
		 * 
		 * @return true ako nismo,inače false
		 */
		private boolean checkLimit() {
			return numberOfGenerated < limit;
		}

	}
}
