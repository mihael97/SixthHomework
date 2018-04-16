package hr.fer.zemris.java.custom.scripting;

import static org.junit.Assert.*;

import org.junit.Test;

import hr.fer.zemris.java.custom.scripting.exceptions.ObjectMultistackException;

@SuppressWarnings("javadoc")
public class ObjectMultistackTest {

	@Test
	public void put() {
		ObjectMultistack stack = new ObjectMultistack();

		stack.push("Ime", new ValueWrapper(Double.valueOf(5.2)));

		ValueWrapper wrapper = stack.peek("Ime");
		assertTrue(wrapper.getValue() instanceof Double);
		assertEquals(Double.valueOf(5.2), (Double) wrapper.getValue());
		assertTrue(stack.isEmpty("Name"));
	}
	
	@Test
	public void peek() {
		ObjectMultistack stack = new ObjectMultistack();

		stack.push("Ime", new ValueWrapper(Double.valueOf(5.2)));

		stack.peek("Ime");
		assertFalse(stack.isEmpty("Ime"));
	}
	
	@Test
	public void pop() {
		ObjectMultistack stack = new ObjectMultistack();

		stack.push("Ime", new ValueWrapper(Double.valueOf(5.2)));

		stack.pop("Ime");
		assertTrue(stack.isEmpty("Ime"));
	}

	@Test
	public void nullValue() {
		ObjectMultistack stack = new ObjectMultistack();

		stack.push("Ime", new ValueWrapper(null));

		assertNull(stack.peek("Ime").getValue());
		assertFalse(stack.isEmpty("Ime"));
	}
	
	@Test(expected=ObjectMultistackException.class)
	public void invalidKey() {
		ObjectMultistack stack = new ObjectMultistack();

		stack.push("Ime", new ValueWrapper(null));

		stack.peek("Janko").getValue();
	}
	
	@Test
	public void twoValuesWithSameKey() {
		ObjectMultistack stack = new ObjectMultistack();

		stack.push("Ime", new ValueWrapper(null));
		stack.push("Ime", new ValueWrapper(Integer.valueOf(1)));
		
		assertEquals(Integer.valueOf(1),stack.pop("Ime").getValue());
		assertNull(stack.pop("Ime").getValue());
		assertTrue(stack.isEmpty("Ime"));
	}
}
