//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count = new ArrayList<Integer>();
	private ArrayList<Character> letters = new ArrayList<Character>();
	private String fileName;

	public Histogram()
	{


	}

	public Histogram(char[] values, String fName)
	{
		fileName = fName;
		for (int i = 0; i<values.length; i++) {
			letters.add(values[i]);
			count.add(0);
		}




		out.println("search letters = "+letters);
	}

	public void loadAndAnalyzeFile() throws IOException
	{
		Scanner thing = new Scanner(new File(fileName));
		while (thing.hasNext()) {
			String text=thing.next();
			for (int i=0; i<text.length(); i++) {
				for (int j=0; j<letters.size(); j++) {
					if (text.charAt(i)==letters.get(j)) {
						count.set(j, count.get(j)+1);
					}
				}
			}
		}
	}

	public char mostFrequent()
	{
		int max=-1, t=0;
		for (int i=0; i<count.size(); i++) {
			if (count.get(i)>max) {
				max=count.get(i);
				t=i;
			}
		}
		return letters.get(t);
	}

	public char leastFrequent()
	{
		int min=Integer.MAX_VALUE, t=0;
		for (int i=0; i<count.size(); i++) {
			if (count.get(i)<min) {
				min=count.get(i);
				t=i;
			}
		}
		return letters.get(t);
	}

	public String toString()
	{
	   return fileName
	   + "\n" + letters
	   + "\n" + count + "\n\n\n";
	}
}