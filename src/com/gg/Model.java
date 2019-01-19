package com.gg;
import FileParse.FileRead;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Main logic class. Calls helper classes/functions to perform data manipulation
 * 
 * @author Victor Velechovsky, Shawn Malik, Amandeep Panesar, Danish Nadeem, Taha Mian
 * @version 1.0
**/
public class Model {
	
	static Car [] carData;
	
	/**
	 * Get the car makes from the data file
	 * 
	 * @return array of car make strings
	 */
	public static String [] getMakes()  {
		
		carData = FileRead.parse(); //array of cars
		
		String [] make = new String[carData.length];
		
		for (int i = 0; i < carData.length; i++) {
			make[i]=carData[i].getMake();
		}
		
		LinkedHashSet<String> makeSet = new LinkedHashSet<>(); //Set used to remove duplicates
		
		for (Car c : carData) {
			makeSet.add(c.getMake());
		}
		
		String [] makes = makeSet.toArray(new String[makeSet.size()]);
		
		return makes;
		
	}
	
	/**
	 * Get the car years in string array format
	 * Years: 1985 - 2016
	 * 
	 * @return array of year strings
	 */
	public static String [] getYears() {
		
		String [] years = new String[32];
		
		for (int i = 0; i < years.length; i++) {
			years[i] = "" + (i + 1985);
		}
		
		return years;
	}
	
	/**
	 * Search for all cars matching a make and year
	 * 
	 * @param make - car make
	 * @param yr - production year
	 * @return String array of all matching car models
	 */
	public static String [] searchModels(String make, String yr) {
		return SearchLinear.LinearSearch(carData, yr, make);
	}
	
	public static Car getResult(String make, String year, String model) {
		
		Car carFound = SearchLinear.LinearSearchCAR(carData, year, make, model);
	
		return carFound;
		
	}

	/**
	 * Get a list of city names from the data file
	 * 
	 * @return String array of all the city names
	 */
	public static String[] getCityNames() {
		
		ArrayList<String> cityNames = new ArrayList<>();
		
		try {
			Scanner scanner = new Scanner(new File("cities_50.csv"));
			
			while (scanner.hasNextLine()) {
				String next = scanner.nextLine().split(",") [1];
				
				cityNames.add(next);
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return cityNames.toArray(new String [cityNames.size()]);
		
	}

}
