package hr.fer.zemris.java.hw06.observer1;

import java.util.Objects;

/**
 * Razred predstavlja naredbu ispisavanja dvostruko uvećane pohranjene
 * vrijednosti
 * 
 * @author Mihael
 *
 */
public class DoubleValue implements IntegerStorageObserver {

	/**
	 * Limit koliko želimo ispisati dvostruku vrijednost
	 */
	private int limit;

	/**
	 * Javni konstruktor
	 * 
	 * @param number
	 *            - koliko puta želimo ispisati uvećanu vrijednost
	 */
	public DoubleValue(int number) {
		limit = number;
	}

	/**
	 * Kada je pohranjena vrijednost promjenjena,ispisuje dvostruku vrijednost Kada
	 * je metoda pozvana n puta(n je zadan na početku konstruktoru) metoda briše
	 * trenutnog pratitelja iz liste pratitelja u {@link IntegerStorage}
	 * 
	 * @param istorage
	 *            - modificiran {@link IntegerStorage}
	 * @throws NullPointerException
	 *             - ako je argument null
	 */
	@Override
	public void valueChanged(IntegerStorage istorage) {
		Objects.requireNonNull(istorage);
		System.out.println("Double value: " + 2 * istorage.getValue());

		if (--limit == 0) {
			istorage.removeObserver(this);
		}
	}

}
