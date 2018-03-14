//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

class InsertionSort
{
	private ArrayList<String> list;

	public InsertionSort()
	{

		list = new ArrayList<String>();

	}

	//modfiers
	public void add( String  word)
	{
		int loc = 0;
		
		
		
		if (!list.contains(word)) {
			loc=Math.abs(Collections.binarySearch(list, word))-1;
			list.add(loc, word);
		}
		
		







	}


	public void remove(String word)
	{

		if (list.contains(word)) {
			list.remove(Collections.binarySearch(list, word));
		}




	}

	public String toString()
	{
		String output="";
		for (String str: list) {
			output+=(str+" ");
		}
		output+="\n";
		return output;
	}
}