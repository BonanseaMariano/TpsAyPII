package test;

import java.util.List;

import datastructures.Entry;
import datastructures.LinkedBinaryTree;
import datastructures.Position;

public class TestBranchMap<E> {

	public static void main(String[] args) {

		LinkedBinaryTree<String> t = new LinkedBinaryTree<String>();
		Position<String> p, q, r, s, u;

		p = t.addRoot("F");

		q = t.addLeft(p, "B");
		t.addLeft(q, "A");
		s = t.addRight(q, "D");
		t.addLeft(s, "C");
		t.addRight(s, "E");

		r = t.addRight(p, "G");
		u = t.addRight(r, "I");
		t.addLeft(u, "H");

		System.out.print("Externos: ");
		for (Position<String> e : t.externals())
			System.out.print(e.getElement()+" ");
		
		System.out.println("\n");
		
		for (Entry<Position<String>, List<Position<String>>> m : t.branchMap().entrySet()) {
			System.out.print(m.getKey().getElement() + ": ");
			for (Position<String> d : m.getValue())
				System.out.print(d.getElement() + " ");
			System.out.println();
		}
	}
}
