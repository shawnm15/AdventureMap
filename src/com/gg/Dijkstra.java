package com.gg;

/**
 * Dijkstra's Shorest Path algorithm, used to find the shortest path between two cities
 * by using fuel costs as the edge weight between two cities
 * Dapated from the Algorithms Textbook (Sedgewick)
 *
 * @author Victor Velechovsky, Shawn Malik, Amandeep Panesar, Danish Nadeem, Taha Mian
 * @version 1.0
**/
public class Dijkstra {
	
	private double[] distTo;
	private DirectedEdge[] edgeTo;
	private IndexMinPQ<Double> pq;
	
	/**
	 * Create a Dijkstra object
	 *
	 * @param G - A weighted graph of cities, which edge weights representing fuel costs
	 * @param s - Source (initial) city
	**/
	public Dijkstra(WeightedGraph<City> G, int s) {

		int N = G.V();
		
		//Dijkstra algorithm cannot handle negative edge weights
		for (DirectedEdge e : G.edges()) {
			if (e.weight() < 0) System.out.println("Negative edge weight!");
		}
		
		distTo = new double[N];
		edgeTo = new DirectedEdge[N];
		
		for (int v = 0; v < N; v++) {
			distTo[v] = Double.POSITIVE_INFINITY;
		}
		distTo[s] = 0.0;
		
		pq = new IndexMinPQ<Double>(N);
		pq.insert(s,  distTo[s]);
		while (! pq.isEmpty()) {
			int v = pq.delMin();
			
			//Relax every adjacent edge
			for (DirectedEdge e : G.adjacentTo(G.atIndex(v)))
				relax(e);
		}
		
	}
	
	public double[] getDistTo() { return distTo; }

	//Relax a given edge	
	private void relax(DirectedEdge e) {
		
		int v = e.from();
		int w = e.to();
		
		if (distTo[w] > distTo[v] + e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
			if (pq.contains(w)) pq.decreaseKey(w,  distTo[w]);
			else pq.insert(w,  distTo[w]);
		}
		
	}

	/**
	 * Return the numbe rof edges in the graph
	 *
	 * @return - number of vertices
	**/
	public int V() { return edgeTo.length; }
	
	/**
	 * Checks if there is a path from the source to the desination v
	 *
	 * @param v - index of destination city
	 * @return - true if there is a path from s (source) to v (destination)
	**/
	public boolean hasPathTo(int v) {
		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	
	/**
	 * Returns the shortest path from s (source) to v (destination)
	 *
	 * @return - Iterable list of directed edges representing the shortest path from s to v
	**/
	public Queue<DirectedEdge> pathTo(int v) {
		
		if (!hasPathTo(v)) return null;
		
		Queue<DirectedEdge> path = new Queue<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			path.enqueue(e);
		}
		
		return path;
	}

}
