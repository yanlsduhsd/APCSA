//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		set(s);
	}
	
	public void set(String str){
		word=str;
	}
	public String get(){
		return word;
	}

	public int compareTo( Word rhs )
	{
		if (word.length()>rhs.get().length()) {
			return 1;
		} else if (word.length()<rhs.get().length()) {
			return -1;
		}
		
		return word.compareTo(rhs.get());
		
	}

	public String toString()
	{
		return word;
	}
}