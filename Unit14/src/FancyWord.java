//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord
{
	private char[][] mat;

	public FancyWord()
	{
		mat = new char[0][0];
	}

   public FancyWord(String s)
	{
	   mat = new char[s.length()][s.length()];
	   
	   for (int i=0; i<s.length(); i++) {
		   for (int j=0; j<s.length(); j++) {
			   if (i==0||i==mat.length-1||Math.abs(s.length()-1-j)==i||j==i) {
				   mat[i][j]=s.charAt(j);
			   } else {
				   mat[i][j]=' ';
			   }
		   }
		   
	   }



	}

	public String toString()
	{
		String output="";
		
		for (int i = 0; i<mat.length; i++) {
			for (int j = 0; j<mat.length; j++) {
				output+=mat[i][j];
			}
			output+="\n";
		}





		return output+"\n\n";
	}
}