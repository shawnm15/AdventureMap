package com.gg;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

import FileParse.FileRead;

/**
 * Performs Search functionality
 * 
 * @author Victor Velechovsky, Shawn Malik, Amandeep Panesar, Danish Nadeem, Taha Mian
 * @version 1.0
**/
public class Search {
	
	  /**
	   * Perform binary search based on a given car make
	   * 
	   * @param a - list of cars
	   * @param Make - car Make
	   * @return index value of search result
	   */
	  public static int binarySearch(Car[] a, String Make) { 
		    int lo = 0; 
		    int hi = a.length - 1; 
		    while (lo <= hi) { 
		      // Key is in a[lo..hi] or not present. 
		      int mid = lo + (hi - lo) / 2; 
		      if (Make.compareToIgnoreCase(a[mid].getMake()) < 0) 
		        hi = mid - 1; 
		      else if (Make.compareToIgnoreCase(a[mid].getMake()) > 0) 
		        lo = mid + 1; 
		      else 
		        return mid; 
		    } 
		    return -1; 
		  } 
	
	  /**
	   * Perform binary search based on a given car year
	   * 
	   * @param a - list of cars
	   * @param Year - car year
	   * @return index value of search result
	   */
	  public static int binarySearchYear(Car[] a, String Year) { 
		    int lo = 0; 
		    int hi = a.length - 1; 
		    int yearKey = Integer.parseInt(Year); 
		    System.out.println("Value of hi: " + hi); 
		    while (lo <= hi) { 
		      // Key is in a[lo..hi] or not present. 
		      int mid = lo + (hi - lo) / 2; 
		      System.out.println("Comparing : " + Integer.parseInt(a[mid].getYear()) + " VS " + yearKey + " Value of Mid : " + mid); 
		      if (Integer.parseInt(a[mid].getYear())>yearKey) 
		        hi = mid - 1; 
		      else if (Integer.parseInt(a[mid].getYear())<yearKey) 
		        lo = mid + 1; 
		      else 
		        return mid; 
		    } 
		    return -1; 
		  } 
	  
	  /**
	   * Search for car models based on a given make and year
	   * 
	   * @param a - list of cars
	   * @param Make - car Make
	   * @param Year - year of the car
	   * @return String array of all matching model names
	   */
	  public static String[] searchModel(Car[] a, String Make, String Year) { 
		  
		    int Key = binarySearch(a, Make); 
		   
		    Car[] resultModel = linearsearch(a, Key, Make); 
		    Sort.sortStringExchange(resultModel); 
		 
		    int YearKey = binarySearchYear(resultModel,Year); 
		    
		    for (int i = 0; i < resultModel.length; i++) {
				System.out.println(resultModel[i].toString());
			   }
		    
		    System.out.println("The Value of YearKey: " + YearKey); 
		    
		    Car[] finalResult = linearsearchYear(resultModel, YearKey, Year); 
		    String[] Model = new String [finalResult.length];
		    
		    for (int i = 0; i < Model.length; i++) {
				Model[i]= finalResult[i].getModel();
			}
		    
		   LinkedHashSet<String> modelWithoutDuplicates = new LinkedHashSet<>(); //Use a set to avoid duplicates
		   
		   for (String s : Model)
			   modelWithoutDuplicates.add(s);
		   
		   Model = modelWithoutDuplicates.toArray(new String [modelWithoutDuplicates.size()]);
		 
		    return Model;
		  } 
	  
	  /**
	   * Perform linear search based on a given car make
	   * 
	   * @param a - list of cars
	   * @param bsIndex - index value of the base
	   * @param key - search value
	   * 
	   * @return Car object matching the search
	   */
	  public static Car[] linearsearch(Car[] a, int bsIndex, String key) { 

		    ArrayList<Car> carList = new ArrayList<Car>(); 
		    ArrayList<Integer> list = new ArrayList<Integer>(); 

		    int begin = bsIndex; 
		    int end = bsIndex; 
		    if (bsIndex >= 0) { 
		      while (begin > 0 && a[begin - 1].getMake().equals(key)) { 
		        list.add(begin); 
		 
		        carList.add(a[begin]); 
		        begin--; 
		      } 
		      list.add(bsIndex); 
		      carList.add(a[bsIndex]); 
		      while (end < a.length - 1 && a[end + 1].getMake().equals(key)) { 
		        list.add(end); 
		        carList.add(a[end]); 
		        end++; 
		      } 
		    } 
		    Car[] array = carList.toArray(new Car[carList.size()]); 
		    
		    Sort.sortMerge(array); 

		    return array; 
		  }
	  
	  /**
	   * Perform a linear search for a Car based on the year
	   * 
	   * @param a - list of cars
	   * @param Make - car Make
	   * @return index value of search result
	   */
	  public static Car[] linearsearchYear(Car[] a, int bsIndex, String key) { 
		  
		    ArrayList<Car> carList = new ArrayList<Car>(); 
		    ArrayList<Integer> list = new ArrayList<Integer>(); 
		    int begin = bsIndex; 
		    int end = bsIndex; 
		    if (bsIndex >= 0) { 
		      System.out.println("THE ARRAY HAS THE VALUE OF " + Integer.parseInt(a[begin - 1].getYear())+" Value of the key " + Integer.parseInt(key)); 
		      while (begin > 0 && Integer.parseInt(a[begin - 1].getYear())==Integer.parseInt(key)) { 
		        System.out.println("THE ARRAY HAS THE VALUE OF " + Integer.parseInt(a[begin - 1].getYear())+" Value of the key " + Integer.parseInt(key)); 
		        list.add(begin); 
		 
		        carList.add(a[begin]); 
		        begin--; 
		      } 
		      list.add(bsIndex); 
		      while (end < a.length - 1 && Integer.parseInt(a[end + 1].getYear())==Integer.parseInt(key)) { 
		        list.add(end); 
		        carList.add(a[end]); 
		        end++; 
		      } 
		    } 
		    System.out.println("THE LENGTH OF ARRAY LIST: " + carList.size()); 
		    Car[] array = carList.toArray(new Car[carList.size()]); 
		    Sort.sortMergeYear(array); 
		     
		    return array; 
		  } 
		 
		  public static void main(String[] args) throws FileNotFoundException { 
		    Car carArray[] = FileRead.parse(); 
		    Sort.sortMerge(carArray); 
	 
		 
		    String key = "Acura"; 
		    String[] resultModelFind = searchModel(carArray, key, "2016"); 
		    for (int i = 0; i < resultModelFind.length; i++) {
				System.out.println(resultModelFind[i]);
			}
		 
	  } 
	
}
