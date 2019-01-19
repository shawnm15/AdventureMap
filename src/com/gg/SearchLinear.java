package com.gg;

import java.util.LinkedHashSet;

/**
 * Performs Linear Search functionality
 * 
 * @author Victor Velechovsky, Shawn Malik, Amandeep Panesar, Danish Nadeem, Taha Mian
 * @version 1.0
**/
public class SearchLinear {
	
	public static String[] LinearSearch(Car[] data, String Year, String Make) {
		
		LinkedHashSet<String> modelWithoutDuplicates = new LinkedHashSet<>(); //Use a set to avoid duplicates
		
		for (int i = 0; i < data.length; i++) {
			if (Make.equalsIgnoreCase(data[i].getMake())) {
				if (Year.equalsIgnoreCase(data[i].getYear())) {
					modelWithoutDuplicates.add(data[i].getModel());
				}
			}
		}
		
		String[] Model;
		
		return Model = modelWithoutDuplicates.toArray(new String[modelWithoutDuplicates.size()]);

	}

	public static Car LinearSearchCAR(Car[] data, String Year, String Make, String Model) {
		Car car = null;
		for (int i = 0; i < data.length; i++) {

			if (Make.equalsIgnoreCase(data[i].getMake())) {
				if (Year.equalsIgnoreCase(data[i].getYear())) {
					if (Model.equals(data[i].getModel())) {
						car = data[i];
					}
				}
			}
		}

		return car;

	}
}
