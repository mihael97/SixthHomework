package hr.fer.zemris.java.hw06.observer1;

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
	 *            - modificiran {@link IntegerStorage}
	 * @throws NullPointerException
	 *             - ako je argument null
	 */
	@Override
	public void valueChanged(IntegerStorage istorage) {
		Objects.requireNonNull(istorage);
		System.out.println("Provided new value: " + istorage.getValue() + ",square is "
				+ String.format("%.0f", Math.pow(istorage.getValue(), 2)));
	}

}
