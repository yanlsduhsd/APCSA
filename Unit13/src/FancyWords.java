//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class FancyWords
{
	private String[] wordRay;

	public FancyWords(String sentence)
	{
		setWords(sentence);
	}

	public void setWords(String sentence)
	{
		Scanner bob = new Scanner(sentence);
		int size=0;
		while (bob.hasNext()){
			size++;
			bob.next();
		}
		wordRay=new String[size];
		bob.close();
		bob = new Scanner(sentence);
		for (int i=0; i<wordRay.length; i++){
			wordRay[i]=bob.next();
		}
		bob.close();
	}

	public String toString()
	{
		String output="";
		int max = Integer.MIN_VALUE;
		
		for (String str: wordRay) {
			if (str.length()>max){
				max=str.length();
			}
		}
		for (int j=0; j<max;j++) {
			for (int i=wordRay.length-1; i>=0; i--) {
				if (wordRay[i].length()>j) {
					output+=wordRay[i].charAt(wordRay[i].length()-1-j);
				} else {
					output+=" ";
				}
			}
			output+="\n";
		}
		





		return output+"\n\n";
	}
}