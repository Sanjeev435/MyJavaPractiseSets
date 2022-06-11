package com.practise.ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTree {

	private Node root;
	private List<Integer> treeData;

	public BinaryTree() {
		this.root = null;
		this.treeData = new ArrayList<>();
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public boolean search(int data) {
		Node node = root;
		
		while(node != null) {
			if(data == node.data) {
				return true;
			}else if(data < node.data) {
				node = node.left;
			}else {
				node = node.right;
			}
		}
		
		return false;
	}
	
	public void insert(int data) {
		Node node = root;
		
		while(node != null) {
			if(data > node.data) {
				if(node.right == null) {
					node.right = new Node(data);
					break;
				}else {
					node = node.right;
				}
			}else {
				if(node.left == null) {
					node.left = new Node(data);
					break;
				}else {
					node = node.left;
				}
			}
		}
	}
	
	/**
	 * Delete a data from binary tree
	 * @param data
	 */
	public void delete(int data) {
		deleteKey(root, data);
	}
	
	private Node deleteKey(Node node, int data) {
		// Return if the tree is empty
		if (node == null) {
			return node;
		}

		// Find the node to be deleted
		if (data > node.data) {
			node.right = deleteKey(node.right, data);
		} else if (data < node.data) {
			node.left = deleteKey(node.left, data);
		} else {
			// If the node is with only one child or no child
			if (node.right == null) {
				return node.left;
			} else if (node.left == null) {
				return node.right;
			}

			// If the node has two children place the in-order successor in position of the
			// node to be deleted
			node.data = minValue(node.right);

			// Delete the in-order successor
			node.right = deleteKey(node.right, node.data);
		}

		return node;
	}
	
	/**
	 * Find the in-order successor
	 * 
	 * @param node
	 * @return minValue
	 */
	private int minValue(Node node) {
		int minValue = node.data;
		while (node.left != null) {
			minValue = node.left.data;
			node = node.left;
		}
		return minValue;
	}

	/**
	 * In-Order traversal rule : Left subtree -> root -> right subtree
	 */
	public void initiateInOrderTraversal() {
		this.treeData = new ArrayList<>();
		inOrderTraversal(root);
	}
	
	private void inOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		
		inOrderTraversal(node.left);
		treeData.add(node.data);
		inOrderTraversal(node.right);
		
	}
	
	/**
	 * Pre-Order traversal rule : root -> Left subtree -> right subtree
	 */
	public void initiatePreOrderTraversal() {
		this.treeData = new ArrayList<>();
		preOrderTraversal(root);
	}
	
	private void preOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		treeData.add(node.data);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);

	}
	
	/**
	 * Post-Order traversal rule : Left subtree -> right subtree -> root
	 */
	public void initiatePostOrderTraversal() {
		this.treeData = new ArrayList<>();
		postOrderTraversal(root);
	}

	public void postOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		treeData.add(node.data);
	}
	
	/**
	 * Check for Full Binary Tree
	 * 
	 * <pre>
	 * A full binary tree node will be null in only two cases :
	 * 1. Either a node is null
	 * 2. Both the leaves are null
	 * </pre>
	 * 
	 * @param node : root node
	 * @return boolean
	 */
	public boolean isFullBinaryTree(Node node) {
		// Checking tree emptiness
		if (node == null) {
			return true;
		}

		// Checking the children
		if (node.left == null && node.right == null) {
			return true;
		}

		if (node.left != null & node.right != null) {
			return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
		}

		return false;
	}

	public boolean isPerfectBinaryTree(Node node) {
		return isPefectBinary(node, getDepth(node), 0);
	}
	
	private int getDepth(Node node) {
		int count = 0;

		while (node != null) {
			count++;
			node = node.left;
		}
		return count;
	}

	private boolean isPefectBinary(Node node, int depth, int level) {
		// Check if the tree is empty
		if (node == null) {
			return true;
		}

		// If for children
		if (node.left == null && node.right == null) {
			return depth == (level + 1);
		}

		// If either of the node is not null, perfect tree rules is violated
		if (node.left == null || node.right == null) {
			return false;
		}

		return isPefectBinary(node.right, depth, level + 1) && isPefectBinary(node.left, depth, level + 1);
	}
	
	/**
	 * A complete binary tree is just like a full binary tree, but with two major
	 * differences <br/>
	 * <br/>
	 * 1. All the leaf elements must lean towards the left.<br/>
	 * 2. The last leaf element might not have a right sibling i.e. a complete
	 * binary tree doesn't have to be a full binary tree.<br/>
	 * <br/>
	 * 
	 * @param root
	 * @return
	 */
	public boolean isCompleteBinaryTree(Node root) {
		return checkCompleteBinaryTree(root, countNumNodes(root), 0);
	}

	/**
	 * Count the number of nodes
	 * 
	 * @param root
	 * @return
	 */
	private int countNumNodes(Node root) {
		if (root == null) {
			return 0;
		}

		// 1 is additionally added for the root node
		return (1 + countNumNodes(root.left) + countNumNodes(root.right));
	}

	public boolean checkCompleteBinaryTree(Node node, int numOfNodes, int index) {
		// Check if the tree is empty
		if (root == null) {
			return true;
		}

		if (index >= numOfNodes) {
			return false;
		}

		return (checkCompleteBinaryTree(root.left, numOfNodes, 2 * index + 1)
				&& checkCompleteBinaryTree(root.right, numOfNodes, 2 * index + 2));
	}

	@Override
	public String toString() {
		return treeData.stream()
				.map(i -> i.toString())
				.collect(Collectors.joining(", "));
	}

	
	
	/**
	 * Node Class to hold references and data
	 * 
	 * @author Sanjeev Kumar
	 *
	 */
	public static class Node {
		Node left;
		Node right;
		int data;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		Node root = new Node(1);
		root.right = new Node(9);

		Node left = new Node(12);
		left.left = new Node(5);
		left.right = new Node(6);

		root.left = left;

		tree.setRoot(root);
		
		
		tree.initiateInOrderTraversal();
		System.out.println(tree.toString());	// 5, 12, 6, 1, 9
		
		tree.initiatePreOrderTraversal();
		System.out.println(tree.toString()); // 1, 12, 5, 6, 9
		
		tree.initiatePostOrderTraversal();
		System.out.println(tree.toString()); //5, 6, 12, 9, 1
	}

}
