//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class Lab05d
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		
		out.print("Enter a letter :: ");
		char letter = keyboard.next().charAt(0);
		CharacterAnalyzer test = new CharacterAnalyzer(letter);
		out.println(test);   //A

		//add more test cases
		
		for (int i=1; i<21; i++) {
			out.print("Enter a letter :: ");
			letter = keyboard.next().charAt(0);
			test.setChar(letter);
			out.println(test);
		}
		
		
		System.out.print("hi");
		
		keyboard.close();
		

	}
}