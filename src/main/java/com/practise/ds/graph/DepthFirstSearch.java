package com.practise.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {
	
	private LinkedList<Integer>[] adjLists;
	private boolean[] visited;
	
	@SuppressWarnings("unchecked")
	public DepthFirstSearch(int numOfVertices){
		this.visited = new boolean[numOfVertices];
		this.adjLists = new LinkedList[numOfVertices];
		
		for(int i = 0; i < numOfVertices; i++) {
			adjLists[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src, int dest) {
		this.adjLists[src].add(dest);
	}
	
	public void searchRuccursive(int vertex) {
		visited[vertex] = true;
	    System.out.print(vertex + " ");

	    Iterator<Integer> ite = adjLists[vertex].listIterator();
	    while (ite.hasNext()) {
	      int adj = ite.next();
	      if (!visited[adj])
	    	  searchRuccursive(adj);
	    }
	}
	
	public void searchIterative(int vertex) {

		Stack<Integer> stack = new Stack<>();

		// push root node to the stack
		stack.push(vertex);
		int a = 0;

		while (!stack.empty()) {
			vertex = stack.peek(); // extract the top element of the stack
			stack.pop(); // remove the top element from the stack

			if (visited[vertex] == false) {
				System.out.print(vertex + " ");
				visited[vertex] = true;
			}

			// iterate through the linked list and then propagate to the next few nodes
			for (int i = 0; i < adjLists[vertex].size(); i++) {
				a = adjLists[vertex].get(i);

				// only push those nodes to the stack which aren't in it already
				if (!visited[a]) {
					// push the top element to the stack
					stack.push(a);
				}
			}
		}
	}

	public static void main(String args[]) {
		DepthFirstSearch g = new DepthFirstSearch(6);

		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 3);

	    System.out.println("Following is Depth First Traversal");

	    g.searchRuccursive(0);
	    
	    g = new DepthFirstSearch(6);

		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 3);
	    System.out.println("\n\nFollowing is Depth First Traversal in iterative way :");
	    g.searchIterative(0);
	  }
}
