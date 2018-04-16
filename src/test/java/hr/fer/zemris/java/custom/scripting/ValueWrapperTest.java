package hr.fer.zemris.java.custom.scripting;

import static org.junit.Assert.*;

import org.junit.Test;

import hr.fer.zemris.java.custom.scripting.exceptions.ValueWrapperException;

@SuppressWarnings("javadoc")
public class ValueWrapperTest {

	private static final Double DELTA = 1E-6;

	@Test
	public void nullValue() {
		ValueWrapper wrapper = new ValueWrapper(null);
		assertNull(wrapper.getValue());
	}

	@Test
	public void doubleValue() {
		ValueWrapper wrapper = new ValueWrapper(Double.valueOf(2.5));
		assertTrue(wrapper.getValue() instanceof Double);
		assertEquals(Double.valueOf(2.5), (Double) wrapper.getValue());
	}

	@Test
	public void integerValue() {
		ValueWrapper wrapper = new ValueWrapper(Integer.valueOf(3));
		assertTrue(wrapper.getValue() instanceof Integer);
		assertEquals(Integer.valueOf(3), (Integer) wrapper.getValue());
	}

	@Test
	public void stringValue() {
		ValueWrapper wrapper = new ValueWrapper(String.valueOf("Name"));
		assertTrue(wrapper.getValue() instanceof String);
		assertEquals("Name", (String) wrapper.getValue());
	}

	@Test(expected = ValueWrapperException.class)
	public void booleanTest() {
		@SuppressWarnings("unused")
		ValueWrapper wrapper = new ValueWrapper(true);
	}

	// mathematical operations

	// integers
	@Test
	public void twoIntegersAdd() {
		ValueWrapper wrapper = new ValueWrapper(Integer.valueOf(5));
		wrapper.add(Integer.valueOf(7));

		assertTrue(wrapper.getValue() instanceof Integer);
		assertEquals(Integer.valueOf(12), (Integer) wrapper.getValue());
	}

	@Test
	public void twoIntegersSubtract() {
		ValueWrapper wrapper = new ValueWrapper(Integer.valueOf(5));
		wrapper.subtract(Integer.valueOf(7));

		assertTrue(wrapper.getValue() instanceof Integer);
		assertEquals(Integer.valueOf(-2), (Integer) wrapper.getValue());
	}

	@Test
	public void twoIntegersMultiply() {
		ValueWrapper wrapper = new ValueWrapper(Integer.valueOf(5));
		wrapper.multiply(Integer.valueOf(7));

		assertTrue(wrapper.getValue() instanceof Integer);
		assertEquals(Integer.valueOf(35), (Integer) wrapper.getValue());
	}

	@Test
	public void twoIntegersDivide() {
		ValueWrapper wrapper = new ValueWrapper(Integer.valueOf(5));
		wrapper.divide(Integer.valueOf(7));

		assertTrue(wrapper.getValue() instanceof Integer);
		assertEquals(Integer.valueOf(0), (Integer) wrapper.getValue());
	}

	// doubles

	@Test
	public void twoDoublesAdd() {
		ValueWrapper wrapper = new ValueWrapper(Double.valueOf(3.7));
		wrapper.add(Double.valueOf(2.4));

		assertTrue(wrapper.getValue() instanceof Double);
		assertEquals(Double.valueOf(6.1), (Double) wrapper.getValue());
	}

	@Test
	public void twoDoublesSubtract() {
		ValueWrapper wrapper = new ValueWrapper(Double.valueOf(2.1));
		wrapper.subtract(Double.valueOf(1.8));

		assertTrue(wrapper.getValue() instanceof Double);
		assertEquals(Double.valueOf(0.3), (Double) wrapper.getValue(), DELTA);
	}

	@Test
	public void twoDoublesMultiply() {
		ValueWrapper wrapper = new ValueWrapper(Double.valueOf(2.5));
		wrapper.multiply(Double.valueOf(2.5));

		assertTrue(wrapper.getValue() instanceof Double);
		assertEquals(Double.valueOf(6.25), (Double) wrapper.getValue());
	}

	@Test
	public void twoDoublesDivide() {
		ValueWrapper wrapper = new ValueWrapper(Double.valueOf(2.5));
		wrapper.divide(Double.valueOf(3.2));

		assertTrue(wrapper.getValue() instanceof Double);
		assertEquals(Double.valueOf(0.78125), (Double) wrapper.getValue());
	}

	// Integer and Double

	@Test
	public void bothTypesAdd() {
		ValueWrapper wrapper = new ValueWrapper(Double.valueOf(3.7));
		wrapper.add(Integer.valueOf(2));

		assertTrue(wrapper.getValue() instanceof Double);
		assertEquals(Double.valueOf(5.7), (Double) wrapper.getValue());
	}

	@Test
	public void bothTypesSubtract() {
		ValueWrapper wrapper = new ValueWrapper(Integer.valueOf(3));
		wrapper.subtract(Double.valueOf(2.1));

		assertTrue(wrapper.getValue() instanceof Double);
		assertEquals(Double.valueOf(0.9), (Double) wrapper.getValue(), DELTA);
	}

	@Test
	public void bothTypesMultiply() {
		ValueWrapper wrapper = new ValueWrapper(Double.valueOf(2.5));
		wrapper.multiply(Integer.valueOf(2));

		assertTrue(wrapper.getValue() instanceof Double);
		assertEquals(Double.valueOf(5), (Double) wrapper.getValue());
	}

	@Test
	public void bothTypesDivide() {
		ValueWrapper wrapper = new ValueWrapper(Integer.valueOf(2));
		wrapper.divide(Double.valueOf(0.8));

		assertTrue(wrapper.getValue() instanceof Double);
		assertEquals(Double.valueOf(2.5), (Double) wrapper.getValue());
	}

	// string

	@Test
	public void stringAdditionWithDoubleFirst() {
		ValueWrapper wrapper = new ValueWrapper(Double.valueOf(2.5));
		wrapper.add(String.valueOf("2.5"));

		assertTrue(wrapper.getValue() instanceof Double);
		assertEquals(Double.valueOf(5), (Double) wrapper.getValue());
	}

	@Test
	public void stringAdditionWithDoubleSecond() {
		ValueWrapper wrapper = new ValueWrapper(Double.valueOf(0.1));
		wrapper.add(String.valueOf("1E2"));

		assertTrue(wrapper.getValue() instanceof Double);
		assertEquals(Double.valueOf(100.1), (Double) wrapper.getValue());
	}

	@Test
	public void stringAdditionWithInteger() {
		ValueWrapper wrapper = new ValueWrapper(Integer.valueOf(5));
		wrapper.add(String.valueOf("5"));

		assertTrue(wrapper.getValue() instanceof Integer);
		assertEquals(Integer.valueOf(10), (Integer) wrapper.getValue());
	}

	@Test
	public void stringDivideWithInteger() {
		ValueWrapper wrapper = new ValueWrapper(Integer.valueOf(5));
		wrapper.divide(String.valueOf("2"));

		assertTrue(wrapper.getValue() instanceof Integer);
		assertEquals(Integer.valueOf(2), (Integer) wrapper.getValue());
	}

	// numCompare
	
	@Test
	public void nullVariables() {
		ValueWrapper wrapper=new ValueWrapper(null);
		
		assertEquals(0, wrapper.numCompare(null));
	}
	
	@Test
	public void nullAndIntegerFirst() {
		ValueWrapper wrapper=new ValueWrapper(null);
		
		assertEquals(0, wrapper.numCompare(0));
	}
	
	@Test
	public void nullAndIntegerSecond() {
		ValueWrapper wrapper=new ValueWrapper(null);
		
		assertTrue(wrapper.numCompare(Integer.valueOf(3))<0);
	}
	
	@Test
	public void twoIntegerVariables() {
		ValueWrapper wrapper=new ValueWrapper(Integer.valueOf(4));
		
		assertTrue(wrapper.numCompare(Integer.valueOf(3))>0);
	}
	
	@Test
	public void twoDoublesTest() {
		ValueWrapper wrapper=new ValueWrapper(Double.valueOf(4.9));
		
		assertTrue(wrapper.numCompare(Double.valueOf(5.1))<0);
	}
}
