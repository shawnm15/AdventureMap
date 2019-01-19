package com.gg;


/**
 * Performs Merge Sort, as well as various other sort algorithms 
 * (which were tested for performance, before deciding to stick with merge sort)
 * 
 * @author Victor Velechovsky, Shawn Malik, Amandeep Panesar, Danish Nadeem, Taha Mian
 * @version 1.0
**/
public class Sort {
	
	/**
	 * Perform merge sort on an array of Car objects
	 * 
	 * @param x - array of Car objects
	 */
	public static void sortMerge(Car[] x) {
		int n = x.length;
		Car[] holder = new Car[n];
		recursiveMergeSort(x, holder, 0, x.length - 1);
	}

	/**
	 * Recursive merge sort function to sort by make
	 * 
	 * @param x - array of car objects
	 * @param holder - auxilarry array for x
	 * @param bottom - lo
	 * @param top - hi
	 */
	public static void recursiveMergeSort(Car[] x, Car[] holder, int bottom, int top) {

		if (top > bottom) {
			
			int midpoint = (bottom + top) / 2;
			
			recursiveMergeSort(x, holder, bottom, midpoint);
			recursiveMergeSort(x, holder, midpoint + 1, top);

			System.arraycopy(x, 0, holder, 0, x.length);

			int lowPos = bottom;
			int highPos = midpoint + 1;
			
			int i = bottom;
			
			while (i < top) {
				if (top < highPos) {
					x[i] = holder[lowPos];
					lowPos++;
				} else if (midpoint < lowPos) {
					x[i] = holder[highPos];
					highPos++;
				} else if (holder[highPos].getMake().compareToIgnoreCase(holder[lowPos].getMake()) < 0) {
					x[i] = holder[highPos];
					highPos++;
				} else {
					x[i] = holder[lowPos];
					lowPos++;
				}
				i++;
			}
		}

	}

	/**
	 * Perform merge sort based on year
	 * 
	 * @param x - array of Car objects
	 */
	public static void sortMergeYear(Car[] x) {
		int n = x.length;
		Car[] holder = new Car[n];
		recursiveMergeSort(x, holder, 0, x.length - 1);
	}

	/**
	 * Recursive merge sort function to sort by year
	 * 
	 * @param x - array of car objects
	 * @param holder - auxilarry array for x
	 * @param bottom - lo
	 * @param top - hi
	 */
	public static void recursiveMergeSortYear(Car[] x, Car[] holder, int bottom, int top) {

		if (top > bottom) {
			int midpoint = (bottom + top) / 2;
			recursiveMergeSort(x, holder, bottom, midpoint);
			recursiveMergeSort(x, holder, midpoint + 1, top);

			System.arraycopy(x, 0, holder, 0, x.length);

			int lowPos = bottom;
			int highPos = midpoint + 1;
			int i = bottom;
			while (i < top) {
				if (top < highPos) {
					x[i] = holder[lowPos];
					lowPos++;
				} else if (midpoint < lowPos) {
					x[i] = holder[highPos];
					highPos++;
					// } else if
					// ((holder[highPos].getYear()).compareTo(holder[lowPos].getYear())
					// < 0) {
				} else if (Integer.parseInt(holder[highPos].getYear()) < Integer.parseInt(holder[lowPos].getYear())) {
					x[i] = holder[highPos];
					highPos++;
				} else {
					x[i] = holder[lowPos];
					lowPos++;
				}
				i++;
			}
		}

	}

	/**
	 * Insertion sort for an array of Car Objects
	 * @param x - array of car objects
	 */
	public static void sortStringExchange(Car x[]) {
		int i, j;
		Car temp;

		for (i = 0; i < x.length - 1; i++) {
			for (j = i + 1; j < x.length; j++) {
					if (Integer.parseInt(x[i].getYear())>Integer.parseInt(x[j].getYear()) ) { // ascending
						temp = x[i];
						x[i] = x[j]; // swapping
						x[j] = temp;
					}
			}
		}
	}

}
