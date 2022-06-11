package com.practise.ds.tree;

import org.junit.Assert;
import org.junit.Test;

import com.practise.ds.tree.BinaryTree.Node;


public class BinaryTreeTest {
	
	@Test
	public void testTreeTraversal() {
		BinaryTree tree = new BinaryTree();
		tree.setRoot(getRootNode());
		
		tree.initiateInOrderTraversal();
		Assert.assertEquals("5, 12, 7, 6, 1, 9", tree.toString());
		
		tree.initiatePreOrderTraversal();
		Assert.assertEquals("1, 12, 5, 6, 7, 9", tree.toString());
		
		tree.initiatePostOrderTraversal();
		Assert.assertEquals("5, 7, 6, 12, 9, 1", tree.toString());
	}
	
	@Test
	public void testIfFullBinaryTree() {
		BinaryTree tree = new BinaryTree();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		
		Assert.assertTrue(tree.isFullBinaryTree(root));
		Assert.assertFalse(tree.isFullBinaryTree(getRootNode()));
	}
	
	@Test
	public void testIfPerfectBinaryTree() {
		BinaryTree tree = new BinaryTree();
		Node root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
		
		Assert.assertFalse(tree.isPerfectBinaryTree(root));
		Assert.assertFalse(tree.isPerfectBinaryTree(getRootNode()));
		
		root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    
	    Assert.assertTrue(tree.isPerfectBinaryTree(root));
	}
	
	@Test
	public void testIfCompleteBinaryTree() {
		BinaryTree tree = new BinaryTree();
		Node root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
		
		Assert.assertTrue(tree.isCompleteBinaryTree(root));
		Assert.assertTrue(tree.isCompleteBinaryTree(getRootNode()));
		
		root.right.left = null;
	    root.right.right = new Node(7);
	    
	    Assert.assertFalse(tree.isCompleteBinaryTree(root));
	}
	
	@Test
	public void testBinaryTreeSearch() {
		BinaryTree tree = new BinaryTree();
	    tree.setRoot(getBinaryTree());
		
	    tree.initiateInOrderTraversal();
		Assert.assertEquals("1, 3, 4, 6, 7, 8, 9, 10, 14", tree.toString());
		
		Assert.assertTrue(tree.search(4));
		Assert.assertTrue(tree.search(9));
		Assert.assertTrue(tree.search(14));
		
		Assert.assertFalse(tree.search(5));
	}
	
	@Test
	public void testInsert() {
		BinaryTree tree = new BinaryTree();
	    tree.setRoot(getBinaryTree());
	    
	    tree.initiateInOrderTraversal();
		Assert.assertEquals("1, 3, 4, 6, 7, 8, 9, 10, 14", tree.toString());
	    
	    tree.insert(0);
	    tree.initiateInOrderTraversal();
		Assert.assertEquals("0, 1, 3, 4, 6, 7, 8, 9, 10, 14", tree.toString());
		
	    tree.insert(2);
	    tree.initiateInOrderTraversal();
		Assert.assertEquals("0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 14", tree.toString());
		
	    tree.insert(16);
	    tree.initiateInOrderTraversal();
		Assert.assertEquals("0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 14, 16", tree.toString());
		
	    tree.insert(11);
	    tree.initiateInOrderTraversal();
		Assert.assertEquals("0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 14, 16", tree.toString());
		
		Assert.assertTrue(tree.search(4));
		Assert.assertTrue(tree.search(9));
		Assert.assertTrue(tree.search(11));
		Assert.assertTrue(tree.search(16));
		
		Assert.assertFalse(tree.search(5));
	}
	
	@Test
	public void testDeletion() {
		BinaryTree tree = new BinaryTree();
		tree.setRoot(getBinaryTree());

		tree.insert(0);
		tree.insert(2);
		tree.insert(16);
		tree.insert(11);
		
		tree.initiateInOrderTraversal();
		Assert.assertEquals("0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 14, 16", tree.toString());

		// Case-I : The node to be deleted is the leaf node
		tree.delete(11);
		tree.initiateInOrderTraversal();
		Assert.assertEquals("0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 14, 16", tree.toString());

		// Case-II : The node to be deleted has a single child node
		tree.delete(0);
		tree.initiateInOrderTraversal();
		Assert.assertEquals("1, 2, 3, 4, 6, 7, 8, 9, 10, 14, 16", tree.toString());

		// Case-III : The node to be deleted has two children
		tree.delete(3);
		tree.initiateInOrderTraversal();
		Assert.assertEquals("1, 2, 4, 6, 7, 8, 9, 10, 14, 16", tree.toString());
	}
	
	private Node getBinaryTree() {
		Node root = new Node(8);
	    root.left = new Node(3);
	    root.right = new Node(10);
	    
	    root.left.left = new Node(1);
	    root.left.right = new Node(6);
	    root.left.right.left = new Node(4);
	    root.left.right.right = new Node(7);
	    
	    root.right.left = new Node(9);
	    root.right.right = new Node(14);
	    
	    return root;
	}
	
	private Node getRootNode() {
		Node root = new Node(1);
		root.right = new Node(9);

		Node left = new Node(12);
		left.left = new Node(5);
		left.right = new Node(6);
		left.right.left = new Node(7);

		root.left = left;
		
		return root;
	}

}
