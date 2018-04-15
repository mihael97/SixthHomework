package hr.fer.zemris.java.hw06.observer1;

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
	 *            - modified {@link IntegerStorage}
	 */
	@Override
	public void valueChanged(IntegerStorage istorage) {
		System.out.println("Provided new value: " + istorage.getValue() + ",square is "
				+ String.format("%.0f", Math.pow(istorage.getValue(), 2)));
	}

}
