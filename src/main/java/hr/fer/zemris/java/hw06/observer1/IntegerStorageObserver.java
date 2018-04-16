package hr.fer.zemris.java.hw06.observer1;

/**
 * Sučelje s jednom metodom koja je obavještena kada se vrijednost promjenila.
 * Sučelje mora svaki promatrač implementirati
 * 
 * @author Mihael
 *
 */
public interface IntegerStorageObserver {
	/**
	 * Metoda koja je pozvana pri promjeni vrijednosti
	 * 
	 * @param istorage
	 *            - mjesto pohrane vrijednosti
	 */
	public void valueChanged(IntegerStorage istorage);
}
