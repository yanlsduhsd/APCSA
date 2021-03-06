//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Worde implements Comparable<Worde>
{
	private String word;

	public Worde( String s)
	{
		set(s);

	}

	public void set(String str){
		word=str;
	}
	public String get(){
		return word;
	}
	
	private int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;

		for (int i = 0; i<word.length(); i++) {
			for (int j = 0; j<vowels.length(); j++) {
				if (word.charAt(i)==vowels.charAt(j)) {
					vowelCount++;
				}
			}
		}





		return vowelCount;
	}

	public int compareTo( Worde rhs )
	{
		if (numVowels()>rhs.numVowels()) {
			return 1;
		} else if (numVowels()<rhs.numVowels()) {
			return -1;
		}
		
		return word.compareTo(rhs.get());
		
	}

	public String toString()
	{
		return word;
	}
}