package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import arrayCircularDeque.ArrayCircularDeque;
import interfaces.Deque;

public class DequeRemoveLastTest {

	// addLast y removeFirst implementaci�n libro

	private Deque<String> dq;

	@Before
	public void setUp() throws Exception {
		dq = new ArrayCircularDeque<String>(6);
	}

	// deque primer elemento
	@Test
	public void testDeque1() {
		dq.addLast("Ana");
		assertEquals(dq.removeLast(), "Ana");
		assertTrue(dq.isEmpty());
	}

	// deque varios elementos
	@Test
	public void testDeque2() {
		dq.addLast("Ana");
		dq.addLast("Juan");
		assertEquals(dq.removeLast(), "Juan");
		assertEquals(dq.removeLast(), "Ana");
		assertTrue(dq.isEmpty());
	}

	// deque sin elementos
	@Test
	public void testDeque3() {
		assertNull(dq.removeFirst());
	}

	// deque arreglo circular
	@Test
	public void testDeque4() {		
		dq.addLast("Pedro");
		dq.addLast("Juan");
		dq.addLast("Ana");
		dq.addLast("Pablo");
		dq.addLast("Maria");	
		dq.addLast("Analia");
		dq.removeFirst();
		dq.addLast("Pedro");		
		assertEquals(dq.removeLast(), "Pedro");
		assertEquals(dq.removeLast(), "Analia");
		assertEquals(dq.size(), 4);		
	}

}