// Name: Abraham Johnson
// Class ID: 314
// Assignment #: 2
// Contents: This file contains a method that creates an array of size 10 and other methods which allow you to do things
//           with that array such as add numbers to the beginning of the array, search the array, remove elements, and 
//			 display the array in order. It also can increase and decrease the size of the array when meeting certain requirements.
// Github: https://github.com/honestabej/honestabej

package cse360assign2;



public class SimpleList {
	private int simpleList[];
	private int count;
	private int length;
	
	// Initializes the array of size 10 and count at 0
	public SimpleList() {
		simpleList = new int[10];
		count = 0;
	}
	
	// Allows for adding a number at the beginning of the array (index 0)
	public void add(int number) {
		// If array is not full enter this statement
		if (count < simpleList.length){	
			for (int i = count - 1; i >= 0; i--) {
				simpleList[i+1] = simpleList[i]; 									// Shift all elements over right by one
			}
			simpleList[0] = number; 				
			count++; 																// Increment the count accordingly
			length = simpleList.length;
			
		// If array is full enter this statement
		} else { 
			int [] temp = new int[simpleList.length];								// create temp array
			for (int i = 0; i < simpleList.length; i++) {
				temp[i] = simpleList[i];											// copy the simpleList array into the temp array
			}
			int increaseBy = (int) (simpleList.length + (simpleList.length*.5));	// determine size of new array
			simpleList = new int[increaseBy];										// reinitialize the simpleList array to the new size
			for (int i = 0; i < temp.length; i++) {									// copy the temp array into the new simpleList
				simpleList[i] = temp[i];
			}
			for (int i = count - 1; i >= 0; i--) {
				simpleList[i+1] = simpleList[i]; 									// Shift all elements over right by one
			}
			simpleList[0] = number; 
			count++;
			length = simpleList.length;
		}
	}
	
	// Adds a number on to the end of the array
	public void append(int number) {
		// If array is not full enter this statement
		if (count < simpleList.length){	
			simpleList[count] = number; 				
			count++; 																// Increment the count accordingly
			length = simpleList.length;
		// If array is full enter this statement
		} else { 
			int [] temp = new int[simpleList.length];								// create temp array
			for (int i = 0; i < simpleList.length; i++) {
				temp[i] = simpleList[i];											// copy the simpleList array into the temp array
			}
			int increaseBy = (int) (simpleList.length + (simpleList.length*.5));	// determine size of new array
			simpleList = new int[increaseBy];										// reinitialize the simpleList array to the new size
			for (int i = 0; i < temp.length; i++) {									// copy the temp array into the new simpleList
				simpleList[i] = temp[i];
			}
			simpleList[count] = number; 
			count++;
			length = simpleList.length;
		}
	}
	
	// Find the location of the element to be removed and then shift the array over it, essentially deleting it
	public void remove(int number) {
		int loop = count;
		while (loop > 0) {															// make sure to loop this so repeat numbers will all be deleted
			// Find the location
			int marker = search(number);
			
			// Verify that the element was actually found
			if (marker != -1) { 
				for (int i = marker; i < count - 1; i++) {
					simpleList[i] = simpleList[i+1];								// Shift all elements over left one, deleting original element at marker	
				}
				count--; 															// Adjust count to account for the deleted number
			}
			loop--;
		}
		
		// lower the size if 25% are empty
		if (count < simpleList.length*.75) {
			int [] temp = new int[simpleList.length];								// create temp array
			for (int i = 0; i < simpleList.length; i++) {
				temp[i] = simpleList[i];											// copy the simpleList array into the temp array
			}
			int decreaseBy = (int) (simpleList.length - (simpleList.length*.25));	// determine size of new array
			simpleList = new int[decreaseBy];
			for (int i = 0; i < simpleList.length; i++) {							// copy the temp array into the new simpleList
				simpleList[i] = temp[i];
			}
			length = simpleList.length;
		}
		
	}
	
	// Just returns the number stored in count
	public int count() {
		return count;
	}
	
	// Returns the length of simpleList
	public int size() {
		return length;
	}
	
	// Returns first element of the list
	public int first() {
		if (count != 0) {
			return simpleList[0];
		} else {
			return -1;
		}
	}
	
	// Returns last element of the list
	
	// Creates a string and concats the ints in the array onto the end of it with spaces in between numbers
	@Override
	public String toString() {
		String string = "";
		for (int i = 0; i < count; i++) {
			string = string + simpleList[i]; 		// Add the number to the end of the string
			if (i < count -1) {
				string = string + " "; 				// add a space after the number, except for the last number
			}
		}
		return string;
	}
	
	// Searches for a number in the array and returns its location or -1 if not found
	public int search(int number) {
		int marker = -1; 							// Assume the number is not found at beginning of method
		for (int i = 0; i < count; i++) {
			if (simpleList[i] == number) {
				marker = i; 						// mark the index that the number was found at
			}
		}
		return marker;	
	}
	

}
