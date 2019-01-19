package com.gg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains functions to read and write from the data files
**/
public class IO {

    /**
	 * Get a list of all City objects, based on connectedCities.txt
	 * 
	 * @return List of all cities
	 */
	public static LinkedList<City> getCities() {
		
		LinkedList<City> cities = new LinkedList<City>();

		try {
			Scanner scanner = new Scanner(new File("cities_50.csv"));
			
			scanner.nextLine();
			
			while (scanner.hasNextLine()) {
				
				String [] next = scanner.nextLine().split(",");
				
				City c = new City(next [0], next[1], Double.parseDouble(next [2]), Double.parseDouble(next [3]), Integer.parseInt(next [4]));

				cities.add(c);
				
			}
			
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cities;
		
	}
	
    /**
	 * Add city connections to the weighted graph
	 * 
	 * @param G - Weighted DiGraph of cities
	 */
	public static void addWeightedCityConnections (WeightedGraph<City> G) {

		for (int i = 0; i < G.V(); i++) {
			City c = G.atIndex(i);
			
			for (int j = 0; j < G.V(); j++) {
				City k = G.atIndex(j);
				
				double dist = TripPlanner.getDistanceBetweenCities(c, k);
				
				if (c != k && dist <= 500) {
					G.addEdge(c, k, dist);
					G.addEdge(k, c, dist);
				}
			}
		}
		
	}

}
