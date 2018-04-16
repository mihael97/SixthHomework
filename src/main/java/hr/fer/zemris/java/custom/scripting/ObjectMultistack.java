package hr.fer.zemris.java.custom.scripting;

import java.util.Objects;
import java.util.TreeMap;

import hr.fer.zemris.java.custom.scripting.exceptions.ObjectMultistackException;

/**
 * Stack implementation. We can store more stacks where every stack have unique
 * key(String)
 * 
 * @author Mihael
 *
 */
public class ObjectMultistack {

	/**
	 * Map which contains String as key and linked-list stack as value
	 */
	private TreeMap<String, MultistackEntry> keyMap;

	/**
	 * Public constructor for initialization
	 */
	public ObjectMultistack() {
		keyMap = new TreeMap<>();
	}

	/**
	 * Method puts new {@link MultistackEntry} with {@link ValueWrapper} as value to
	 * top of stack
	 * 
	 * @param name
	 *            - key
	 * @param valueWrapper
	 *            - value we want to store
	 * @throws NullPointerException
	 *             - if value is null
	 * 
	 */
	public void push(String name, ValueWrapper valueWrapper) {

		Objects.requireNonNull(valueWrapper);

		if (keyMap.containsKey(name)) {
			keyMap.replace(name, new MultistackEntry(valueWrapper, keyMap.get(name)));
		} else {
			keyMap.put(name, new MultistackEntry(valueWrapper, null));
		}
	}

	/**
	 * Method returns first element from stack and deletes it form top
	 * 
	 * @param name
	 *            - key
	 * @return {@link ValueWrapper} as value of first stack element
	 */
	public ValueWrapper pop(String name) {
		MultistackEntry entry = checkIfExists(name);

		keyMap.replace(name, entry.next);
		return entry.getValue();
	}

	/**
	 * Method return first element from top of stack
	 * 
	 * @param name
	 *            - key
	 * @return {@link ValueWrapper} as value of first stack element
	 */
	public ValueWrapper peek(String name) {
		return checkIfExists(name).getValue();
	}

	/**
	 * Method checks if stack exists for specific key
	 * 
	 * @param name
	 *            -key
	 * @return {@link MultistackEntry} if exists
	 * 
	 * @throws ObjectMultistackException
	 *             - if stack is empty of key doesn't exist
	 */
	private MultistackEntry checkIfExists(String name) {
		MultistackEntry entry = keyMap.get(name);

		if (entry == null) {
			throw new ObjectMultistackException("Stack is empty of key doesn't exist!");
		}

		return entry;
	}

	/**
	 * Checks if stack for specific key is empty
	 * 
	 * @param name
	 *            - key
	 * @return true if stack if empty(or key doesn't exist),otherwise false
	 */
	public boolean isEmpty(String name) {
		return keyMap.get(name) == null;
	}

	/**
	 * Private structure for representing stack node
	 * 
	 * @author Mihael
	 *
	 */
	private static class MultistackEntry {
		/**
		 * Value stored in node
		 */
		ValueWrapper value;
		/**
		 * Reference to next node
		 */
		MultistackEntry next;

		/**
		 * Public constructor for node initialization
		 * 
		 * @param value
		 *            - value we want to store
		 * @param next
		 *            - next node
		 */
		public MultistackEntry(ValueWrapper value, MultistackEntry next) {
			this.value = value;
			this.next = next;
		}

		/**
		 * Method returns node's value
		 * 
		 * @return value {@link ValueWrapper}
		 */
		public ValueWrapper getValue() {
			return value;
		}

		/**
		 * Method returns node's next element
		 * 
		 * @return next element
		 */
		@SuppressWarnings("unused")
		public MultistackEntry getNext() {
			return next;
		}

	}
}
