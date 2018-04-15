package hr.fer.zemris.java.hw06.demo2;

import java.util.Iterator;

/**
 * Class implements prime number generator. Method will generate numbers until
 * amount of generated numbers is equals amount of numbers we want to generate
 * 
 * @author Mihael
 *
 */
public class PrimesCollection implements Iterable<Integer> {

	/**
	 * Number of prime numbers we want to generate
	 */
	private final int limit;

	/**
	 * Public constructor which accepts amount of numbers we want to generate
	 * 
	 * @param number
	 *            - amount of prime numbers we want to generate
	 */
	public PrimesCollection(int number) {
		limit = number;
	}

	/**
	 * Method returns new iterator for passing through prime numbers
	 * 
	 * @return instance of iterator
	 */
	@Override
	public Iterator<Integer> iterator() {
		return new IteratorClass();
	}

	/**
	 * Class implements Iterator through prime numbers
	 * 
	 * @author Mihael
	 *
	 */
	private class IteratorClass implements Iterator<Integer> {

		/**
		 * Reference to last generated number
		 */
		private int lastGenerated;
		/**
		 * Number of generated numbers
		 */
		private int numberOfGenerated;

		/**
		 * Public {@link IteratorClass} constructor
		 */
		public IteratorClass() {
			lastGenerated = 1;
			numberOfGenerated = 0;
		}

		/**
		 * Method checks if we can generate next prime number
		 */
		@Override
		public boolean hasNext() {
			return checkLimit();
		}

		/**
		 * If we didn't generate all numbers,returns next prime number
		 * 
		 * @return next prime number
		 * @throws if
		 *             we already generate amount of numbers we want
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
		 * Method checks if we generated enough numbers
		 * 
		 * @return true if we still need to generate some numbers,otherwise false
		 */
		private boolean checkLimit() {
			return numberOfGenerated < limit;
		}

	}
}
