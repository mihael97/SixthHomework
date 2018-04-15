package hr.fer.zemris.java.hw06.demo2;

import static org.junit.Assert.*;

import java.util.Iterator;
import org.junit.Test;


@SuppressWarnings("javadoc")
public class PrimesCollectionTest {
	
	@Test 
	public void fiftiethPrimeNumber() {
		PrimesCollection collection=new PrimesCollection(50);
		
		int i=1;
		
		for(Integer integer:collection) {
			if(i++==50) {
				assertEquals(Integer.valueOf(229),integer);
			}
		}
	}
	
	@Test
	public void tenthPrimeNumber() {
		Iterator<Integer> iter=new PrimesCollection(10).iterator();
		
		for(int i=0;i<9;i++) {
			iter.next();
		}
		
		assertEquals(Integer.valueOf(29), iter.next());
		assertFalse(iter.hasNext());
	}
	
	@Test(expected=IllegalStateException.class)
	public void illegalStateException() {
		Iterator<Integer> iter=new PrimesCollection(10).iterator();
		
		for(int i=0;i<10;i++) {
			iter.next();
		}
		
		assertFalse(iter.hasNext());
		iter.next();
	}
}
