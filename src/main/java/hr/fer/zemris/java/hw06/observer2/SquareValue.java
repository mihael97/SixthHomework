package hr.fer.zemris.java.hw06.observer2;

/**
 * Class implements process which prints square of current value
 * 
 * @author Mihael
 *
 */
public class SquareValue implements IntegerStorageObserver {

	/**
	 * When stored value is changed,method prints square of new value
	 * 
	 * @param istorage
	 *            - structure which contains informations about changes
	 */
	@Override
	public void valueChanged(IntegerStorageChange istorage) {
		System.out.println("Provided new value: " + istorage.getStorage().getValue() + ",square is "
				+ String.format("%.0f", Math.pow(istorage.getStorage().getValue(), 2)));
	}

}
