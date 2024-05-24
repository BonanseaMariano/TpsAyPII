package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datastructures.LinkedBinaryTree;
import datastructures.Position;

class TestComplete {

	private LinkedBinaryTree<String> t;
	private Position<String> p, q, r, s, u, v, w, x, y, z;
	
	@BeforeEach
	void setUp() throws Exception {
		t = new LinkedBinaryTree<String>();	
	}

	@Test
	void testVacio() {
		assertTrue(t.complete());
	}

	@Test
	void testRaiz() {
		p = t.addRoot("A");
		assertTrue(t.complete());
	}

	@Test
	void testRI() {
		p = t.addRoot("A");
		q = t.addLeft(p, "B");
		assertTrue(t.complete());
	}
	
	@Test
	void testRID() {
		p = t.addRoot("A");
		q = t.addLeft(p, "B");
		r = t.addRight(p, "C");
		assertTrue(t.complete());
	}
	
	@Test
	void testRIDnnnD() {
		p = t.addRoot("A");
		q = t.addLeft(p, "B");
		r = t.addRight(p, "C");
		t.addRight(r, "D");
		assertFalse(t.complete());
	}
	
	@Test
	void testRIDnnID() {
		p = t.addRoot("A");
		q = t.addLeft(p, "B");
		r = t.addRight(p, "C");
		t.addRight(r, "D");
		t.addLeft(r, "E");
		assertFalse(t.complete());
	}
	
	@Test
	void testRIDnDID() {
		p = t.addRoot("A");
		q = t.addLeft(p, "B");
		r = t.addRight(p, "C");
		t.addRight(r, "D");
		t.addLeft(r, "E");
		t.addRight(q, "F");
		assertFalse(t.complete());
	}
	
	@Test
	void testRIDIDID() {
		p = t.addRoot("A");
		q = t.addLeft(p, "B");
		r = t.addRight(p, "C");
		t.addRight(r, "D");
		t.addLeft(r, "E");
		t.addRight(q, "F");
		t.addLeft(q, "G");
		assertTrue(t.complete());
	}
}
