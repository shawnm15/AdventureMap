package com.gg;

/**
 * Object to represent a car
 * 
 * @author Victor Velechovsky, Shawn Malik, Amandeep Panesar, Danish Nadeem, Taha Mian
 * @version 1.0
**/
public class Car implements CarData {
	
	private String Year;
	private String Model;
	private String Make;
	private String Gas;
	private String City;
	private String Highway;
	private boolean isGasGuzzler;
	private String Trans;
	
    /*
     * Create a car object
     *
     * @param inYear year of the car
     * @param inModel model of the car
     * @param inMake make of the car
     * @param inGas fuel efficiency of the car
     * @param transmission type
     * @param City city fuel economy
     * @param Highway highway fuel economy
    */
	public Car(String inYear, String inModel, String inMake, String inGas, String inTrans, String City, String Highway) {
		
		if (inMake.substring(0, 1).equals("\"")) { //Clean up string
			inMake = inMake.replace("\"", "");
		}
		this.Year = inYear;
		this.Model = inModel;
		this.Make = inMake;
		this.Gas = inGas;
		this.Trans = inTrans;
		this.City = City;
		this.Highway = Highway;

		if (inGas.equals("T") || inGas.equals("G")) { //Determine if car is a gas guzzler
			this.isGasGuzzler = true;
		} else {
			this.isGasGuzzler = false;
		}

	}
	
	/**
     * Calculate the combined fuel economy of the car and return it as an int
    **/
	public int getFuel(){
		int city = (int)(Integer.parseInt(City));
		int high = (int)(Integer.parseInt(Highway));
		int fuel = (int)(city*0.2)+(int)(high*0.8);
		return fuel;
		
	}

	/**
	 * Return a human-readable string of all the Car's data in the form:
	 * Year: [Year], Make: [Make], Model: [Model], Result: [Gas Guzzler?], Transmission: [Transmission Type]
	 */
	public String toString() {
		String s = "";

		s += "Year: " + getYear() + ", " + "Make: " + getMake() + ", " + "Model: " + getModel() + ", " + "Result: "
				+ getGas() + ", " + "Transmission: " + getTrans();

		return s;

	}

    //---------GETTER AND SETTER METHODS---------------//

	public Car(String Model) {
		this.Model = Model;
	}

	@Override
	public String getYear() {
		return Year;
	}

	@Override
	public String getModel() {
		return Model;
	}

	@Override
	public String getMake() {
		return Make;
	}

	public String getGas() {
		return Gas;
	}

	public void setMake(String make) {
		this.Make = make;
	}

	public void setModel(String Model) {
		this.Model = Model;
	}

	public void setYear(String year) {
		this.Year = year;
	}

	private String getTrans() {
		return Trans;
	}

	public boolean isGasGuzzler() {
		if (isGasGuzzler || ((int) (Integer.parseInt(City)) < 24 || (int) (Integer.parseInt(Highway)) < 30)) {
			return true;
		} else {

			return isGasGuzzler;
		}
	}

	@Override
	public String getCity() {
	
		return City;
	}

	@Override
	public String getHighway() {
	
		return Highway;
	}

	@Override
	public String isGassGuzzler() {
		// TODO Auto-generated method stub
		return null;
	}

}
