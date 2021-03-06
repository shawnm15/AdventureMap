package com.gg;

import java.util.Arrays;

/**
 * Data type that represents a city/stop
 * 
 * @author Victor Velechovsky, Shawn Malik, Amandeep Panesar, Danish Nadeem, Taha Mian
 * @version 1.0
**/
public class City {

	String state; //List of states that the city is located in
	String name; //Name of city
	double lat, lng; //Latitude and Longitude of city
	int interestFactor;
	
	//Generated by eclipse
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + interestFactor;
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	//Generated by eclipse
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (interestFactor != other.interestFactor)
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}


	/**
	 * Create a City object
	 * 
	 * @param states - list of states that the city is located in
	 * @param name - name of the City
	 */
	public City (String state, String name, double lat, double lng, int interestFactor) {
		this.state = state;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.interestFactor = interestFactor;
	}


	/**
	 * @return String representation of the City's data
	 */
	public String toString() {
		return "City - " + name + " : State - " + state + " : Lat - " + lat + " : Lng - " + lng;
	}

	
	//------GETTER AND SETTER METHODS-------//
	
	/**
	 * @return - the name of the City
	 */
	public String getName() { return name; }
	
	/**
	 * @return - latitude
	 */
	public double getLat() { return lat; }
	
	/**
	 * @return - longitude
	 */
	public double getLng() { return lng; }
	
	/**
	 * @return - list of state codes that the city is located in
	 */
	public String getState() { return state; }

	
}
