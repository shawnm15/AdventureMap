package com.gg;

/**
 * Wrapper for the result of a 'trip plan'
**/
public class Result {
	
	public Stack<DirectedEdge> path; //Iterable list of directed edges, each one connecting two cities
	public int interestFactor; //How interesting the total trip is
	public WeightedGraph<City> highways; //A graph connecting all of the cities
	
}