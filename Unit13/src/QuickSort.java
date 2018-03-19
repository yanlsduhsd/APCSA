//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  - 

import static java.lang.System.*;
import java.util.Arrays;		//use Arrays.toString() to help print out the array

public class QuickSort
{
	private static int passCount;

	public static void quickSort(Comparable[] list)
	{
		passCount=0;
		quickSort(list, 0, list.length-1);
	}



	private static void quickSort(Comparable[] list, int low, int high)
	{
		if (low<high) {
			System.out.println("pass "+passCount+" "+Arrays.toString(list));
			passCount++;
			int split = partition(list, low, high);
			quickSort(list, low, split);
			quickSort(list, split+1, high);
		}


	}


	private static int partition(Comparable[] list, int low, int high)
	{
		Comparable pivot=list[low];
		int bot=low;
		int top=high;
		
		while(bot < top){

			while (list[bot].compareTo(pivot)<0){
				bot++;
			}
			while (list[top].compareTo(pivot)>0){
				top--;
			}
			
			if (bot <= top)
			{
				Comparable temp;
				temp= list[bot];
				list[bot]=list[top];
				list[top]=temp;
			}
			
			
		}
		return bot;
	
	}
}