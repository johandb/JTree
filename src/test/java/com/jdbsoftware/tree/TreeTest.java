package com.jdbsoftware.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jdbsoftware.tree.Tree;

public class TreeTest {

	@Test
	public void tesCreateTree() {
		Tree<String> tree = new Tree<String>();
		assertNotNull(tree);
	}
	
	@Test
	public void testTreeSize() {
		Tree<String> tree = new Tree<String>();
		tree.add("A");
		assertTrue(tree.getSize() > 0);
	}
	
	@Test
	public void testFindNode() {
		Tree<String> root = new Tree<String>();
		root.add("A");
		Tree<String> nodeB = root.add("B");
		root.add("C");
		Tree<String> f = root.find("B");
		assertNotNull(f);
		
		Tree<String> nodeB1 = nodeB.add("B1");
		nodeB1.add("B1-1");
		
		Tree<String> f1 = root.find("B1");
		assertNotNull(f1);
	}
		
	@Test
	public void testNodeNotFound() {
		Tree<String> root = new Tree<String>();
		root.add("A");
		root.add("B");
		root.add("C");
		Tree<String> f = root.find("D");
		assertNull(f);
	}

	@Test
	public void testDeleteNode() {
		Tree<String> root = new Tree<String>();
		root.add("A");
		root.add("B");
		root.add("C");
		// check node B is there
		Tree<String> f = root.find("B");
		assertNotNull(f);
		
		// delete node
		root.delete("B");
		f = root.find("B");
		assertNull(f);
	}
	
	@Test 
	public void testClearTree() {
		Tree<String> root = new Tree<String>();
		root.add("A");
		root.add("B");
		root.add("C");
		root.clear();
		assertTrue(root.isEmpty());
		assertTrue(root.getSize() == 0);
	}
	
	@Test
	public void testToString() {
		Tree<String> root = new Tree<String>();
		root.add("A");
		Tree<String> nodeB = root.add("B");
		root.add("C");
		Tree<String> f = root.find("B");
		assertNotNull(f);
		
		Tree<String> nodeB1 = nodeB.add("B1");
		nodeB1.add("B1-1");
		String s = root.toString();
		System.out.println(s);
		assertFalse(s.isEmpty());
	}
}
