//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab21g
{
	public static void main(String args[])
	{
		//instantiate an AtCounter
		AtCounter VanBuren = new AtCounter();

		//test the code
		VanBuren.countAts(0, 0);
		System.out.println("0 0 has "+VanBuren);
		VanBuren = new AtCounter();
		VanBuren.countAts(2, 5);
		System.out.println("2 5 has "+VanBuren);
		VanBuren = new AtCounter();
		VanBuren.countAts(5, 0);
		System.out.println("5 0 has "+VanBuren);
		VanBuren = new AtCounter();
		VanBuren.countAts(9, 9);
		System.out.println("9 9 has "+VanBuren);
		VanBuren = new AtCounter();
		VanBuren.countAts(3, 9);
		System.out.println("3 9 has "+VanBuren);
	}
}