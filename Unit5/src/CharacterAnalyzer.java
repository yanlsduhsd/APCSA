//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class CharacterAnalyzer
{
	private char theChar;

	public CharacterAnalyzer()
	{


	}

	public CharacterAnalyzer(char c)
	{
		theChar=c;

	}

	public void setChar(char c)
	{
		theChar=c;

	}

	public char getChar()
	{
		return theChar;
	}

	public boolean isUpper( )
	{
		if (theChar<=90&&theChar>=65) {
			return true;
		}

		return false;
	}

	public boolean isLower( )
	{
		if (theChar<=122&&theChar>=97) {
			return true;
		}


		return false;
	}
	
	public boolean isNumber( )
	{
		if (theChar<=57&&theChar>=48) {
			return true;
		}


		return false;
	}	

	public int getASCII( )
	{
		return theChar;
	}

	public String toString()
	{
		if(isUpper()){
			return ""+getChar() + " is an uppercase character. ASCII == " + getASCII() + "\n";
		} else if (isLower()) {
			return ""+getChar() + " is a lowercase character. ASCII == " + getASCII() + "\n";
		} else if (isNumber()) {
			return ""+getChar() + " is a number. ASCII == " + getASCII() + "\n";
		} else {
			return ""+getChar() + " is none of the above. ASCII == " + getASCII() + "\n";
		}
		


			  
	}
}