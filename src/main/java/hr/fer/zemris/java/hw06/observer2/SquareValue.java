package hr.fer.zemris.java.hw06.observer2;

import java.util.Objects;

/**
 * Razred predstavlja akciju ispisa kvadrata pohranjene vrijendnosti
 * 
 * @author Mihael
 *
 */
public class SquareValue implements IntegerStorageObserver {

	/**
	 * Kada je vrijednost promjenjena,metoda ispisuje novu kvadriranu vrijednost
	 * 
	 * @param istorage
	 *            - opisnik zadnje promjene
	 * @throws NullPointerException
	 *             - ako je argument null
	 */
	@Override
	public void valueChanged(IntegerStorageChange istorage) {
		
		Objects.requireNonNull(istorage);
		System.out.println("Provided new value: " + istorage.getStorage().getValue() + ",square is "
				+ String.format("%.0f", Math.pow(istorage.getStorage().getValue(), 2)));
	}

}
