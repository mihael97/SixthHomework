package hr.fer.zemris.java.hw06.demo2;

/**
 * Prvi primjer iz upute
 * 
 * @author Mihael
 *
 */
public class PrimesDemo1 {

	/**
	 * Glavni program
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
