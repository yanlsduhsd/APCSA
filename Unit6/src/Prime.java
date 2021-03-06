//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.lang.Math;

public class Prime
{
	private int number;

	public Prime()
	{
		number=2;

	}

	public Prime(int num)
	{
		number=num;

	}

	public void setPrime(int num)
	{
		number=num;

	}

	public boolean isPrime()
	{
		for (int i=2; i<=Math.sqrt(number);i++) {
			if (number%i==0) {
				return false;
			}
		}

		return true;
	}

	public String toString()
	{
		String prime=" not";
		if (isPrime()) {
			prime="";
		}
		String output=String.format("%s is%s prime.\n", number, prime);


		return output;
	}
}