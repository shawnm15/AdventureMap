package com.gg;

/**
 * An object that represets a weighted, directed edge in a WeightedGraph object
 *
 * @author Victor Velechovsky, Shawn Malik, Amandeep Panesar, Danish Nadeem, Taha Mian
 * @version 1.0
**/
public class DirectedEdge {
	
	private final int v; //Start vertex
	private final int w; //End vertex
	private final double weight; //Weight
	
	/**
      * Create an edge between two vertices with a given weight
      * 
      * @param v - Start vertex
      * @param w - End vertex
      * @param weight - Edge weight
	**/
	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	/**
	 * Represent a directed edge in human readable form
	 * Format:
	 * [Start] -> [End]
	 */
	public String toString() {
		return v + " -> " + w + " " + String.format("%5.2f",  weight);
	}
	
	//-----------GETTER AND SETTER METHODS------//

	/**
	 * @return - Start vertex
	**/
	public int from() { return v; }
	
	/**
	 * @return - End vertex
	**/
	public int to() { return w; }
	
	public double weight() { return weight; }

}
