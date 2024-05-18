/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import net.datastructures.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Mariano
 */
public class AbstractTreeTest {

    LinkedBinaryTree<String> tree = new LinkedBinaryTree<String>();
	LinkedBinaryTree<String> treeEmpty = new LinkedBinaryTree<String>();
	Position<String> p, q, r, s, t, u, v;

	@BeforeEach
	void setUp() throws Exception {

		String d[] = { "A", "B", "C", "D", "E", "F", "G" };

		p = tree.addRoot(d[0]);
		q = tree.addLeft(p, d[1]);
		r = tree.addRight(p, d[2]);
		s = tree.addLeft(q, d[3]);
		t = tree.addRight(q, d[4]);
		u = tree.addLeft(r, d[5]);
		v = tree.addRight(r, d[6]);
	}

	@Test
	void testAncestor() {
		List<Position<String>> list = new ArrayList<Position<String>>();
		assertIterableEquals(tree.ancestor(p), list);

		list.add(0, p);
		assertIterableEquals(tree.ancestor(r), list);

		list.add(0, q);
		assertIterableEquals(tree.ancestor(s), list);
	}

	@Test
	void testSearch() {
		assertEquals(tree.search("A"), p);
		assertEquals(tree.search("D"), s);
		assertNull(tree.search("Z"));
		assertNull(treeEmpty.search("Z"));
	}

	@Test
	void testSearchAll() {
		assertTrue(treeEmpty.searchAll("A").isEmpty());

		assertTrue(tree.searchAll("Z").isEmpty());

		assertTrue(tree.searchAll("A").contains(p));

		Position<String> z = tree.addRight(s, "A");
		List<Position<String>> resultado = tree.searchAll("A");
		assertTrue(resultado.contains(p));
		assertTrue(resultado.contains(z));
	}

	@Test
	void testDuplicate() {
		assertFalse(tree.duplicate());

		tree.addRight(s, "A");
		assertTrue(tree.duplicate());

		assertFalse(treeEmpty.duplicate());
	}

	@Test
	void testlistChildren() {
		List<Position<String>> hijos = new ArrayList<Position<String>>();
		for (Position<String> pt : treeEmpty.listChildren())
			hijos.add(pt);
		assertTrue(hijos.isEmpty());

		List<Position<String>> list = new ArrayList<Position<String>>();
		assertIterableEquals(treeEmpty.listChildren(), list);
		for (Position<String> pt : tree.listChildren())
			hijos.add(pt);
		List<Position<String>> resultado = new ArrayList<Position<String>>();
		resultado.add(v);
		resultado.add(t);
		resultado.add(s);
		resultado.add(u);
		assertTrue(hijos.containsAll(resultado));
	}

	@Test
	void testlistGreaterAncestor() {
		List<Position<String>> ancestros = new ArrayList<Position<String>>();
		for (Position<String> pt : treeEmpty.listChildren())
			ancestros.add(pt);
		assertTrue(ancestros.isEmpty());

		Position<String> z = tree.addRight(s, "Z");
		for (Position<String> pt : tree.listGreaterAncestor())
			ancestros.add(pt);
		List<Position<String>> resultado = new ArrayList<Position<String>>();
		resultado.add(z);
		resultado.add(s);
		resultado.add(q);
		resultado.add(p);
		assertIterableEquals(ancestros, resultado);
	}

	@Test
	void testlistDepth() {
		List<String> profundidades = new ArrayList<String>();
		for (String pt : treeEmpty.listDepth(0))
			profundidades.add(pt);
		assertTrue(profundidades.isEmpty());

		for (String pt : tree.listDepth(5))
			profundidades.add(pt);
		assertTrue(profundidades.isEmpty());

		for (String pt : tree.listDepth(2))
			profundidades.add(pt);

		List<String> resultado = new ArrayList<String>();
		resultado.add(v.getElement());
		resultado.add(t.getElement());
		resultado.add(s.getElement());
		resultado.add(u.getElement());
		assertTrue(profundidades.containsAll(resultado));
						
	}
}
