//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Line
{
	private int xOne,yOne, xTwo, yTwo;
	private double slope;

	public Line(int x1, int y1, int x2, int y2)
	{
		setCoordinates(x1,y1,x2,y2);




	}

	public void setCoordinates(int x1, int y1, int x2, int y2)
	{
		xOne=x1;
		xTwo=x2;
		yOne=y1;
		yTwo=y2;




	}

	public void calculateSlope( )
	{
		slope=(((double)yTwo-yOne)/(xTwo-xOne));


	}

	public void print( )
	{
		System.out.printf("the slope is %.2f\n\n", slope);


	}
}