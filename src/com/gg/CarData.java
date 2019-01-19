package com.gg;

/**
 * API that represents a Car
 * 
 * @author Victor Velechovsky, Shawn Malik, Amandeep Panesar, Danish Nadeem, Taha Mian
 * @version 1.0
**/
public interface CarData {
	
	public String getYear();
	public String getMake();
	public String getModel();
	public String toString(); 
	public String getCity();
	public String getHighway();
	public String isGassGuzzler();
	
}
