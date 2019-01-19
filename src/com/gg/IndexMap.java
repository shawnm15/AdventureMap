package com.gg;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class used to map arbitrary objects to index values back and foth, so that vertices in a graph can represent
 * objects of any data type
 *
 * @param T - object type of the vertices 
 * 
 * @author Victor Velechovsky, Shawn Malik, Amandeep Panesar, Danish Nadeem, Taha Mian
 * @version 1.0
**/
public class IndexMap<T> {
	
	private ArrayList<T> elements = new ArrayList<>(); //List of elements
	private HashMap<T, Integer> iMap = new HashMap<>(); //Maps elements to and from integer values
	
	/**
	 * Add an object element and assign it an integer value
	 *
	 * @param T - object to add
	**/
	public int add(T element) {
		
		int i = elements.size(); //Increment the current value by one and assign it to the object
		elements.add(element);
		iMap.put(element, i);
		
		return i;
		
	}
	
	/**
	 * Given a particular element object, get the corresponding integer value
	 *
	 * @param T - object reference
	 * @return - integer value corresponding to the object T
	**/
	public int getIndex(T element) {
		Integer i = iMap.get(element);
		
		return i == null ? -1 : i;
	}
	
	/**
	 * Returns the object corresponding to integer value i
	 * 
	 * @param i - integer value
	 * @return - object pertaining to the integer value i
	**/
	public T getElement(int i) {
		return elements.get(i);
	}
	
	/**
	 * @return a list of all elements in the map
	**/
	public ArrayList<T> getElements() {
		return elements;
	}

}
