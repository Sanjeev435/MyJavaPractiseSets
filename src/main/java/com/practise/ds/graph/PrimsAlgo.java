package com.practise.ds.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sanjeev Kumar
 * 
 *         <br/><br/>
 *         It falls under a class of algorithms called <b>greedy algorithms</b>
 *         that find the local optimum in the hopes of finding a global optimum.
 *         <br/><br/>
 * 
 *         We start from one vertex and keep adding edges with the lowest weight
 *         until we reach our goal. <br/>
 *         <br/>
 * 
 *         <b>The steps for implementing Prim's algorithm are as follows: 
 *         </b><br/><br/>
 *         
 *         <b>1.</b> Initialize the minimum spanning tree with a vertex chosen at
 *         random.<br/>
 *         <b>2.</b> Find all the edges that connect the tree to new vertices, find the
 *         minimum and add it to the tree. <br/>
 *         <b>3.</b> Keep repeating step-2 until we get a minimum spanning tree.
 *         <br/><br/>
 * 
 *         <b>Prim's Algorithm Complexity : </b> <br/>
 *         The time complexity of Prim's algorithm is <b>O(E log V)</b> where V is
 *         number of vertices. <br/>
 *         <br/>
 * 
 *         <b>Prim's Algorithm Application : </b><br/>
 *         <b>*</b> Laying cables of electrical wiring<br/>
 *         <b>*</b> In network designed<br/>
 *         <b>*</b> To make protocols in network cycles
 *
 */
public class PrimsAlgo {

	public List<String> primsAlgo(int[][] graphData) {
		int minVertexWeight = 0;
		int numOfVertex = graphData.length;
		List<String> mst = new ArrayList<>();

		// Create a array to track selected vertex selected will become true otherwise false
		boolean[] isSelected = new boolean[numOfVertex];

		// The number of edge in minimum spanning tree will be always less than (numOfVertex -1),
		// where numOfVertex is number of vertices in graph.
		int noOfEdges = numOfVertex - 1;

		// Choose 0th vertex and make it true
		isSelected[0] = true;


		int x = 0, y = 0;
		while (noOfEdges > 0) {

			// For every vertex in the set S, find the all adjacent vertices, calculate the
			// distance from the vertex selected at step 1.
			// If the vertex is already in the set S, discard it otherwise choose another
			// vertex nearest to selected vertex at step 1.
			minVertexWeight = 99999999;
			x = 0;	// row
			y = 0;	// column

			for (int i = 0; i < numOfVertex; i++) {
				if (isSelected[i]) {
					for (int j = 0; j < numOfVertex; j++) {
						if (!isSelected[j] && graphData[i][j] != 0 && graphData[i][j] < minVertexWeight) {
							minVertexWeight = graphData[i][j];
							x = i;
							y = j;
						}
					}
				}
			}
			mst.add("Weight between vertex " + x + " and " + y + " : " + minVertexWeight);

			isSelected[y] = true;
			noOfEdges--;
		}

		return mst;
	}

	public static void main(String[] args) {
		PrimsAlgo g = new PrimsAlgo();

		// create a 2d array of size 5x5 for adjacency matrix to represent graph
		int[][] G = { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
				{ 0, 42, 66, 31, 0 } };

		List<String> mst = g.primsAlgo(G);

		mst.forEach(s -> System.out.println(s));

	}
}
