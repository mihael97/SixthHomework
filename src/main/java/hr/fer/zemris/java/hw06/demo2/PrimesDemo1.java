package hr.fer.zemris.java.hw06.demo2;

/**
 * First example
 * 
 * @author Mihael
 *
 */
public class PrimesDemo1 {

	/**
	 * Main program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		PrimesCollection primesCollection = new PrimesCollection(5); // 5: how many of them
		for (Integer prime : primesCollection) {
			System.out.println("Got prime: " + prime);
		}
	}

}
