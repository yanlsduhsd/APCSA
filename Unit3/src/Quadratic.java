//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Quadratic
{
	private int a, b, c;
	private double rootOne;
	private double rootTwo;
	private Scanner keyboard = new Scanner(System.in);
	
	public Quadratic()
	{
		a=1;
		b=0;
		c=0;

	}

	public Quadratic(int quadA, int quadB, int quadC)
	{
		a=quadA;
		b=quadB;
		c=quadC;

	}

	public void setEquation(int quadA, int quadB, int quadC)
	{
		a=quadA;
		b=quadB;
		c=quadC;
 	}
	
	public void setEquation()
	{
		System.out.print("Enter a :: ");
		a=keyboard.nextInt();
		System.out.print("Enter b :: ");
		b=keyboard.nextInt();
		System.out.print("Enter c :: ");
		c=keyboard.nextInt();
 	}
	
	public void calcRoots( )
	{
		rootOne=(-1*b+Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
		rootTwo=(-1*b-Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
	}

	public void print( )
	{
		System.out.printf("\n\nrootone :: %.2f\nroottwo :: %.2f\n\n\n",rootOne,rootTwo);

	}
}