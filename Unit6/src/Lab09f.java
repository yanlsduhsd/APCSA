//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab09f
{
	public static void main( String args[] )
	{
		//add test cases
		LetterRemover thing = new LetterRemover("I am Sam I am",'a');
		System.out.println(thing);
		thing.setRemover("sssssssssssssxsssssssessssse", 's');
		System.out.println(thing);
		thing.setRemover("qwertyqwerty", 'a');
		System.out.println(thing);
		thing.setRemover("ababababababababababa", 'b');
		System.out.println(thing);
		thing.setRemover("dFjfkaLeFnBdkskfdrDsalFVBdkd", 'd');
		System.out.println(thing);
	}
}