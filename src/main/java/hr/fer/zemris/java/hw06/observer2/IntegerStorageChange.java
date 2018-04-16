package hr.fer.zemris.java.hw06.observer2;

import java.util.Objects;

/**
 * Razred predstavlja opisnik koji sa svojim atrinutima opisuje zadnju promjenu
 * 
 * @author Mihael
 *
 */
public class IntegerStorageChange {
	/**
	 * Referenca na {@link IntegerStorage}
	 */
	private IntegerStorage storage;
	/**
	 * Prijašnja vrijednost
	 */
	private int beforeChange;
	/**
	 * Trenutna vrijednost
	 */
	private int afterChange;

	/**
	 * Konstruktor koji stvara novi {@link IntegerStorageChange}
	 * 
	 * @param storage
	 *            - {@link IntegerStorage}
	 * @param beforeChange
	 *            - prijašnja vrijednost
	 * @param afterChange
	 *            - sadašnja vrijednost
	 */
	public IntegerStorageChange(IntegerStorage storage, int beforeChange, int afterChange) {
		this.storage = Objects.requireNonNull(storage);
		this.beforeChange = Objects.requireNonNull(beforeChange);
		this.afterChange = Objects.requireNonNull(afterChange);
	}

	/**
	 * Vraća referencu na {@link IntegerStorage}
	 * 
	 * @return {@link IntegerStorage}
	 */
	public IntegerStorage getStorage() {
		return storage;
	}

	/**
	 * Vraća prošlu pohranjenu vrijednost
	 * 
	 * @return vrijednost prije promjene
	 */
	public int getBeforeChange() {
		return beforeChange;
	}

	/**
	 * Trenutno pohranjena vrijednost
	 * 
	 * @return trenutno pohranjena vrijednost
	 */
	public int getAfterChange() {
		return afterChange;
	}

}
