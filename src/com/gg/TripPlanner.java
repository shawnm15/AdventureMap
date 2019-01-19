package com.gg;

import java.io.File;
import java.util.LinkedList;

/**
 * Functions for determining the optimal trip path to take
 * 
 * @author Victor Velechovsky, Shawn Malik, Amandeep Panesar, Danish Nadeem, Taha Mian
 * @version 1.0
**/
public class TripPlanner {

	static LinkedList<City> cities;
	
	/**
	 * Determines the optimal trip
     *
     * @param budget the budget of the fuel in dollars
     * @param fuelEconomy the fuel economy of the selected car in MPG
     * @param startCity the string name of the start city
     *
     * @return the trip wrapped in a Result object
	**/
	public static Result getTrip(int budget, int fuelEconomy, String startCity) {

		cities = IO.getCities();
		
		City start = lookupCity(startCity);
		
		WeightedGraph<City> highways = new WeightedGraph<>(); //Graph that likns all the cities together
		
		for (City c : cities) //Add the cities as vertices to the graph
			highways.addObject(c);
		
		IO.addWeightedCityConnections(highways);
		
		Dijkstra dijkstra = new Dijkstra(highways, highways.getIndex(start));
		
		double [] distTo = dijkstra.getDistTo();
		
		double maxDistance = getDistance(budget,fuelEconomy); //GOTTA GET THIS FROM A FUNCTION
		LinkedList<Queue<DirectedEdge>> acceptablePaths = new LinkedList<>();
		
		for (City c : cities) { //Perform Dijkstra on all the nodes
			
			int currentIndex = highways.getIndex(c);

			Queue<DirectedEdge> currentPath = dijkstra.pathTo(currentIndex); //Add the current shortest path to a list
			
			if (distTo[currentIndex] <= maxDistance) {
				acceptablePaths.add(currentPath);
			}
			
		}
		
		int maxInterestFactor = 0;
		Queue<DirectedEdge> maxPath = acceptablePaths.get(0);
		
		//Determine which path is the best (has the highest interest factor)
		for (Queue<DirectedEdge> path : acceptablePaths) {
			
			int currentInterestFactor = interestFactor(path, highways);
			
			if (currentInterestFactor > maxInterestFactor) {
				System.out.println("Replace");
				maxPath = path;
				maxInterestFactor = interestFactor(path, highways);
			}

		}
		
		Stack<DirectedEdge> maxPathStack = new Stack<>();
		
		for (DirectedEdge d : maxPath)
			maxPathStack.push(d);
		
		//Wrap the results in a Result object and return it
		Result result = new Result();
		result.path = maxPathStack;
		result.interestFactor = maxInterestFactor;
		result.highways = highways;
		
		return result;
		
	}
	
	/**
	 * Determine the maximum distance that can be travelled based on a budget and fuel economy
	 * 
	 * @param budget maximum fuel budget in dollars
	 * @param fuelEconomy combined fuel economy of the vehicle
	 * @return maximum distance in Kilometers
	 */
	public static double getDistance(int budget, int fuelEconomy) {
		
		double kmPerLitre = 175.54/fuelEconomy;
		int budgetMult = 1/budget;
		double fuelGas = 0.92/1;
		double dist = kmPerLitre*budget*fuelGas;
		return dist;
		
	}
	
	/**
	 * Determine the interest factor of a given trip
	 * 
	 * @param path A list of directed edges, representing a path
	 * @param highways Graph of cities and highway connections
	 * @return interest factor, value within [0..100]
	 */
	public static int interestFactor(Queue<DirectedEdge> path, WeightedGraph<City> highways) {
		
		int total = 0;
		
		for (DirectedEdge d : path) {
			City c = highways.atIndex(d.to());
			
			total += c.interestFactor;
		}
		
		return total;
		
	}

	public static City lookupCity(String name) {
		
		for (City c : cities)
			if (c.getName().equalsIgnoreCase(name)) return c;
		
		return null;
	}
	
	//Test
	public static void main(String [] args) {
		
		int budget = 400;
		int fuelEconomy = 26;
		String startCity = "New York City";
		
		getTrip(budget, fuelEconomy, startCity);
		
	}
	
	/**
	 * Calculate the aerial distance between two cities
	 * 
	 * @param c1 - start city
	 * @param c2 - end city
	 * @return aerial distance between two cities
	 */
	public static double getDistanceBetweenCities(City c1, City c2) {
		
		if (c1.getLat() == -1 || c1.getLng() == 1 || c2.getLat() == -1 || c1.getLng() == -1) {
			System.out.println("getDistanceBetweenCities: missing coordinates");
			return -1;
		}
		
		return aerial(c1.getLat(), c1.getLng(), c2.getLat(), c2.getLng());
		
	}
	
	//Calculate aerial distance
	private static double aerial(double lat1, double lng1, double lat2, double lng2) {
		
		//Radius of Earth (miles)
		double R = 3959;
		
		double phi1 = Math.toRadians(lat1);
		double lam1 = Math.toRadians(lng1);
		double phi2 = Math.toRadians(lat2);
		double lam2 = Math.toRadians(lng2);
		
		double dPhi = Math.abs(phi1 - phi2);
		double dLam = Math.abs(lam1 - lam2);
		
		double a = Math.sin(0.5 * dPhi) * Math.sin(0.5 * dPhi) + Math.cos(phi1) * Math.cos(phi2) * Math.sin(0.5 * dLam) * Math.sin(0.5 * dLam);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c;
		
		return d;
	}
	
}
