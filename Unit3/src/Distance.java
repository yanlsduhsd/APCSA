//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Distance
{
	private int xOne,yOne,xTwo,yTwo;
	private double distance;
	private Scanner keyboard = new Scanner(System.in);
	
	public Distance()
	{
		setCoordinates();


	}

	public Distance(int x1, int y1, int x2, int y2)
	{
		xOne=x1;
		xTwo=x2;
		yOne=y1;
		yTwo=y2;


	}

	public void setCoordinates(int x1, int y1, int x2, int y2)
	{

		xOne=x1;
		xTwo=x2;
		yOne=y1;
		yTwo=y2;

	}
	public void setCoordinates()
	{
		System.out.print("Enter X1 :: ");
		xOne=keyboard.nextInt();
		System.out.print("Enter Y1 :: ");
		yOne=keyboard.nextInt();
		System.out.print("Enter X2 :: ");
		xTwo=keyboard.nextInt();
		System.out.print("Enter Y2 :: ");
		yTwo=keyboard.nextInt();
		
 	}
	public void calcDistance()
	{

		distance=Math.sqrt(Math.pow(xOne-xTwo, 2)+Math.pow(yOne-yTwo, 2));

	}

	public void print( )
	{
		System.out.printf("distance == %.3f\n\n\n",distance);


	}
}