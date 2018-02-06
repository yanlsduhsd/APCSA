//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Lab02f
{
	public static void main( String[] args )
   {
		Line thing = new Line(1,2,3,4);
		thing.calculateSlope();
		thing.print();
		thing.setCoordinates(5, 2, 6, 0);
		thing.calculateSlope();
		thing.print();
		thing.setCoordinates(678, 342, 2546, -435);
		thing.calculateSlope();
		thing.print();
		thing.setCoordinates(342, 43, 12, 547);
		thing.calculateSlope();
		thing.print();
		thing.setCoordinates(-555, -2, -56, 99);
		thing.calculateSlope();
		thing.print();
		thing.setCoordinates(1, 1, 4, 2);
		thing.calculateSlope();
		thing.print();
	}
}