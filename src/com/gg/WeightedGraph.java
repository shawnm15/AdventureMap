package com.gg;

import java.util.LinkedList;

/**
 * A weighted graph structure where the vertices are generic objects instead of simple integer values
 *
 * @author Victor Velechovsky
 * @version 1.0
**/
public class WeightedGraph <T> {
	
	//Handles uniquely mapping objects to integer values (indices) and vice-versa
	private IndexMap<T> iMap;

	//Adjacency lists
	private LinkedList<LinkedList<DirectedEdge>> adj;
	
	
	/**
	 * Create an directed weighted graph
	**/
	public WeightedGraph() {
		
		iMap = new IndexMap<>();
		adj = new LinkedList<LinkedList<DirectedEdge>>();
		
	}
	
	/**
	 * Add a vertex object
	 *
	 * @param c - vertex object
	**/
	public void addObject (T c) {
		
		iMap.add(c);
		int i = iMap.getIndex(c);
		adj.add(i, new LinkedList<DirectedEdge>());
		
	}
	
	/**
	 * add an edge between two vertices
	 *
	 * @param c1 - first vertex
	 * @param c2 - second vertex
	 * @param weight - weight of edge connecting the vertices
	**/
	public void addEdge(T c1, T c2, double weight) {
		
		int i1 = iMap.getIndex(c1);
		int i2 = iMap.getIndex(c2);
		
		LinkedList<DirectedEdge> adj1 = adj.get(i1);
		
		adj1.add(new DirectedEdge(i1, i2, weight));
		
	}
	
	/**
	 * Get the list of all vertices adjacent to a given vertex
	 *
	 * @param c - Vertex in question
	 * @return - list of all adjacent vertex objects
	**/
	public LinkedList<DirectedEdge> adjacentTo(T c) {
		
		int i = iMap.getIndex(c);
		
		return adj.get(i);
		
	}
	
	/**
	 * Returns an iterable list of all edges in the graph
	 *
	 * @return Iterable list of DirectedEdge objects representing all edges in the graph
	**/
	public Iterable<DirectedEdge> edges() {
		
		LinkedList<DirectedEdge> list = new LinkedList<>();
		
		for (int v = 0; v < adj.size(); v++) {
			for (DirectedEdge e : adjacentTo(atIndex(v))) {
				list.add(e);
			}
		}
		
		return list;
		
	}
	
	/**
	 * Number of vertices (objects) in graph
	 *
	 * @return - number of vertices (objects) in graph
	**/
	public int V() { return adj.size(); }
	
	/**
	 * Return the object at the given int value
	 *
	 * @param i - index value of object
	 * @return - object mapped to i
	**/
	public T atIndex(int i) {
		return iMap.getElement(i);
	}
	
	/**
	 * Return the int of a given object
	 *
	 * @param c - object reference
	 * @return - int value mapped to object c
	**/
	public int getIndex(T c) {
		return iMap.getIndex(c);
	}
	
}
