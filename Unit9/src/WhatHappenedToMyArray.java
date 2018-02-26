import java.util.Arrays;

public class WhatHappenedToMyArray {

	public static void main(String[] args) {


		int[] array = {5, 10, 15, 20};
		System.out.println("My Original Array: " + Arrays.toString(array) + "\n");
		
		int[] referenceCopy = array;
		
		referenceCopy[0] = 0;
		
		System.out.println("The Copy of the Original Array reference: " + Arrays.toString(referenceCopy) + "\n");
		
		System.out.println("My Original Array after I modify the copy: " + Arrays.toString(array) + "\n");
		
		//when you make a copy of an array as in the example above you actually only make a new
		//reference of the original--- Copy just points to array
		
		//if you want a copy of an array that you can modify you need to copy the values of the original
		//into the new array as shown below.
		
		int[] original = {2, 4, 6, 8};
		System.out.println("My Second Original Array: " + Arrays.toString(original) + "\n");
		
		int[] newCopy = original.clone();
		
		newCopy[0] = 0;
		
		System.out.println("The Copy of the Original Array: " + Arrays.toString(newCopy) + "\n");
		
		System.out.println("My Original Array after I modify the copy: " + Arrays.toString(original) + "\n");
		
		//Or you can iterate through the original and copy values to the new array
		int[] secondCopy = new int[original.length];
		for(int i = 0; i < secondCopy.length; i++)
		{
			secondCopy[i] = original[i];
		}
		
		System.out.println("The Second Copy of the Original Array: " + Arrays.toString(secondCopy) + "\n");
		
	}

}
